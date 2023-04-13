package com.ikem.vpda_ccount_system.model;

import com.ikem.vpda_ccount_system.util.Generator;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;

    private String accountName;
    private BigDecimal balance;

    @OneToMany(mappedBy = "account")
    private Set<Transaction> transactions = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User user;
}
