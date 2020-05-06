package com.tpappweb.app;

import com.tpappweb.app.init.Initialisation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(AppApplication.class, args);


    }

}
