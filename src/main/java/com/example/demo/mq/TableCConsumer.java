package com.example.demo.mq;

import com.example.demo.entity.UserA;
import com.example.demo.entity.UserB;
import com.example.demo.entity.UserC;
import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.JSONUtils;
import com.example.demo.utils.Utils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;

/**
 * @Description rabbitmq消息消费者
 * @Author lww
 * @Date 2022/5/25 21:19
 */
@Component
@Slf4j
public class TableCConsumer {

    private UserMapper userMapper;

    @Autowired
    public TableCConsumer(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "table_c", type = "fanout")
    ))
    public void receive(String message) {
        log.info("rabbitmq接收到的信息为：{}", message);
        // 1.json消息转对象
        UserC userC = JSONUtils.readValue(message, UserC.class);
        List<UserB> userBs = userMapper.selectUserBById(userC.getUser_id());
        if (userBs.size() > 0) {
            UserA userA = Utils.merge(userBs.get(0), userC);
            userMapper.addA(userA);
        }
    }
}
