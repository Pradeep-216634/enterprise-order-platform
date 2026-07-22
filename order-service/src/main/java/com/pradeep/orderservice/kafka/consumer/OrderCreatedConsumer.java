package com.pradeep.orderservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderCreatedConsumer {
	
	//@KafkaListener(topics = "order-created", groupId = "audit-group")
public void consume(OrderCreatedEvent event) {

		log.info("====================================");
        log.info("Received Order Event");
        log.info("Order Id      : {}", event.orderId());
        log.info("Customer      : {}", event.customerName());
        log.info("Product       : {}", event.productName());
        log.info("Quantity      : {}", event.quantity());
        log.info("Amount        : {}", event.amount());
        log.info("Status        : {}", event.status());
        log.info("Created By    : {}", event.createdBy());
        log.info("====================================");

}

}
