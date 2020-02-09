package com.tcs.orderservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.orderservice.model.Orders;
import com.tcs.orderservice.repository.OrderRepository;
@Component
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Orders saveOrder(Orders order) {
		return orderRepository.save(order);
	}

	@Override
	public Orders getOrderByOrderId(int orderId) {
		return orderRepository.findById(orderId).get();
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Orders> getAllOrdersByCustomerId(int customerId) {
		return orderRepository.getAllOrdersByCustomerId(customerId);
	}

}
