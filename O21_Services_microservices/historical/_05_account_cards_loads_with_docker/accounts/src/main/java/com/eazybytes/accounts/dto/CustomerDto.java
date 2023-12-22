package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer", example = "Eazy Bytes"
    )
    @Size(min = 5, max = 30, message = "The length of the customer should be between 5 and 30")
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @Schema(
            description = "Email address of the customer”, example = “tutor@eazybytes.com"
    )
    @Email(message = "Email address format should be a valid email address")
    @NotEmpty(message = "email can not be empty")
    private String email;

    @Schema(
            description = "Mobile number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    @NotEmpty(message = "Mobile number is not empty")
    private String mobileNumber;

    @Schema(
        description = "Account details of the Customer"
    )
    private AccountsDto accounts;
}
