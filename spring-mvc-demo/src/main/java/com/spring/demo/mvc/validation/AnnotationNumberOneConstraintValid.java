package com.spring.demo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AnnotationNumberOneConstraintValid implements ConstraintValidator<AnnotationNumberOne, String> {

    @Override
    public void initialize(AnnotationNumberOne constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}

