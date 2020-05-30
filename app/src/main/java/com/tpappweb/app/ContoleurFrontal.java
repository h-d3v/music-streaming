package com.tpappweb.app;


import com.tpappweb.app.entites.PlayList;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IPlayListServices;
import com.tpappweb.app.service.interfaces.ITitreService;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class ContoleurFrontal {
    @Autowired
    private IUtilisateurService iUtilisateurService;
    @Autowired
    private IPlayListServices iPlayListServices;
    @Autowired
    private ITitreService iTitreService;


    @GetMapping("/")
    public String welcome(HttpSession httpSession, ModelMap modelMap){
        if(httpSession.getAttribute("utilisateurConnecte")==null){
            return "index";
        } else {
            if (modelMap.containsAttribute("playlistsUtilisateur")) {
                modelMap.replace("playlistsUtilisateur", iPlayListServices.chercherPlayListsParUtilisateur(
                        (Utilistateur) httpSession.getAttribute("utilisateurConnecte")));
            }else{
                modelMap.addAttribute("playlistsUtilisateur", iPlayListServices.chercherPlayListsParUtilisateur(
                        (Utilistateur) httpSession.getAttribute("utilisateurConnecte")));
            }
            modelMap.addAttribute("genres", iTitreService.trouverTousLesGenres());
        }
         return "player";
    }

    @RequestMapping("/playlist/{genre}")
    public String chargerPlayListParGenre(HttpSession httpSession, ModelMap modelMap, @PathVariable("genre") String genre){
        if(httpSession.getAttribute("utilisateurConnecte")==null)return "index";
        if(modelMap.getAttribute("titresLectureActuelle")==null){
            PlayList playList =iPlayListServices.creerPlaylistParGenre(genre);
            modelMap.addAttribute("titresLectureActuelle", playList);
        }else modelMap.replace("titresLectureActuelle", iPlayListServices.creerPlaylistParGenre(genre));

        return welcome(httpSession, modelMap);
    }





    @RequestMapping("/seDeconnecter")
    public String seDeconnecter(HttpSession httpSession) {
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "index";
    }

    //test
    @RequestMapping("/playlist")
    public String voirPlaylist(HttpSession httpSession){
        return "playlist";
    }


    @RequestMapping("/playlist/{utilisateur}/{id}")
    public String afficherPlayList(HttpSession httpSession, ModelMap modelMap, @PathVariable("id") int id, @PathVariable("utilisateur")String utilisateur){
        if(httpSession.getAttribute("utilisateurConnecte")==null)return "index";
        if(modelMap.getAttribute("titresLectureActuelle")==null){
            PlayList playList =iPlayListServices.chercherPlayListParID(id);
            modelMap.addAttribute("titresLectureActuelle", playList);
        }else modelMap.replace("titresLectureActuelle", iPlayListServices.chercherPlayListParID(id));

        return welcome( httpSession,  modelMap);
    }


    //test
    @RequestMapping("/profile")
    public String voirProfile(HttpSession httpSession){
        return "profile";
    }

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public String  sinscrire(HttpSession httpSession, WebRequest webRequest, ModelMap modelMap) {

        if("".equals(webRequest.getParameter("pseudo"))){
            modelMap.addAttribute("messageErreurSignUp", "nom d'utilisateur invalide ou existant");
        }

        Utilistateur utilistateur=new Utilistateur();
        utilistateur.setPseudo(webRequest.getParameter("pseudo"));
        utilistateur.setMotPasse(webRequest.getParameter("motPasse"));
        utilistateur.setCourriel(webRequest.getParameter("courriel"));

        try{
            if(iUtilisateurService.ajouterUtilisateur(utilistateur)){
                httpSession.setAttribute("utilisateurConnecte", utilistateur);
            }
        }
        catch (DuplicateKeyException e){
            modelMap.addAttribute("messageErreurSignUp", "nom d'utilisateur existant existant");
        }

        return welcome(httpSession, modelMap);
    }


    @PostMapping(path = "/player", consumes = "application/x-www-form-urlencoded")
    public String seConnecter(HttpSession httpSession, WebRequest webRequest, ModelMap modelMap){
        //Connection utilisateur
        if(httpSession.getAttribute("utilisateurConnecte")==null){
            Utilistateur utilistateur=new Utilistateur();
            utilistateur.setPseudo(webRequest.getParameter("pseudo"));
            utilistateur.setMotPasse(webRequest.getParameter("motPasse"));
            utilistateur.setCourriel(webRequest.getParameter("courriel"));
            try{
                if(utilistateur.equals(iUtilisateurService.getUtilisateur(utilistateur.getPseudo()))){
                    utilistateur.setPlayLists(iPlayListServices.chercherPlayListsParUtilisateur(utilistateur));
                httpSession.setAttribute("utilisateurConnecte", utilistateur);
                }
                else{
                        modelMap.addAttribute("messageErreur", "tentative de connexion  non valide" );
                    }

            }catch (EmptyResultDataAccessException e){
                modelMap.addAttribute("messageErreurCnx", "tentative de connexion  non valide" );
            }



        }
        return welcome(httpSession, modelMap);
    }
}
