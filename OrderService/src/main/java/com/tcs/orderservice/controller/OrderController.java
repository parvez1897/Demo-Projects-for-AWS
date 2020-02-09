package com.tcs.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.orderservice.model.CustomerOrdersResponse;
import com.tcs.orderservice.model.Orders;
import com.tcs.orderservice.service.OrderService;

@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Value("${msg}")
	String msg;
	
	@GetMapping("/hello")
	public String hello() {
		return msg;
	}
	

	@PostMapping("/save-order")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
		return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-order-list/{customerId}")
	public ResponseEntity<CustomerOrdersResponse> getOrderListByCustomerId(@PathVariable(value="customerId") int customerId){
		CustomerOrdersResponse response = new CustomerOrdersResponse(orderService.getAllOrdersByCustomerId(customerId));
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/get-order/{orderId}")
	public ResponseEntity<Orders> getOrderByOrderId(@PathVariable(value="orderId") int orderId){
		return new ResponseEntity<>(orderService.getOrderByOrderId(orderId),HttpStatus.OK);
	}
	
	@PutMapping("/update-order")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order){
		return new ResponseEntity<>(orderService.saveOrder(order),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete-order/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable(value="orderId") int orderId){
		orderService.deleteOrder(orderId);
		return new ResponseEntity<String>("Order Deleted Successfully",HttpStatus.OK);
	}
	
	
}
