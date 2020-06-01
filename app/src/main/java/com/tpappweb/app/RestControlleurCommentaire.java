package com.tpappweb.app;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ICommentaireService;
import com.tpappweb.app.service.interfaces.ITitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControlleurCommentaire {

    @Autowired
    private ICommentaireService iCommentaireService;
    @Autowired
    private ITitreService iTitreService;

    @RequestMapping("titre/{idTitre}/commentaires")
    public ResponseEntity<List<Commentaire>> getCommentaires(@PathVariable("idTitre") int id) {
        Titre titre = iTitreService.getTitreById(id);
        List<Commentaire> commentaires= iCommentaireService.chercherCommentairesParTitre(titre);
        return new ResponseEntity<List<Commentaire>>(commentaires, HttpStatus.OK);
    }
    @RequestMapping("titre/{idTitre}/commentaire/{id}")
    public ResponseEntity<Commentaire> getCommentaire(@PathVariable("id") int id, @PathVariable("idTitre") int idTitre) {
        Titre titre = iTitreService.getTitreById(idTitre);
        List<Commentaire> commentaires= iCommentaireService.chercherCommentairesParTitre(titre);
        Commentaire commentaire= commentaires.stream()
                .filter(commentaire1 -> id==commentaire1.getId())
                .findAny()
                .orElse(null);
        return new ResponseEntity<Commentaire>(commentaire, HttpStatus.OK);
    }

    @PutMapping("titre/{idTitre}/commentaire/{id}")
    public ResponseEntity<Commentaire> modifierCommentaire(@RequestBody Commentaire commentaire){

        iCommentaireService.modifierCommentaire(commentaire);
        commentaire=iCommentaireService.chercherCommentaireParId((int) commentaire.getId());
        return new ResponseEntity<>(commentaire, HttpStatus.OK);
    }

    @GetMapping("/addcomment")
    public boolean ajouterCommentaire(@RequestParam ("comment") String comment, @RequestParam("titreId") String titreId, @RequestParam("userPseudo") String userPseudo){
        Commentaire commentaire = new Commentaire();
        Titre titre=new Titre();
        Utilistateur utilistateur= new Utilistateur();

        utilistateur.setPseudo(userPseudo);
        titre.setId(Integer.parseInt(titreId));

        commentaire.setUtilistateur(utilistateur);
        commentaire.setTitre(titre);
        commentaire.setCommentaire(comment);

        return iCommentaireService.ajouterCommentaire(commentaire);
    }

    @DeleteMapping("titre/{idTitre}/commentaire/{id}")
    public ResponseEntity<Boolean> supprimerCommentaire(@PathVariable("id") int id ){
       boolean reponse= iCommentaireService.supprimerComentaireParId(id);

        return  new ResponseEntity<>(reponse,HttpStatus.OK);
    }



}
