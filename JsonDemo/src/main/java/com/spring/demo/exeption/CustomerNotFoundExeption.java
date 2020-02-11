package com.spring.demo.exeption;

public class CustomerNotFoundExeption extends RuntimeException {

    public CustomerNotFoundExeption(String message) {
        super(message);
    }

    public CustomerNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNotFoundExeption(Throwable cause) {
        super(cause);
    }
}
