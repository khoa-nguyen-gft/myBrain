package com.easybyte.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountsDto {

    @Schema(
            description = "Account Number of Eazy Bank account",
            example = "11185867631"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number should be 10 digits")
    @NotEmpty(message = "Account number is not empty")
    private Long accountNumber;

    @Schema(
            description = "Account Number of Eazy Bank account",
            example = "Savings"
    )
    @NotEmpty(message = "Account Type should be not empty")
    private String accountType;


    @Schema(
            description = "Eazy Bank branch address",
            example = "123 Main Street, New York"
    )
    @NotEmpty(message = "Branch Address should be not empty")
    private String branchAddress;
}
