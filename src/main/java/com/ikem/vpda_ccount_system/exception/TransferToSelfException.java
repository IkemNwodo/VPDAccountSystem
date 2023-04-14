package com.ikem.vpda_ccount_system.exception;

public class TransferToSelfException extends RuntimeException {

    public TransferToSelfException(String destinationAccountNumber) {
        super(String.format("Destination accountNumber '%s' matches yours. You can't transfer to yourself", destinationAccountNumber));
    }
}
