package com.pradeep.orderservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pradeep.orderservice.entity.OrderUser;

@Repository
public interface OrderUserRepository extends JpaRepository<OrderUser, Long>{
	
	Optional<OrderUser> findByUsername(String username);
	
	 boolean existsByUsername(String username);

}
