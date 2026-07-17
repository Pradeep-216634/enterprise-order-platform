package com.pradeep.orderservice.kafka.event;

import java.math.BigDecimal;

import com.pradeep.orderservice.dto.OrderStatus;

public record OrderCreatedEvent(
		Long orderId,

        String customerName,

        String productName,

        Integer quantity,

        BigDecimal amount,

        OrderStatus status,

        String createdBy
		
		) {

}
