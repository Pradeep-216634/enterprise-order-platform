package com.pradeep.orderservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DeadLetterConsumer {
	
	//@KafkaListener(topics = "order-created-dlt", groupId = "dlq-group")
    public void processFailedOrder(OrderCreatedEvent event) {

        log.error("===== MESSAGE RECEIVED FROM DLQ =====");
        log.error("Failed Order : {}", event);
    }

}
