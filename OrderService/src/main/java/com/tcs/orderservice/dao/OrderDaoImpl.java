package com.tcs.orderservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.orderservice.model.Order;
import com.tcs.orderservice.model.OrderRepository;

public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderByOrderId(int orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) {
		return orderRepository.getAllOrdersByCustomerId(customerId);
	}

}
