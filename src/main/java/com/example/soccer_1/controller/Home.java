package com.example.soccer_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping({"/", "/home"})
    public String doHome(){
        return "/v1/soccer";
    }

}
