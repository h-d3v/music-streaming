package com.tpappweb.app;

import com.tpappweb.app.entites.Utilistateur;
import org.springframework.web.bind.annotation.*;


public class ContoleurFrontal {


    @RequestMapping("/")
    public String welcome(){
        return "index";
    }




}
