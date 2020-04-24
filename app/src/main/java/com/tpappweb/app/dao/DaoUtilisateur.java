package com.tpappweb.app.dao;

import com.tpappweb.app.entites.Utilistateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class DaoUtilisateur  {



    @Autowired
    private JdbcTemplate jdbcTemplate;



    public Utilistateur lire(long id) {
        return null;
    }


    public Utilistateur modifier(Object T) {
        return null;
    }


    public Utilistateur supprimmer(Object T) {
        return null;
    }


    public List<Utilistateur> lireTous() {
        return null;
    }

    public boolean creer(Object T) {
        jdbcTemplate.update(
                "INSERT INTO Utilisateur VALUES (?, ?, ?)", "pseudo", "mail", "passeord");
            return false;
        }
}
