package com.hngc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hngc.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getByIdTest(Integer id);

}
