package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserA;
import com.example.demo.entity.UserB;
import com.example.demo.entity.UserC;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.JSONUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @Description
 * @Author lvv
 * @Date 2024/8/20 0:47
 */
@Service
public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RabbitTemplate rabbitTemplate) {
        this.userMapper = userMapper;
        this.rabbitTemplate = rabbitTemplate;
    }


    @Override
    public void addUser(User user) {
        userMapper.save(user);
    }

    @Override
    public void addUserB(UserB userB) {
        List<UserB> users = userMapper.selectUserBById(userB.getUser_id());
        if (users == null || users.size() == 0) {
            userMapper.addB(userB);
            rabbitTemplate.convertAndSend("table_b", "", JSONUtils.writeValueAsString(userB));
        }

    }

    @Override
    public void addUserC(UserC userC) {
        List<UserC> users = userMapper.selectUserCById(userC.getUser_id());
        if (users == null || users.size() == 0) {
            userMapper.addC(userC);
            rabbitTemplate.convertAndSend("table_c", "", JSONUtils.writeValueAsString(userC));
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = userMapper.findAll();
        return all;
    }

    @Override
    public void merge() {

        List<UserB> allB = userMapper.getAllB();
        List<UserC> allC = userMapper.getAllC();
        UserA userA = new UserA();
        // TODO

        userMapper.addA(userA);

    }

    @Override
    public List<UserB> getAllUsersB() {
        return userMapper.getAllB();
    }

    @Override
    public List<UserC> getAllUsersC() {
        return userMapper.getAllC();
    }

    @Override
    public List<UserA> getAllUsersA() {
        return userMapper.getAllA();
    }

}
