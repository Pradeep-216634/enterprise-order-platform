package com.pradeep.orderservice.dto;

import java.math.BigDecimal;

public record OrderSearchRequest(

        String customerName,

        String productName,

        OrderStatus status,

        BigDecimal amount

) {
}
