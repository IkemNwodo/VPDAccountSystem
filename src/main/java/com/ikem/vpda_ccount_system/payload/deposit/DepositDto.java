package com.ikem.vpda_ccount_system.payload.deposit;

import com.ikem.vpda_ccount_system.annotation.AccountNumber;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class DepositDto {

    @Min(value = 100)
    private BigDecimal amount;

    @AccountNumber
    private String accountNumber;

    private BigDecimal currentBalance;
}
