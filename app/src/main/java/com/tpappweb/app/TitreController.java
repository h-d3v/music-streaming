package com.tpappweb.app;

import com.tpappweb.app.entites.Titre;
import com.tpappweb.app.service.interfaces.ITitreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TitreController {

    @Autowired
    ITitreService titreService;

    //test
    @RequestMapping("/titreSearch.html")
    public ModelAndView titreSearch(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView("titreSearch");
        List<Titre> titreList=titreService.trouverTous();
        modelAndView.addObject("titres", titreList);
        return modelAndView;
    }
}
