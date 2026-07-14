package com.pradeep.orderservice.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pradeep.orderservice.dto.OrderRequest;
import com.pradeep.orderservice.dto.OrderResponse;
import com.pradeep.orderservice.dto.OrderStatus;
import com.pradeep.orderservice.entity.Order;
import com.pradeep.orderservice.mapper.OrderMapper;
import com.pradeep.orderservice.repository.OrderRepository;
import com.pradeep.orderservice.security.UserPrincipal;
import com.pradeep.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
	
@Override
@Transactional
public OrderResponse createOrder(OrderRequest request, UserPrincipal principal) {
	Order order = orderMapper.toEntity(request);
	order.setStatus(OrderStatus.CREATED);
	Order savedOrder = orderRepository.save(order);

    return orderMapper.toResponse(savedOrder);
}

}
