package com.tpappweb.app;

import com.tpappweb.app.dao.ArtisteMySqlDao;
import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.service.ArtisteService;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AppApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);


    }

}
