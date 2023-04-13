package com.ikem.vpda_ccount_system.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Transaction {

    @Id
    private UUID transactionReference;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;
}
