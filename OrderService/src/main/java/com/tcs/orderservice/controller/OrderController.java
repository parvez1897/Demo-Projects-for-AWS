package com.tcs.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {
	
	@Value("${msg}")
	String msg;
	
	@GetMapping("/hello")
	public String hello() {
		return msg;
	}
	
}
