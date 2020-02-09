package com.tcs.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.orderservice.dao.OrderDao;
import com.tcs.orderservice.model.Order;

public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public Order getOrderByOrderId(int orderId) {
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
	}

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) {
		return orderDao.getAllOrdersByCustomerId(customerId);
	}

}
