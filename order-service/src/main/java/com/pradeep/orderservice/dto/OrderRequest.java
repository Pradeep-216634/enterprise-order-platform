package com.pradeep.orderservice.dto;

import java.math.BigDecimal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record OrderRequest(

		@NotBlank(message = "Product name is required") String productName,

		@Positive (message = "Product name is required") Integer quantity,

		@NotBlank(message = "Customer name is required") String customerName,


 		BigDecimal amount,

@Enumerated(EnumType.STRING)
 OrderStatus status)
{

}
