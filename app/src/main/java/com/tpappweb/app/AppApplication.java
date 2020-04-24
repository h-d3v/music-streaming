package com.tpappweb.app;

import com.tpappweb.app.dao.DaoUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AppApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("daoUtilisateur")



    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
