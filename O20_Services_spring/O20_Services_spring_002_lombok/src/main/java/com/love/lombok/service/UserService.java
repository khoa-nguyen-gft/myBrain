package com.love.lombok.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {
    public static void staticMethod(){
        log.info("staticMethod with Slf4j");
    }

    public  void normalMethod(){
        log.info("normalMethod with Slf4j");
    }
}
