package com.tcs.orderservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tcs.orderservice.model.Orders;


public interface OrderDao {
	
	Orders saveOrder(Orders order);
	
	Orders getOrderByOrderId(int orderId);
	
	void deleteOrder(int orderId);
	
	List<Orders> getAllOrdersByCustomerId(int customerId);
	
}
