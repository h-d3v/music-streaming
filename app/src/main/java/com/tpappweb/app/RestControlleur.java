package com.tpappweb.app;

import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IArtisteService;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Juste un essai
 */

@RestController
public class RestControlleur {
    @Autowired
    private IUtilisateurService iUtilisateurService;


    @GetMapping("utilisateurs/{pseudo}")
    public ResponseEntity<Utilistateur> getUtilisateur(@PathVariable("pseudo") String pseudo){
        Utilistateur utilistateur=iUtilisateurService.getUtilisateur(pseudo);
        return new ResponseEntity<Utilistateur>(utilistateur, HttpStatus.OK);
    }
    @DeleteMapping("deleteCompte/{pseudo}")
        public String supprimmerCompte(@PathVariable("pseudo") String pseudo){
        Utilistateur utilistateur=iUtilisateurService.getUtilisateur(pseudo);
        iUtilisateurService.supprimerUtilisateur(utilistateur);
        return "sbbbbs";
    }

    @GetMapping("utilisateurs")
    public List<Utilistateur> getTousLesUtilisateurs(){
        return iUtilisateurService.trouverTous();
    }

    //test du asrtisteService
    @Autowired
    private IArtisteService artisteService;
    @RequestMapping("artiste/{id}")
    public ResponseEntity<Artiste> getArticleById(@PathVariable("id") Integer id){
        Artiste artiste = artisteService.getArtisteById(id);
        return new ResponseEntity<Artiste>(artiste, HttpStatus.OK);
    }

    @GetMapping("artistes")
    public List<Artiste> getArtistes(){
        return artisteService.trouverTous();

    }


}
