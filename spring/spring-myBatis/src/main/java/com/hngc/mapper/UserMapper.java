package com.hngc.mapper;

import com.hngc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user;")
    List<User> selectList();

    User getById(int id);

}
