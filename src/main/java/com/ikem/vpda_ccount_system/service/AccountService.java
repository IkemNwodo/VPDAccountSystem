package com.ikem.vpda_ccount_system.service;

import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.payload.deposit.WithdrawDto;
import com.ikem.vpda_ccount_system.payload.transfer.TransferDto;
import lombok.With;

public interface AccountService {

    AccountDto createAccount(CreateAccountDto account);

    DepositDto deposit(DepositDto depositDto);

    WithdrawDto withdraw(WithdrawDto withdrawDto);

    TransferDto transfer(TransferDto transferDto);



}
