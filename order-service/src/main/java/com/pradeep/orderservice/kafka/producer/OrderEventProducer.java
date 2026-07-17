package com.pradeep.orderservice.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {
	
	private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publish(OrderCreatedEvent event) {

        kafkaTemplate.send("order-created",
                event.orderId().toString(),
                event);

        log.info("Published OrderCreatedEvent {}", event.orderId());
    }

}
