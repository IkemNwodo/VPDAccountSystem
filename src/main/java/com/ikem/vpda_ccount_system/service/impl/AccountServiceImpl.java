package com.ikem.vpda_ccount_system.service.impl;

import com.ikem.vpda_ccount_system.exception.AccountAlreadyExistsException;
import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.model.User;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.repository.AccountRepository;
import com.ikem.vpda_ccount_system.repository.UserRepository;
import com.ikem.vpda_ccount_system.service.AccountService;
import com.ikem.vpda_ccount_system.util.Generator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        var bvn = Long.parseLong(createAccountDto.getBVN());
        if (userRepository.existsByBvn(bvn))
            throw new AccountAlreadyExistsException();

        var user = User.builder()
                .emailAddress(createAccountDto.getEmailAddress())
                .firstName(createAccountDto.getFirstName())
                .lastName(createAccountDto.getLastName())
                .bvn(bvn)
                .password(createAccountDto.getPassword())
                .build();
        userRepository.save(user);

        var account = Account.builder()
                .accountNumber(Generator.accountNumber(accountRepository.findLastAccountNumber()))
                .accountName(createAccountDto.getFirstName().concat(createAccountDto.getLastName()))
                .balance(BigDecimal.valueOf(0.0))
                .transactions(Set.of())
                .build();
        var accountCreated = accountRepository.save(account);
        log.debug("{} is the account info", account);

        return mapToDto(accountCreated);
    }

    private AccountDto mapToDto(Account accountCreated) {
        return AccountDto.builder()
                .accountName(accountCreated.getAccountName())
                .accountNumber(accountCreated.getAccountNumber())
                .balance(accountCreated.getBalance())
                .transactions(accountCreated.getTransactions())
                .build();
    }

    @Override
    public AccountDto deposit(double amount) {
        return null;
    }

    @Override
    public AccountDto withdraw(double amount) {
        return null;
    }

    @Override
    public AccountDto transfer(int accountNumber, double amount) {
        return null;
    }
}