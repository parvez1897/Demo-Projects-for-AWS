package com.tcs.orderservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
	private int customerId;
	private String orderName;
	private Date orderDate;
}
