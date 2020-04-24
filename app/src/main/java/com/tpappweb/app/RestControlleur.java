package com.tpappweb.app;

import com.tpappweb.app.dao.DaoUtilisateur;
import com.tpappweb.app.entites.Utilistateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


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
