package com.easybyte.accounts.controller;

import com.easybyte.accounts.constants.AccountsConstants;
import com.easybyte.accounts.dto.CustomerDto;
import com.easybyte.accounts.dto.ResponseDto;
import com.easybyte.accounts.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping()
    public String say() {
        return "UP";
    }

    @PostMapping()
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customer) {

        accountService.createAccount(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));

    }
}
