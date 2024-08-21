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

import java.util.List;

/**
 * @Description rabbitmq消息消费者
 * @Author lww
 * @Date 2022/5/25 21:19
 */
@Component
@Slf4j
public class TableBConsumer {

    private UserMapper userMapper;

    @Autowired
    public TableBConsumer(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(name = "table_b", type = "fanout")
    ))
    public void receive(String message) {
        log.info("rabbitmq接收到的信息为：{}", message);
        // 1.json消息转对象
        UserB userB = JSONUtils.readValue(message, UserB.class);
        List<UserC> userCs = userMapper.selectUserCById(userB.getUser_id());
        if (userCs.size() > 0) {
            UserA userA = Utils.merge(userB, userCs.get(0));
            userMapper.addA(userA);
        }
    }
}
