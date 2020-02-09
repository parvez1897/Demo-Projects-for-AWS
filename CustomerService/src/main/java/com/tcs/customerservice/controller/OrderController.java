package com.tcs.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcs.customerservice.config.EndpointSettings;
import com.tcs.customerservice.model.CustomerOrdersResponse;
import com.tcs.customerservice.model.Orders;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private EndpointSettings endpoints;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/save-order")
	public ResponseEntity<Orders> saveOrder(@RequestBody Orders order){
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(mapToJson(order),header);
		HttpEntity<Orders> response = restTemplate.exchange(endpoints.getOrderServiceEndpoint()+"/order/save-order",HttpMethod.POST, entity, Orders.class);
		return new ResponseEntity<>(response.getBody(),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-order-list/{customerId}")
	public ResponseEntity<CustomerOrdersResponse> getOrderListByCustomerId(@PathVariable(value="customerId") int customerId){
		CustomerOrdersResponse response = restTemplate.getForObject(endpoints.getOrderServiceEndpoint()+"/get-order-list/"+customerId, CustomerOrdersResponse.class);
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/get-order/{orderId}")
	public ResponseEntity<Orders> getOrderByOrderId(@PathVariable(value="orderId") int orderId){
		Orders order = restTemplate.getForObject(endpoints.getOrderServiceEndpoint()+"/order/get-order/"+orderId, Orders.class);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@PutMapping("/save-order")
	public ResponseEntity<Orders> updateOrder(@RequestBody Orders order){
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(mapToJson(order),header);
		HttpEntity<Orders> response = restTemplate.exchange(endpoints.getOrderServiceEndpoint()+"/order/save-order",HttpMethod.POST, entity, Orders.class);
		return new ResponseEntity<>(response.getBody(),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete-order/{orderId}")
	public ResponseEntity<String> deleteOrder(@PathVariable(value="orderId") int orderId){
		String response = restTemplate.getForObject(endpoints.getOrderServiceEndpoint()+"/order/delete-order/"+orderId, String.class);
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
	
	public String mapToJson(Object obj) {
		String jsonString = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			jsonString =  mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
