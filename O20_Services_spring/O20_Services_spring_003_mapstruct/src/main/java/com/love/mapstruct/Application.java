package com.love.mapstruct;

import com.love.mapstruct.bo.UserBo;
import com.love.mapstruct.convert.UserConvert;

public class Application {
    public static void main(String[] args) {
        UserBo user = new UserBo();
        user.setId(1).setUsername("user").setPassword("123");
        System.out.println(user);
        UserBo userDo = UserConvert.INSTANCE.convert(user);
        System.out.println(userDo);
    }
}
