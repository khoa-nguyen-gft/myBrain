package com.love.mapstruct.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain= true)
public class UserBo {
    private int id;
    private String username;
    private String password;
}
