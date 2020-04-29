package com.tpappweb.app;


import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ContoleurFrontal {
    @Autowired
    private IUtilisateurService iUtilisateurService;

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


    @PostMapping(path = "/player")
    public void seConnecter(HttpSession httpSession, WebRequest webRequest){

        if(httpSession.getAttribute("utilisateurConnecte")==null){
            Utilistateur utilistateur=new Utilistateur();
            utilistateur.setPseudo(webRequest.getParameter("pseudo"));
            utilistateur.setMotPasse(webRequest.getParameter("motPasse"));
            utilistateur.setCourriel(webRequest.getParameter("courriel"));
            //TODO Exceptions sur pseudo invalide DAO
            if(utilistateur.equals(iUtilisateurService.getUtilisateur(utilistateur.getPseudo()))){
                httpSession.setAttribute("utilisateurConnecte", utilistateur);
            }
        }

    }




}
