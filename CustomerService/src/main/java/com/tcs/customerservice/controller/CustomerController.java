package com.tcs.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.customerservice.model.Customer;
import com.tcs.customerservice.model.CustomerListResponse;
import com.tcs.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save-customer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-customer/{customerId}")
	public ResponseEntity<Customer> getCustomerByCustomerId(@PathVariable(value="customerId") int customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerByCustomerId(customerId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value="customerId") int customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer Deleted of id "+customerId,HttpStatus.OK);
	}
	
	@GetMapping("/customer-list")
	public ResponseEntity<CustomerListResponse> getAllCustomers(){
		CustomerListResponse response = new CustomerListResponse(customerService.getAllCustomers());
		return new ResponseEntity<CustomerListResponse>(response,HttpStatus.OK);
	}
	
}
