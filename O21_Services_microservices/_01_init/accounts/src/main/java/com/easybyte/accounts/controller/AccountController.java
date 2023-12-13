package com.easybyte.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("sayHello")
    public String say() {
        return "sayHello";
    }
}
