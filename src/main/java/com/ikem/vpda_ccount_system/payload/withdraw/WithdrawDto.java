package com.ikem.vpda_ccount_system.payload.deposit;

import com.ikem.vpda_ccount_system.annotation.AccountNumber;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WithdrawDto {

    @Min(value = 100)
    private BigDecimal amount;

    @AccountNumber
    private String accountNumber;

    private BigDecimal currentBalance;

    private String message;

}
