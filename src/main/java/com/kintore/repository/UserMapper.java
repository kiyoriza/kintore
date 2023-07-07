package com.kintore.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT name FROM user WHERE id = #{id}")
    String findByState(@Param("id") int id);
}