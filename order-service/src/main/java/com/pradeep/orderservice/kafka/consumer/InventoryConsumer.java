package com.pradeep.orderservice.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.pradeep.orderservice.kafka.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class InventoryConsumer {
	
	@KafkaListener(
            topics = "order-created",
            groupId = "inventory-group")
    public void reserveInventory(OrderCreatedEvent event) {
		
		if (event.orderId() % 2 == 0) {
	        throw new RuntimeException("Inventory database is down");
	    }

        log.info("========== INVENTORY ==========");
        log.info("Reserving stock...");
        log.info("Order : {}", event.orderId());
        log.info("Product : {}", event.productName());
        log.info("Quantity : {}", event.quantity());
        log.info("Inventory Reserved Successfully");
        log.info("===============================");
    }

}
