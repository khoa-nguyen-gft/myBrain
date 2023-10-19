package com.love.mapstruct.data;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDo {
    private int id;
    private String username;
    private String password;
}
