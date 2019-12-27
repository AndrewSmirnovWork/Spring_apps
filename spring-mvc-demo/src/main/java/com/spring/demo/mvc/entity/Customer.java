package com.spring.demo.mvc.entity;

import com.spring.demo.mvc.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "First name is required")
    @Size(min=4, message = "Minimum 4 symbols")
    private String firstName;

    @NotNull(message = "Last name is required")
    @Size(min=4, message = "Minimum 4 symbols")
    private String lastName;

    @Min(value = 0, message = "Must be greater then zero")
    @Max(value = 10, message = "Must be less then ten")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode()
    @NotNull(message = "Course code is required")
    private String courseCode;

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
