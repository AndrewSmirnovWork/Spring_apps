package com.spring.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println("AccountDAO: getName method");
        return name;
    }

    public void setName(String name) {
        System.out.println("AccountDAO: setName method");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("AccountDAO: getServiceCode method");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("AccountDAO: setServiceCode method");
        this.serviceCode = serviceCode;
    }

    public void addAccount() {
        System.out.println(getClass() + " Adding account to db");
    }
}
