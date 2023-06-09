package com.ikem.vpda_ccount_system.controller;

import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.payload.deposit.WithdrawDto;
import com.ikem.vpda_ccount_system.payload.transfer.TransferDto;
import com.ikem.vpda_ccount_system.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDto createAccount(@Validated @RequestBody CreateAccountDto createAccountDto) {
        return accountService.createAccount(createAccountDto);
    }

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.CREATED)
    public DepositDto fundAccount(@Validated @RequestBody DepositDto depositDto){
        return accountService.deposit(depositDto);
    }

    @PostMapping("/withdraw")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public WithdrawDto makeWithdrawal(@Validated @RequestBody WithdrawDto withdrawDto){
        return accountService.withdraw(withdrawDto);
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TransferDto makeTransfer(@Validated @RequestBody TransferDto transferDto){
        return accountService.transfer(transferDto);
    }

}
