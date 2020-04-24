package com.tpappweb.app;

import com.tpappweb.app.entites.Artiste;
import com.tpappweb.app.entites.Utilistateur;
import com.tpappweb.app.service.interfaces.IArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class ContoleurFrontal {


    @RequestMapping("/")
    public String welcome(){
        return "index";
    }




}
