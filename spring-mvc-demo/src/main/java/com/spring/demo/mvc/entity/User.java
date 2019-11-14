package com.spring.demo.mvc.entity;

import java.util.LinkedHashMap;

public class User {
    private String lastName;
    private String firstName;
    private String country;

    private LinkedHashMap<String, String> countryList;


    public User() {
        countryList = new LinkedHashMap<>();

        countryList.put("BR", "Brazil");
        countryList.put("FR", "France");
        countryList.put("RU", "Russia");
        countryList.put("USA", "USA");
    }

    public String getCountry() {
        return country;
    }

    public LinkedHashMap<String, String> getCountryList() {
        return countryList;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
