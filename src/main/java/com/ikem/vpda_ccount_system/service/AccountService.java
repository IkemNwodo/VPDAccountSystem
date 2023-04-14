package com.ikem.vpda_ccount_system.service;

import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.payload.deposit.WithdrawDto;
import lombok.With;

public interface AccountService {

    AccountDto createAccount(CreateAccountDto account);

    DepositDto deposit(DepositDto depositDto);

    WithdrawDto withdraw(WithdrawDto withdrawDto);

    AccountDto transfer(int accountNumber, double amount);



}
