package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:45
 */
public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();
}
