package com.spring.demo.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/managers")
public class managerController {

    @GetMapping
    public String showManagers() {
        return "managers";
    }
}

