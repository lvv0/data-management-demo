package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:52
 */
public interface UserMapper {
    void save(User user);

    List<User> findAll();
}
