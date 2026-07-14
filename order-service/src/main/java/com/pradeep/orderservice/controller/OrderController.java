package com.pradeep.orderservice.controller;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/createorder")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> createOrder(
	        @Valid @RequestBody OrderRequest request) {

	    return ResponseEntity.ok("Order Created");
	}
	
	@GetMapping("/getorders")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public List<OrderDto> getOrders() {
        return List.of();
    }
	
	@DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteOrder(@PathVariable Long id) {

    }
	
	

}
