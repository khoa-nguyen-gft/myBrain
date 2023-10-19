package com.love.lombok.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Test
    public void test(){
        UserService user = new UserService();
        user.normalMethod();
        UserService.staticMethod();
    }
}
