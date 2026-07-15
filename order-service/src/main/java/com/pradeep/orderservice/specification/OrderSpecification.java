package com.pradeep.orderservice.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.pradeep.orderservice.dto.OrderSearchRequest;
import com.pradeep.orderservice.entity.Order;

import jakarta.persistence.criteria.Predicate;

public class OrderSpecification {
	
	public static Specification<Order> search(
            OrderSearchRequest request) {
		return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (request.customerName() != null &&
                !request.customerName().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("customerName")),
                                "%" + request.customerName().toLowerCase() + "%"));
            }

            if (request.productName() != null &&
                !request.productName().isBlank()) {

                predicates.add(
                        cb.like(
                                cb.lower(root.get("productName")),
                                "%" + request.productName().toLowerCase() + "%"));
            }

            if (request.status() != null) {

                predicates.add(
                        cb.equal(root.get("status"),
                                request.status()));
            }

            if (request.amount() != null) {

                predicates.add(
                        cb.equal(root.get("amount"),
                                request.amount()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    
		
	}

}
