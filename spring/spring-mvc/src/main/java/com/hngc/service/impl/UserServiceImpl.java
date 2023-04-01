package com.hngc.service.impl;

import com.hngc.entity.User;
import com.hngc.mapper.UserMapper;
import com.hngc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public boolean save(User user) {
        return userMapper.save(user);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return userMapper.delete(id);
    }


}
