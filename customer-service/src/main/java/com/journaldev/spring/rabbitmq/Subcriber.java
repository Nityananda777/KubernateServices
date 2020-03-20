package com.journaldev.spring.rabbitmq;

import com.journaldev.spring.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class Subcriber {
    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message: " + msg);
    }
}
