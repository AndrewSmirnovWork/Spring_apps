package com.spring.demo.mvc.controller;

import com.spring.demo.mvc.entity.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {



    @RequestMapping("/showForm")
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer,
                              BindingResult bindingResult) {
        System.out.println(bindingResult+"\n");
        if (bindingResult.hasErrors()) {
            return "customerForm";
        } else return "customerConfirmation";
    }

    //PreProcess every String Data
    //Remove leading and trailing white space
    //If string only has white space...trim it to null
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
