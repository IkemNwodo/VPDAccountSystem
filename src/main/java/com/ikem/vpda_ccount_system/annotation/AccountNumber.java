package com.ikem.vpda_ccount_system.annotation;

import com.ikem.vpda_ccount_system.validator.AccountNumberValidator;
import com.ikem.vpda_ccount_system.validator.BvnValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AccountNumberValidator.class)
@Target( {ElementType.FIELD, ElementType.METHOD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface AccountNumber {
    String message() default "AccountNumber should be 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}