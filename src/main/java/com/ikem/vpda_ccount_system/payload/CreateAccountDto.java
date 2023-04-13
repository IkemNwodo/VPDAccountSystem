package com.ikem.vpda_ccount_system.payload;

import com.ikem.vpda_ccount_system.annotation.BVN;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAccountDto {
    @NotNull(message = "{firstName.notNull}")
    private String firstName;

    @NotNull(message = "{lastName.notNull}")
    private String lastName;

    @BVN
    private String BVN;

    @NotNull(message = "{phoneNumber.notNull}")
    @NotBlank(message = "{password.notBlank}")
    @Size(min = 8, message = "{password.size}")
    private String password;

    @Email(message = "{email.valid}")
    private String emailAddress;
}
