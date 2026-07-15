package com.pradeep.orderservice.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pradeep.orderservice.dto.OrderRequest;
import com.pradeep.orderservice.dto.OrderResponse;
import com.pradeep.orderservice.dto.OrderSearchRequest;
import com.pradeep.orderservice.dto.OrderStatus;
import com.pradeep.orderservice.entity.Order;
import com.pradeep.orderservice.exception.OrderNotFoundException;
import com.pradeep.orderservice.mapper.OrderMapper;
import com.pradeep.orderservice.repository.OrderRepository;
import com.pradeep.orderservice.security.UserPrincipal;
import com.pradeep.orderservice.service.OrderService;
import com.pradeep.orderservice.specification.OrderSpecification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
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

@Override
@Transactional(readOnly = true)
public OrderResponse getOrderById(Long id, UserPrincipal principal) {
	Order order = null;
	try {
		order = orderRepository.findById(id)
		        .orElseThrow(() ->
		                new OrderNotFoundException(
		                        "Order not found with id : " + id));
	} catch (OrderNotFoundException e) {
		
		log.error("Exception occurred while fetching the order");
	}

    return orderMapper.toResponse(order);
}

@Override
@Transactional
public OrderResponse updateOrder(OrderRequest request, Long id, UserPrincipal principal) {
	Order order = orderRepository.findById(id)
            .orElseThrow(() ->
                    new OrderNotFoundException(
                            "Order not found with id : " + id));

    orderMapper.updateEntity(request, order);

    Order updated = orderRepository.save(order);

    return orderMapper.toResponse(updated);
}

@Override
@Transactional
public void deleteOrder(Long id, UserPrincipal principal) {
	Order order = orderRepository.findById(id)
            .orElseThrow(() ->
                    new OrderNotFoundException(
                            "Order not found with id : " + id));

    orderRepository.delete(order);
	
}

@Override
@Transactional(readOnly = true)
public Page<OrderResponse> getAllOrders(Pageable pageable) {
	return orderRepository
            .findAll(pageable)
            .map(orderMapper::toResponse);
}

@Override
public Page<OrderResponse> searchOrders(OrderSearchRequest request, Pageable pageable) {
	return orderRepository
            .findAll(
                    OrderSpecification.search(request),
                    pageable)
            .map(orderMapper::toResponse);
}

}
