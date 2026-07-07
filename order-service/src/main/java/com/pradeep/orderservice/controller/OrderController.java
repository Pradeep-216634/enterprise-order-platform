package com.pradeep.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.orderservice.dto.OrderRequest;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderController {
	
	@GetMapping("/health")
    public String health() {
		log.info("Health endpoint invoked");
        return "Order Service is running";
    }
	
	@PostMapping
	public ResponseEntity<String> createOrder(
	        @Valid @RequestBody OrderRequest request) {

	    return ResponseEntity.ok("Order Created");
	}

}
