package com.pradeep.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.pradeep.orderservice.dto.OrderRequest;
import com.pradeep.orderservice.dto.OrderResponse;
import com.pradeep.orderservice.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	Order toEntity(OrderRequest request);

    OrderResponse toResponse(Order order);

    void updateEntity(
            OrderRequest request,
            @MappingTarget Order order);
}
