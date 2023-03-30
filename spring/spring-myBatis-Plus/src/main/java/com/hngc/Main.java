package com.hngc;

import com.hngc.config.SpringConfig;
import com.hngc.mapper.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserMapper userMapper = applicationContext.getBean(UserMapper.class);
        System.out.println(userMapper.selectList(null));
        System.out.println(userMapper.getByIdTest(1));
    }
}