package com.spring.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Customer customer = objectMapper.readValue(new File("data/sample.json"), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
