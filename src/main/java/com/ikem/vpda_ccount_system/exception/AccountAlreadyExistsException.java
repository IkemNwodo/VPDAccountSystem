package com.ikem.vpda_ccount_system.exception;

import org.springframework.http.HttpStatus;

public class AccountAlreadyExistsException extends RuntimeException {

    @Override
    public String getMessage() {
        return "You have an account with us already";
    }
}
