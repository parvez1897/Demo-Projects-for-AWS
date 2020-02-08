package com.tcs.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello from order service";
	}
	
}
