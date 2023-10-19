package com.love.lombok.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDtoTest {
    @Test
    public void test() {
        DataObject dataObject = new DataObject();
        dataObject.setPassword("123");
        dataObject.setUsername("userName");
        System.out.println(dataObject);
    }
}
