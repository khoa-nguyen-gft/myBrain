package com.love.mapstruct.convert;

import com.love.mapstruct.bo.UserBo;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-31T15:23:32+0700",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.1.1.jar, environment: Java 11.0.19 (Homebrew)"
)
public class UserConvertImpl implements UserConvert {

    @Override
    public UserBo convert(UserBo user) {
        if ( user == null ) {
            return null;
        }

        UserBo userBo = new UserBo();

        userBo.setId( user.getId() );
        userBo.setUsername( user.getUsername() );
        userBo.setPassword( user.getPassword() );

        return userBo;
    }
}
