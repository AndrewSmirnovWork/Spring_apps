package com.spring.demo.service;

import org.springframework.stereotype.Component;

@Component
public class TrafficServiceFortune {
    public String getFortune() {
        return "Today is very heavy traffic!";
    }
}
