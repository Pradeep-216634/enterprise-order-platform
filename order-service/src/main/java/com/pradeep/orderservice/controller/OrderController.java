package com.pradeep.orderservice.controller;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.orderservice.dto.OrderRequest;
import com.pradeep.orderservice.dto.OrderResponse;
import com.pradeep.orderservice.security.UserPrincipal;
import com.pradeep.orderservice.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@Slf4j
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;
	
	@GetMapping("/health")
    public String health() {
		log.info("Health endpoint invoked");
        return "Order Service is running";
    }
	
	@PostMapping("/createorder")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<OrderResponse> createOrder(
	        @Valid @RequestBody OrderRequest request, @AuthenticationPrincipal UserPrincipal principal) {

		OrderResponse response = orderService.createOrder(request, principal);

	    return ResponseEntity.status(HttpStatus.CREATED)
	            .body(response);
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
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public ResponseEntity<OrderResponse> getOrderById(
	        @PathVariable Long id) {

	    return null;//ResponseEntity.ok(orderService.getOrderById(id));
	}
	
	

}
