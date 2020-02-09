package com.tcs.orderservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tcs.orderservice.model.Order;

@Component
public interface OrderDao {
	
	Order saveOrder(Order order);
	
	Order getOrderByOrderId(int orderId);
	
	void deleteOrder(int orderId);
	
	List<Order> getAllOrdersByCustomerId(int customerId);
	
}
