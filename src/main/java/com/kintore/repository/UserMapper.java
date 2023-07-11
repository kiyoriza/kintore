package com.kintore.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kintore.entity.UserEntity;

@Mapper
public interface UserMapper {
    /**
     * Finds user information based on the provided username.
     * @param userName username
     * @return an Optional containing the UserEntity if found, or an empty Optional if not found.
     */
    public Optional<UserEntity> findByUsername(@Param("userName") String userName);
}