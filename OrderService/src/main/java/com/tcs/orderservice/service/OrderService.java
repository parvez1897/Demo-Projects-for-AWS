package com.tcs.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.orderservice.model.Orders;


public interface OrderService {
	
Orders saveOrder(Orders order);
	
	Orders getOrderByOrderId(int orderId);
	
	void deleteOrder(int orderId);
	
	List<Orders> getAllOrdersByCustomerId(int customerId);
	

}
