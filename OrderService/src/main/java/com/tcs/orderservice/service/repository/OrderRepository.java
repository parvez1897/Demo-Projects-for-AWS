package com.tcs.orderservice.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tcs.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(value="SELECT * FROM ORDER WHERE customer_id=1?",nativeQuery=true)
	List<Order> getAllOrdersByCustomerId(int customerId);

}
