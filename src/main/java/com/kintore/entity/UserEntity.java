package com.kintore.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Data;

@Data
public class UserEntity  {
    /* user id */
    private int id;
    /* user name */
    private String userName;
    /* user password */
    private String password;
    /* user email */
    private String email;
    /* user mail age */
    private Integer age;
    /* user role */
    private String roles;
    /* when a value is 1 which is meaning invalid.*/
    private int enabled;
    /* create date */
    private LocalDate createdAt;
    /* update date */
    private LocalDate updateAt;

    /**
     * Getting user's roles
     * @return List<GrantedAuthority>
     */
    public List<GrantedAuthority> getRolesList() {
    	SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(this.roles);
        List<GrantedAuthority> test = new ArrayList<GrantedAuthority>();
        test.add(simpleGrantedAuthority);
        return test;
    }
}