package com.tcs.customerservice.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	private int customerId;
	private int orderId;
	private String orderName;
	private Date orderDate;
}
