package com.example.democustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.democustomer.model.Customer;
import com.example.democustomer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@PostMapping("/random-customer")
	public Customer generateRandomCustomer() {
		return customerService.generateAndSaveRandomCustomer();
	}

	@GetMapping("/customer")
	public Iterable<Customer> getAll() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomerById(id);
	}
}
