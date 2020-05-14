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
/** Commente car dans le contoleur fronatl pour tests
 *
 *
    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public Utilistateur  sinscrire(Utilistateur utilistateur) {
        iUtilisateurService.ajouterUtilisateur(utilistateur);



        return utilistateur;
    }
    */

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

    @RequestMapping("artiste/{nom}")
    public ResponseEntity<Artiste> getArticleById(@PathVariable("nom") String nom){
        Artiste artiste = artisteService.getArtisteByNom(nom);
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
   public ResponseEntity<Titre> getTitre(@PathVariable("id") int id){
       Titre titre=titreService.getTitreById(id);
       return new ResponseEntity<>(titre, HttpStatus.OK);
   }

    @RequestMapping("titres")
    public List<Titre> getTitres(){
        return titreService.trouverTous();
    }



}

