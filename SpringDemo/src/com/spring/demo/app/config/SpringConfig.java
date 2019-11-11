package com.spring.demo.app.config;

import com.spring.demo.app.Service.Coach;
import com.spring.demo.app.HappyFortuneService;
import com.spring.demo.app.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.spring.demo.app")
public class SpringConfig {

    @Bean
    public HappyFortuneService happyFortuneService() {
        return new HappyFortuneService();
    }
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(happyFortuneService());
    }
}


