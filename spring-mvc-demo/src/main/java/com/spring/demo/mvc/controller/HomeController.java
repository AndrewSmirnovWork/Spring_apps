package com.spring.demo.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller

public class HomeController {

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/homePage")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "helloWorld";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "sayHello";
    }

    @RequestMapping("/processFormTwo")
    public String upperCase(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();
        String result = "Hey " + theName;
        model.addAttribute("modelName", result);
        return "sayHello";
    }
}
