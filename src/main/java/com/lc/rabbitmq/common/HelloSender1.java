package com.lc.rabbitmq.common;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * Hello  生产者
 */
@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void send(){
        String sendMsg = "hello word  amqp" + new Date();
        System.out.println("Sendel:  "  + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue",sendMsg);
    }


    @RabbitHandler
    public void send(String hello){
        String sendMsg =hello +"---" + new Date();
        System.out.println("Sendel:  "  + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue",sendMsg);
    }



}
