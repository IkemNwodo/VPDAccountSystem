package com.ikem.vpda_ccount_system.exception;

import java.math.BigDecimal;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String accountName, BigDecimal withdrawalAmount, BigDecimal currentBalance) {
        super(String.format("%s has insufficient balance for this %s withdrawal. Current balance is %s", accountName, withdrawalAmount, currentBalance));
    }
}
