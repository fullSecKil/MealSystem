package com.meal.vortex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ColltrollerMain {
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(){
        return "home";
    }
}
