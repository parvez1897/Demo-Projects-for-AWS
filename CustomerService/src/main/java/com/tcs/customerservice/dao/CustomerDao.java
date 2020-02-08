package com.tcs.customerservice.dao;

import java.util.List;

import com.tcs.customerservice.model.Customer;

public interface CustomerDao {

	Customer saveCustomer(Customer customer);
	
	Customer getCustomerByCustomerId(int customerId);
	
	List<Customer> getAllCustomers();
	
	void deleteCustomer(int customerId) ;
}
