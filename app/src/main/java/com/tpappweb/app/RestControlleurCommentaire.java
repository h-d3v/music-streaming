package com.tpappweb.app;


import com.tpappweb.app.entites.Commentaire;
import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.service.interfaces.ICommentaireService;
import com.tpappweb.app.service.interfaces.ITitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
