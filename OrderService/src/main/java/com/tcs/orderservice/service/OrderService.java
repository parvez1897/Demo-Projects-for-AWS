package com.tcs.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.orderservice.model.Order;

@Service
public interface OrderService {
	
Order saveOrder(Order order);
	
	Order getOrderByOrderId(int orderId);
	
	void deleteOrder(int orderId);
	
	List<Order> getAllOrdersByCustomerId(int customerId);
	

}
