package com.spring.demo.SpringBootApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestHandlerException {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {

        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
        EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
