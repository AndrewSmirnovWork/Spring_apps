package com.spring.demo.app;

import com.spring.demo.app.Service.FortuneService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] data = {
            "Lucky day",
            "Careful",
            "Maybe tomorrow",
            "get used to it",
            "life sucks",
            "GET OVER HERE"
    };
    private Random chooseRandom = new Random();


    @Override
    public String getFortune() {
        int index = chooseRandom.nextInt(data.length);
        return data[index];
    }
}
