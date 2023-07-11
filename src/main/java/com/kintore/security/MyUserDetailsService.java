package com.kintore.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kintore.entity.UserEntity;
import com.kintore.repository.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserMapper userMapper;

    public void UserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found"));
        return new UserLoginDto(userEntity);
    }
}
