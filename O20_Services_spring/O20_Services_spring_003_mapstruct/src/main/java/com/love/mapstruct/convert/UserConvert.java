package com.love.mapstruct.convert;

import com.love.mapstruct.bo.UserBo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    public UserBo convert(UserBo user);
}
