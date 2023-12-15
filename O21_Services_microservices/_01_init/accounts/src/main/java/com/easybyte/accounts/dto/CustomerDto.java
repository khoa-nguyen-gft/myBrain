package com.easybyte.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @Size(min = 5, max =30, message = "The length of the customer should be between 5 and 30")
    @NotEmpty(message = "Name can not be empty")
    private String name;

    @Email(message="Email address format should be a valid email address")
    @NotEmpty(message = "email can not be empty")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number should be 10 digits")
    @NotEmpty(message = "Mobile number is not empty")
    private String mobileNumber;

    private AccountsDto accounts;
}
