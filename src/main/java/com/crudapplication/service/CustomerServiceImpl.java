package com.crudapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapplication.model.Customer;
import com.crudapplication.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> getAllCustomer(){
	   return customerRepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer){
		this.customerRepository.save(customer);		
	}


	@Override
	public Customer getCustomerById(long id) {
		 Optional<Customer> optional =customerRepository.findById(id);               
		    Customer customer = null;
		    if(optional.isPresent()){
		    	 customer = optional.get();
		    } else {
		   	     throw new RuntimeException("Customer not found for id ::"+ id);
		       }
		   return customer;	
	}
	
	public void deleteCustomer(long id) {
		this.customerRepository.deleteById(id);
	  
	}
	
}