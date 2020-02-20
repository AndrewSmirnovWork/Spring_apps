package com.spring.demo.SpringBootApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class RestfulController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;


    @GetMapping("/")
    public String sayHello() {
        return "Hello " + coachName + "! Time on server " + LocalDateTime.now();
    }

    @GetMapping("/test1")
    public String test() {
        return "Another useless link here";
    }
}