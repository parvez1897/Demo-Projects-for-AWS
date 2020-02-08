package com.tcs.customerservice.service;

import java.util.List;

import com.tcs.customerservice.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	Customer getCustomerByCustomerId(int customerId);
	
	List<Customer> getAllCustomers();
	
	void deleteCustomer(int customerId);
	
}
