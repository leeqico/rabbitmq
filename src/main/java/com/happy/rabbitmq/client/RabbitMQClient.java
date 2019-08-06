package com.happy.rabbitmq.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送类
 */
@Component
public class RabbitMQClient {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message) {
        //happy 这个是路由规则（routingKey），它的值表明将消息发送到指定的队列 happy 中去
        rabbitTemplate.convertAndSend("happy",message);
    }

}
