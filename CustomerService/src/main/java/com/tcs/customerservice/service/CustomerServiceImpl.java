package com.tcs.customerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.customerservice.dao.CustomerDao;
import com.tcs.customerservice.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		return customerDao.getCustomerByCustomerId(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
