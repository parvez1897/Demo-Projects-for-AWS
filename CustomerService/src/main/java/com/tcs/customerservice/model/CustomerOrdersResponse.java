package com.tcs.customerservice.model;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerOrdersResponse {

	private List<Orders> orders;
}
