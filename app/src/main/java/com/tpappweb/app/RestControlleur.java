package com.tpappweb.app;

import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Juste un essai
 */

@RestController
public class RestControlleur {
    @PostMapping(path = "/add", consumes = "application/x-www-form-urlencoded")
    public Utilistateur  sinscrire(Utilistateur utilistateur) {
        return utilistateur;
    }

    //test du asrtisteService
    @Autowired
    private IArtisteService artisteService;
    @RequestMapping("artiste/{id}")
    public ResponseEntity<Artiste> getArticleById(@PathVariable("id") Integer id){
        Artiste artiste = artisteService.getArtisteById(id);
        return new ResponseEntity<Artiste>(artiste, HttpStatus.OK);
    }
}
