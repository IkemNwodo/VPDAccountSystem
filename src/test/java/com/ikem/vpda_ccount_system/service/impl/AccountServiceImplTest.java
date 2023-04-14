package com.ikem.vpda_ccount_system.service.impl;

import com.ikem.vpda_ccount_system.exception.AccountAlreadyExistsException;
import com.ikem.vpda_ccount_system.exception.ResourceNotFoundException;
import com.ikem.vpda_ccount_system.model.Account;
import com.ikem.vpda_ccount_system.model.User;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.repository.AccountRepository;
import com.ikem.vpda_ccount_system.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

import static com.ikem.vpda_ccount_system.common.CommonTestObjects.getCreateAccountDtoObject;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    public void testCreateAccount_success() {
        // Setup
        var createAccountDto = getCreateAccountDtoObject();
        var user = User.builder()
                .firstName(createAccountDto.getFirstName())
                .lastName(createAccountDto.getLastName())
                .bvn(Long.parseLong(createAccountDto.getBVN()))
                .password(createAccountDto.getPassword())
                .emailAddress(createAccountDto.getEmailAddress())
                .build();
        when(userRepository.existsByBvn(Long.parseLong(createAccountDto.getBVN()))).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(accountRepository.findLastAccountNumber()).thenReturn("1234567890");
        when(accountRepository.save(any(Account.class))).thenReturn(
                Account.builder()
                        .accountNumber("123456790")
                        .accountName(createAccountDto.getFirstName().concat(createAccountDto.getLastName()))
                        .balance(BigDecimal.ZERO)
                        .transactions(Collections.emptySet())
                        .build());

        // Execute
        var result = accountService.createAccount(createAccountDto);

        // Verify
        assertNotNull(result);
        assertEquals("123456790", result.getAccountNumber());
        assertEquals("IkemNwodo", result.getAccountName());
        assertEquals(BigDecimal.ZERO, result.getBalance());
        assertTrue(result.getTransactions().isEmpty());
    }

    @Test(expected = AccountAlreadyExistsException.class)
    public void testCreateAccount_accountAlreadyExists() {
        // Setup
        var createAccountDto = getCreateAccountDtoObject();
        when(userRepository.existsByBvn(Long.parseLong(createAccountDto.getBVN()))).thenReturn(true);

        // Execute
        accountService.createAccount(createAccountDto);
    }

    @Test
    public void testDeposit() {
        // Arrange
        String accountNumber = "0000000001";
        BigDecimal amount = BigDecimal.TEN;

        Account account = Account.builder()
                .accountNumber(accountNumber)
                .accountName("IkemNwodo")
                .balance(BigDecimal.ZERO)
                .transactions(Collections.emptySet())
                .build();

        when(accountRepository.findAccountByAccountNumber(accountNumber)).thenReturn(Optional.of(account));
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        // Act
        DepositDto depositDto = accountService.deposit(DepositDto.builder()
                .accountNumber(accountNumber)
                .amount(amount)
                .build());

        // Assert
        assertNotNull(depositDto);
        assertEquals(accountNumber, depositDto.getAccountNumber());
        assertEquals(amount, depositDto.getAmount());
        assertEquals(amount, depositDto.getCurrentBalance());
        assertEquals("Deposit successful", depositDto.getMessage());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testDeposit_accountNotFound() {
        // Arrange
        String accountNumber = "0000000001";
        BigDecimal amount = BigDecimal.TEN;

        when(accountRepository.findAccountByAccountNumber(accountNumber)).thenReturn(Optional.empty());

        // Act
        accountService.deposit(DepositDto.builder()
                .accountNumber(accountNumber)
                .amount(amount)
                .build());
    }
}