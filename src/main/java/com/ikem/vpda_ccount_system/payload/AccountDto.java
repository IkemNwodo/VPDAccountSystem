package com.ikem.vpda_ccount_system.payload;

import com.ikem.vpda_ccount_system.model.Transaction;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class AccountDto {

    private String accountNumber;
    private String accountName;
    private BigDecimal balance = BigDecimal.valueOf(0.0);
    private Set<Transaction> transactions;

}
