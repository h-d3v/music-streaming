package com.tpappweb.app;


import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.LikeOuDislike;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.ILikeOuDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.rmi.CORBA.Util;
import java.util.List;

@RestController
public class RestControlleurLikeOuDislikeService {
    @Autowired
    private ILikeOuDislikeService iLikeOuDislikeService;

    @RequestMapping("titre/{idTitre}/likes")
    public ResponseEntity<Integer> getLikes(@PathVariable("idTitre") int id) {
        Titre titre= new Titre();
        titre.setId(id);
        int cpt= iLikeOuDislikeService.nbrDislikeParTitre(titre);

        return new ResponseEntity<>(cpt, HttpStatus.OK);
    }

    @GetMapping("titre/{idtitre}/like")
    public ResponseEntity<Boolean> liker(@PathVariable("idtitre") int id, @RequestParam("action") String action, @RequestParam("user") String user){
        if("like".equals(action)){ //TODO REFACTORING
            LikeOuDislike likeOuDislike= new LikeOuDislike();
            Utilistateur utilistateur = new Utilistateur();
            Titre titre = new Titre();
            utilistateur.setPseudo(user);
            titre.setId(id);
            likeOuDislike.setTitreId(titre);
            likeOuDislike.setUtilisateurPseudo(utilistateur);
            likeOuDislike.setLikeOuDislike(true);
            Boolean b = iLikeOuDislikeService.modifierLikeOuDislike(likeOuDislike);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        return null;
    }


}
