package com.ikem.vpda_ccount_system.common;

import com.ikem.vpda_ccount_system.payload.AccountDto;
import com.ikem.vpda_ccount_system.payload.CreateAccountDto;
import com.ikem.vpda_ccount_system.payload.deposit.DepositDto;
import com.ikem.vpda_ccount_system.payload.deposit.WithdrawDto;
import com.ikem.vpda_ccount_system.payload.transfer.TransferDto;

import java.math.BigDecimal;
import java.util.HashSet;

public class CommonTestObjects {

    public static CreateAccountDto getCreateAccountDtoObject() {
        return CreateAccountDto.builder()
                .firstName("Ikem")
                .lastName("Nwodo")
                .BVN("12345678901")
                .password("password")
                .emailAddress("Ikem@gmail.com")
                .build();
    }

    public static AccountDto getAccountDtoObject() {
        return AccountDto.builder()
                .accountName("IkemNwodo")
                .accountNumber("1234567890")
                .balance(BigDecimal.ZERO)
                .transactions(new HashSet<>())
                .build();
    }

    public static WithdrawDto getWithdrawDtoObject() {
        return WithdrawDto.builder()
                .amount(BigDecimal.valueOf(100))
                .accountNumber("1234567890")
                .build();
    }

    public static DepositDto getDepositDtoObject() {
        return DepositDto.builder()
                .amount(BigDecimal.valueOf(100))
                .accountNumber("1234567890")
                .build();
    }

    public static TransferDto getTransferDtoObject() {
        return TransferDto.builder()
                .amount(BigDecimal.valueOf(300))
                .sourceAccountNumber("1234567890")
                .destinationAccountNumber("1234567891")
                .build();
    }
}
