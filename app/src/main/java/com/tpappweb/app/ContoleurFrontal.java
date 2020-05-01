package com.tpappweb.app;

import org.springframework.web.bind.annotation.*;


public class ContoleurFrontal {

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    //default call pour s/curiser la page
    @RequestMapping("**")
    public String defaultCall(){return "index";}

}
