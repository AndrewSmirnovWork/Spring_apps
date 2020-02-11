package com.spring.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.demo.entity.Customer;

import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = null;
        try {
            customer = objectMapper.readValue(new File("data/sample.json"), Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(customer);
    }
}