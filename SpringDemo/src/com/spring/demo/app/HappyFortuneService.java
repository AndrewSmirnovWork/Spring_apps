package com.spring.demo.app;

import com.spring.demo.app.Service.FortuneService;
import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Lucky one";
    }
}
