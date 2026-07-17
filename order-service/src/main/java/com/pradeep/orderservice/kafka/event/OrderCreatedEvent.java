package com.pradeep.orderservice.kafka.event;

import java.math.BigDecimal;

public record OrderCreatedEvent(
		Long orderId,

        String customerName,

        String productName,

        Integer quantity,

        BigDecimal amount,

        String status,

        String createdBy
		) {

}
