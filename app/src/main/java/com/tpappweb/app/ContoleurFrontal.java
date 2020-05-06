package com.tpappweb.app;


import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ITitreService;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ContoleurFrontal {
    @Autowired
    private IUtilisateurService iUtilisateurService;

    @Autowired
    private ITitreService iTitreService;

    @RequestMapping("/")
    public String welcome(HttpSession httpSession){
        if(httpSession.getAttribute("utilisateurConnecte")==null){
            return "index";
        }
        else return "player";

    }

    @RequestMapping("/seDeconnecter")
    public String seDeconnecter(HttpSession httpSession) {
        if (httpSession != null) {
            httpSession.invalidate();
        }
        return "index";
    }

    @PostMapping(path = "titres/add", consumes = "application/x-www-form-urlencoded")
    public Titre ajouterTitre(WebRequest webRequest, ModelMap modelMap){
        Titre titre =new Titre();
        titre.setNomArtiste(webRequest.getParameter("auteur"));
        titre.setDuree(Integer.valueOf(webRequest.getParameter("duree")));
        titre.setNom(webRequest.getParameter("titre"));
        titre.setDateSortie(webRequest.getParameter("date"));
        titre.setGenre(webRequest.getParameter("genre"));
        titre.setTitreAlbum(webRequest.getParameter("album"));
        titre.setUrl(modelMap.getAttribute("cheminAudio").toString());
        titre.setUrlImage(modelMap.getAttribute("cheminPhoto").toString());
        if( iTitreService.addTitre(titre)){return titre;}
        else return null;

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
            modelMap.addAttribute("messageErreurSignUp", "nom d'utilisateur invalide ou existant");
        }

        return welcome(httpSession);
    }


    @PostMapping(path = "/player")
    public String seConnecter(HttpSession httpSession, WebRequest webRequest, ModelMap modelMap){

        if(httpSession.getAttribute("utilisateurConnecte")==null){
            Utilistateur utilistateur=new Utilistateur();
            utilistateur.setPseudo(webRequest.getParameter("pseudo"));
            utilistateur.setMotPasse(webRequest.getParameter("motPasse"));
            utilistateur.setCourriel(webRequest.getParameter("courriel"));
            try{
                if(utilistateur.equals(iUtilisateurService.getUtilisateur(utilistateur.getPseudo()))){
                httpSession.setAttribute("utilisateurConnecte", utilistateur);
                }
                else{
                        modelMap.addAttribute("messageErreur", "tentative de connexion  non valide" );
                    }

            }catch (EmptyResultDataAccessException e){
                modelMap.addAttribute("messageErreurCnx", "tentative de connexion  non valide" );
            }

        }
        return welcome(httpSession);

    }




}
