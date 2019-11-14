package com.spring.demo.mvc.entity;

import java.util.LinkedHashMap;

public class User {
    private String lastName;
    private String firstName;
    private String country;

    private LinkedHashMap<String, String> countryList;
    private String[] operatingSystems;
    private String favoriteLanguage;


    public User() {
        countryList = new LinkedHashMap<>();

        countryList.put("BR", "Brazil");
        countryList.put("FR", "France");
        countryList.put("RU", "Russia");
        countryList.put("USA", "USA");
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
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
