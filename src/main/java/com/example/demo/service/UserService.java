package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserA;
import com.example.demo.entity.UserB;
import com.example.demo.entity.UserC;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:45
 */
public interface UserService {
    void addUser(User user);

    void addUserB(UserB userB);

    void addUserC(UserC userC);

    List<User> getAllUsers();

    void merge();

    List<UserB> getAllUsersB();

    List<UserC> getAllUsersC();

    List<UserA> getAllUsersA();


}
