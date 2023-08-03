package com.crudapplication.service;

import java.util.List;

import com.crudapplication.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomer();
	void saveCustomer(Customer customer);
	
	Customer getCustomerById(long id);
	
	void deleteCustomer(long id);
}

