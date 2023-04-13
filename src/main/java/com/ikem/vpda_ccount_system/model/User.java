package com.ikem.vpda_ccount_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "user")
public class User {
    @Id
    private Long bvn;

    private String firstName;

    private String lastName;

    private String password;

    private String emailAddress;

}
