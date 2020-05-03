package com.tpappweb.app;

import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IArtisteService;
import com.tpappweb.app.service.interfaces.ITitreService;
import com.tpappweb.app.service.interfaces.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Juste un essai
 */

@RestController
public class RestControlleur {
    @Autowired
    IUtilisateurService iUtilisateurService;

    @Autowired
    ITitreService titreService;

    @Autowired
    private IArtisteService artisteService;

    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public Utilistateur  sinscrire(Utilistateur utilistateur) {
        iUtilisateurService.ajouterUtilisateur(utilistateur);

        return utilistateur;
    }
    @GetMapping("utilisateurs/{pseudo}")
    public ResponseEntity<Utilistateur> getUtilisateur(@PathVariable("pseudo") String pseudo){
        Utilistateur utilistateur=iUtilisateurService.getUtilisateur(pseudo);
        return new ResponseEntity<Utilistateur>(utilistateur, HttpStatus.OK);
    }

    @GetMapping("utilisateurs")
    public List<Utilistateur> getTousLesUtilisateurs(){
        return iUtilisateurService.trouverTous();
    }

    //test du asrtisteService

    @RequestMapping("artiste/{id}")
    public ResponseEntity<Artiste> getArticleById(@PathVariable("id") Integer id){
        Artiste artiste = artisteService.getArtisteById(id);
        return new ResponseEntity<Artiste>(artiste, HttpStatus.OK);
    }

    @GetMapping("artistes")
    public List<Artiste> getArtistes(){
        return artisteService.trouverTous();
    }

    //pour modifier un artiste
   @PutMapping("artiste")
   public ResponseEntity<Artiste> updateArtiste(@RequestBody Artiste artiste) {
       artisteService.updateArtiste(artiste);
       return new ResponseEntity<>(artiste, HttpStatus.OK);
   }

   @RequestMapping("titre/{id}")
   public ResponseEntity<Titre> getUtilisateur(@PathVariable("id") int id){
       Titre titre=titreService.getTitreById(id);
       return new ResponseEntity<>(titre, HttpStatus.OK);
   }

    @RequestMapping("titres")
    public List<Titre> getTitres(){
        List<Titre> titreList =titreService.trouverTous();
        for (Titre unTitre:
             titreList) {
            Artiste artiste=artisteService.getArtisteById(unTitre.getArtisteId());
            unTitre.setArtiste(artiste);
        }
        return titreList;
    }

}

