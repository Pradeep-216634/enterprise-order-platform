package com.pradeep.orderservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NotificationConsumer {

    //@KafkaListener(topics = "order-created", groupId = "notification-group")
    public void sendNotification(OrderCreatedEvent event) {

        log.info("======= NOTIFICATION =======");
        log.info("Sending Email...");
        log.info("Customer : {}", event.customerName());
        log.info("Order : {}", event.orderId());
        log.info("Notification Sent Successfully");
        log.info("============================");
    }
}
