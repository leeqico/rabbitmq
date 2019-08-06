package com.happy.rabbitmq;

import com.happy.rabbitmq.client.RabbitMQClient;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StopWatch;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RabbitmqApplication {

    @Autowired
    RabbitMQClient rabbitMQClient;

    /**
     * 当程序开始运行时，消息接收类会持续监听队列 happy 中即将到来的消息。
     * @return
     */
    @Bean
    public Queue testQueue() {
        return new Queue("happy");
    }

    /**
     * 被 @PostConstruct 修饰的方法会在构造函数之后执行。
     */
    @PostConstruct
    public void init() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int j = 0;
        for (int i = 0; i < 1000; i++) {
            rabbitMQClient.send("发送消息-----happy-----"+i);
            j = i;
        }
        System.out.println("发了好多次了："+j);
        stopWatch.stop();
        System.out.println("发送消息耗时：" + stopWatch.getTotalTimeMillis());
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

}
