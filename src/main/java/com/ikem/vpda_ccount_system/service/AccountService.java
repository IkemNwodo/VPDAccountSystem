package com.ikem.vpda_ccount_system.service;

import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;

public interface AccountService {

    AccountDto createAccount(CreateAccountDto account);

    AccountDto deposit(double amount);

    AccountDto withdraw(double amount);

    AccountDto transfer(int accountNumber, double amount);



}
