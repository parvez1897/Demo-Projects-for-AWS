package com.tcs.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.orderservice.dao.OrderDao;
import com.tcs.orderservice.model.Orders;

@Service
public class OrderServiceImpl implements OrderService{

	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Orders saveOrder(Orders order) {
		return orderDao.saveOrder(order);
	}

	@Override
	public Orders getOrderByOrderId(int orderId) {
		return orderDao.getOrderByOrderId(orderId);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
	}

	@Override
	public List<Orders> getAllOrdersByCustomerId(int customerId) {
		return orderDao.getAllOrdersByCustomerId(customerId);
	}

}
