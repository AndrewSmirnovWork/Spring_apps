package com.spring.demo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})//where annotation can be used
@Retention(RetentionPolicy.RUNTIME)//how long will the marked annotation will used\stored
public @interface CourseCode {

    //define default annotation
    String value() default "LUV";

    //define error
    String message() default "must start with LUV";

    //define default groups
    Class<?>[] groups() default {};

    //define default payloads
    Class<? extends Payload>[] payload() default {};

}
