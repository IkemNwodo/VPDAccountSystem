package com.ikem.vpda_ccount_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.payload.deposit.WithdrawDto;
import com.ikem.vpda_ccount_system.payload.transfer.TransferDto;
import com.ikem.vpda_ccount_system.service.AccountService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.ikem.vpda_ccount_system.common.CommonTestObjects.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(AccountController.class)
@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private CreateAccountDto createAccountDto;
    private DepositDto depositDto;
    private WithdrawDto withdrawDto;
    private TransferDto transferDto;

    @BeforeEach
    void setUp() {
        createAccountDto = getCreateAccountDtoObject();
        depositDto = getDepositDtoObject();
        withdrawDto = getWithdrawDtoObject();
        transferDto = getTransferDtoObject();
    }

    @Test
    public void createAccount_returnsCreated() throws Exception {
        // Arrange
        AccountDto accountDto = getAccountDtoObject();
        when(accountService.createAccount(any(CreateAccountDto.class))).thenReturn(accountDto);

        // Act
        mockMvc.perform(post("/api/v1/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(createAccountDto)))
                .andExpect(status().isCreated())
                .andReturn();

    }

    @Test
    public void deposit_returnsCreated() throws Exception {
        // Arrange
        DepositDto depositDtoWithCurrentBalance = getDepositDtoObject();
        when(accountService.deposit(any(DepositDto.class))).thenReturn(depositDtoWithCurrentBalance);

        // Act
        mockMvc.perform(post("/api/v1/account/deposit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(depositDto)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void withdraw_returnsAccepted() throws Exception {
        // Arrange
        WithdrawDto withdrawDtoWithCurrentBalance = getWithdrawDtoObject();
        when(accountService.withdraw(any(WithdrawDto.class))).thenReturn(withdrawDtoWithCurrentBalance);

        // Act
        mockMvc.perform(post("/api/v1/account/withdraw")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(withdrawDto)))
                .andExpect(status().isAccepted())
                .andReturn();

    }

    @Test
    public void transfer_returnsAccepted() throws Exception {

        // Arrange
        TransferDto transferDtoWithCurrentBalance = getTransferDtoObject();
        when(accountService.transfer(any(TransferDto.class))).thenReturn(transferDtoWithCurrentBalance);

        // Act
        mockMvc.perform(post("/api/v1/account/transfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(transferDto)))
                .andExpect(status().isAccepted())
                .andReturn();
    }
}
