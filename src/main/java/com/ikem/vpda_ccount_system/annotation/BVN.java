package com.ikem.vpda_ccount_system.annotation;

import com.ikem.vpda_ccount_system.validator.BvnValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BvnValidator.class)
@Target( {ElementType.FIELD, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface BVN {
    String message() default "BVN should be 11 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
