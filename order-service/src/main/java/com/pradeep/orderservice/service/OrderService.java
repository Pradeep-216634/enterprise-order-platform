package com.pradeep.orderservice.service;

import org.springframework.stereotype.Service;

import com.pradeep.orderservice.dto.OrderRequest;
import com.pradeep.orderservice.dto.OrderResponse;
import com.pradeep.orderservice.security.UserPrincipal;

@Service
public interface OrderService {
	
	OrderResponse createOrder(
	        OrderRequest request,
	        UserPrincipal principal);

}
