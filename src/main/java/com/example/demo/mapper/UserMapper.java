package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.entity.UserA;
import com.example.demo.entity.UserB;
import com.example.demo.entity.UserC;

import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:52
 */
public interface UserMapper {
    void save(User user);

    List<User> findAll();

    List<UserB> getAllB();

    List<UserC> getAllC();

    List<UserA> getAllA();

    void addB(UserB userB);

    void addC(UserC userC);

    void addA(UserA userA);

    List<UserB> selectUserBById(String userId);

    List<UserC> selectUserCById(String userId);
}
