package com.pradeep.orderservice.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.kafka.support.KafkaHeaders;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderCreatedConsumer {
	
	@KafkaListener(topics = "order-created")
public void consume(ConsumerRecord<String, String> record) {

		log.info("====================================");
        log.info("Received Order Event");
        //log.info("Order Id      : {}", event.orderId());
        //log.info("Customer      : {}", event.customerName());
        //log.info("Product       : {}", event.productName());
        //log.info("Quantity      : {}", event.quantity());
        //log.info("Amount        : {}", event.amount());
        //log.info("Status        : {}", event.status());
        //log.info("Created By    : {}", event.createdBy());
        //log.info("====================================");

}

}
