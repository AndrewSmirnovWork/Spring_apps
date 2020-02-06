package com.spring.demo.springSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/systems")
public class systemController {

    @GetMapping
    public String showSystemPage() {
        return "systems";
    }
}
