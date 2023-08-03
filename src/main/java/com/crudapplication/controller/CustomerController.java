package com.crudapplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudapplication.model.Customer;
import com.crudapplication.service.CustomerService;


@Controller
public class CustomerController{
	
	@Autowired
	private CustomerService customerService;
	
	// display list of Customer
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@GetMapping("/")
	public String viewHomePage(Model model){
	    model.addAttribute("listCustomer" , customerService.getAllCustomer());
	    return "index";
	}
	
	 @GetMapping("/showNewCustomerForm")
	 public String showNewCustomerForm(Model model){
	     // create model attribute to bind form data
	     Customer customer = new Customer();
	     model.addAttribute("customer" , customer);
	     return "new_customer";  
	 }
	 
	 @PostMapping("/saveCustomer")
	 public String saveCustomer(@ModelAttribute("customer") Customer customer){
		  //save customer to database
		 System.out.print(customer);
		 customerService.saveCustomer(customer);
		 return "redirect:/";
	 }
	 
	 @GetMapping("/showFormForUpdate/{id}")
	 public String showFormForUpdate(@PathVariable ( value= "id") long id , Model model) {
		 // get customer from the service 
		  Customer customer = customerService.getCustomerById(id);
		 
		  // set customer as a model attribute to pre-populate the form
		  model.addAttribute("customer", customer);
		  return "update_customer";
		  
	 }
	 
	 @GetMapping("/deleteCustomer/{id}")
	 public String deleteCustomer(@PathVariable (value = "id") long id) {
		 customerService.deleteCustomer(id);
		 return "redirect:/";
	 }
}

