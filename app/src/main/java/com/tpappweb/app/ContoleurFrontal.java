package com.tpappweb.app;

import org.springframework.web.bind.annotation.RequestMapping;


public class ContoleurFrontal {


    @RequestMapping("/")
    public String welcome(){
        return "index";
    }
}
