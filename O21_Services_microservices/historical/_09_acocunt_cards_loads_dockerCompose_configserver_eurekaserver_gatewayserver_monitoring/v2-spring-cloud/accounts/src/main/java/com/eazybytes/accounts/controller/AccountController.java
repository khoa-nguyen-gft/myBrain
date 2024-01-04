package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.constants.AccountsConstants;
import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.dto.ResponseDto;
import com.eazybytes.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.eazybytes.accounts.constants.AccountsConstants.CORRELATION_ID;

@Tag(
        name = "CRUD REST APIs for Accounts in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountController {

    @Autowired
    private IAccountsService accountService;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountsContactInfoDto accountsContactInfoDto;

    @GetMapping()
    public String up() {
        return "UP";
    }

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create new Customer & Account inside EazyBank"
    )
    @ApiResponse(
            responseCode = AccountsConstants.STATUS_201,
            description = "HTTP Status CREATE Account"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customer) {

        accountService.createAccount(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch Account Details REST API",
            description = "REST API to fetch Customer & Account details based on a mobile number"
    )
    @ApiResponse(
            responseCode = AccountsConstants.STATUS_200,
            description = "HTTP Status OK"
    )
    @GetMapping("fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Phone Number must be 10 digit")
            @RequestParam String phoneNumber) {
        CustomerDto customerDto = accountService.fetchAccountDetails(phoneNumber);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @Operation(
            summary = "Update Account Details REST APT",
            description = "REST APT to update Customer & Account details based on a account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = AccountsConstants.STATUS_200,
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccount(
            @RequestHeader(CORRELATION_ID) String correctionId,
            @Valid @RequestBody CustomerDto customerDto) {

        boolean updateAccount = accountService.updateAccount(customerDto);

        if (!updateAccount) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete Account & Customer Details REST API",
            description = "REST API to delete Customer & Account details based on a mobile number"
    )

    @ApiResponses({
            @ApiResponse(
                    responseCode = AccountsConstants.STATUS_200,
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = AccountsConstants.STATUS_417,
                    description = AccountsConstants.MESSAGE_417_DELETE,
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )}
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteAccount(
            @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Phone Number must be 10 digit")
            @RequestParam String phoneNumber) {

        boolean deleteAccount = accountService.deleteAccount(phoneNumber);

        if (!deleteAccount) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(
            summary = "Get Contact Info",
            description = "Contact Info details that can be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDto);
    }

}
