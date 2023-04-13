package com.ikem.vpda_ccount_system.model;

import lombok.Getter;

@Getter
public enum TransactionType {
    DEPOSIT("deposit"),
    TRANSFER("transfer"),
    WITHDRAWAL("withdrawal");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }
}
