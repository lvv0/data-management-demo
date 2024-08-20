package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:47
 */
@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public void addUser(User user) {
        userMapper.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = userMapper.findAll();
        return all;
    }
}
