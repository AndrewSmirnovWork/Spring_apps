package com.spring.demo.dao;

import com.spring.demo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + " Adding account to db");
    }

    //add a new method
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Error in findAccountsMethod");
        }

        Account firstAcc = new Account("Andrew", "gold");
        Account secondAcc = new Account("Nikita", "silver");

        List<Account> myAccounts = new ArrayList<>();

        myAccounts.add(firstAcc);
        myAccounts.add(secondAcc);
        return myAccounts;
    }
}
