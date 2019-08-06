package com.happy.rabbitmq.server;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收类
 */
@Component
public class RabbitMQServer {

    /**
     * RabbitListener 一直在监听着队列 happy
     * @param message
     */
    @RabbitListener(queues = "happy")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }

}
