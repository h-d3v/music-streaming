package com.tpappweb.app;

import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class ProfilControlleur {
    @Autowired
    private IUtilisateurService iUtilisateurService;

    @RequestMapping("/profile")
    public String voirProfile(HttpSession httpSession){
        return "profile";
    }
    @PostMapping("modifierMotPasse")
        public String modifierMotPasse(WebRequest webRequest, ModelMap modelMap, HttpSession httpSession){
            Utilistateur utilisateurExistant = (Utilistateur) httpSession.getAttribute("utilisateurConnecte");
            Utilistateur utilistateur = new Utilistateur();
            utilistateur.setPseudo(utilisateurExistant.getPseudo());
            utilistateur.setCourriel(webRequest.getParameter("email"));
            utilistateur.setMotPasse(webRequest.getParameter("vieuxpassword"));
           boolean succes= iUtilisateurService.modifierMotPasse(utilistateur,
                    webRequest.getParameter("Nouveaupassword"));
            modelMap.addAttribute("succes", succes);
        return "profile";
    }

}
