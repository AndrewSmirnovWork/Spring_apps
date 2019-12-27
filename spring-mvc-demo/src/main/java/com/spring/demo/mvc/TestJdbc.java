package com.spring.demo.mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jbcURL = "jdbc:mysql://localhost:3306/new_schema?useSSL=false";
        String user = "hbuser";
        String password = "hbuser";
        try {
            Connection connection = DriverManager
                    .getConnection(jbcURL, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
