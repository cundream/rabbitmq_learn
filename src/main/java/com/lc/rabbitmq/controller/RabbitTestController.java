package com.lc.rabbitmq.controller;

import com.lc.rabbitmq.common.HelloReceiver1;
import com.lc.rabbitmq.common.HelloSender1;
import com.lc.rabbitmq.common.user.UserSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class RabbitTestController {
    @Autowired
    private HelloSender1 helloSenderl;

    @Autowired
    private UserSender userSender;

    @GetMapping("/hello")
    public void hello() {
        helloSenderl.send();
    }


    /**
     * 单生产者-多消费者
     */
    @GetMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            helloSenderl.send();
        }
    }

    /**
     * 实体类传输测试
     */
    @GetMapping("/userTest")
    public void userTest() {
        userSender.send();
    }
}
