package com.easybyte.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digits")
    @NotEmpty(message = "Account number is not empty")
    private Long accountNumber;

    @NotEmpty(message = "Account Type should be not empty")
    private String accountType;

    @NotEmpty(message = "Branch Address should be not empty")
    private String branchAddress;
}
