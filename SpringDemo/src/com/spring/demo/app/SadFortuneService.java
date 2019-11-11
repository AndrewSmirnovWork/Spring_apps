package com.spring.demo.app;

import com.spring.demo.app.Service.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "not today";
    }
}
