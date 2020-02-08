package com.tcs.customerservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tcs.customerservice.model.Customer;
import com.tcs.customerservice.repository.CustomerRepository;

@Component
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByCustomerId(int customerId) {
		return customerRepository.findById(customerId).get();
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	public void deleteCustomer(int customerId) {
		customerRepository.deleteById(customerId);
	}
}
