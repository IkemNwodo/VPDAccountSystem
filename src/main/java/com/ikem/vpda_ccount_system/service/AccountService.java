package com.ikem.vpda_ccount_system.service;

import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;

public interface AccountService {

    AccountDto createAccount(CreateAccountDto account);

    DepositDto deposit(DepositDto depositDto);

    AccountDto withdraw(double amount);

    AccountDto transfer(int accountNumber, double amount);



}
