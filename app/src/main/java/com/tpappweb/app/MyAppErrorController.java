package com.tpappweb.app;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MyAppErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError(HttpSession httpSession) {
        if(httpSession.getAttribute("utilisateurConnecte")==null){
            return "index";
        }
        else return "player";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
