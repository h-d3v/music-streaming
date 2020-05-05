package com.tpappweb.app;


import com.tpappweb.app.service.interfaces.ILikeOuDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControlleurLikeOuDislikeService {
    @Autowired
    private ILikeOuDislikeService iLikeOuDislikeService;


}
