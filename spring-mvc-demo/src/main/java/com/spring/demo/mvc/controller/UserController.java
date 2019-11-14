package com.spring.demo.mvc.controller;

import com.spring.demo.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User theUser) {
        return "userConfirmation";
    }

}
