package com.tcs.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
