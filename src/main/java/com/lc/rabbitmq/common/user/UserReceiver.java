package com.lc.rabbitmq.common.user;

import com.lc.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
