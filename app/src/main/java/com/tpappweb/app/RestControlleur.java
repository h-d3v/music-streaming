package com.tpappweb.app;

import com.tpappweb.app.entites.Utilistateur;
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
}
