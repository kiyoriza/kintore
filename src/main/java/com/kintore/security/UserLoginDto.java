package com.kintore.security;

import org.springframework.security.core.userdetails.User;
import com.kintore.entity.UserEntity;

public class UserLoginDto extends User {

	public UserLoginDto(UserEntity userEntity) {
        super(userEntity.getUserName(),
                userEntity.getPassword(), 
                userEntity.getRolesList());
    }
}