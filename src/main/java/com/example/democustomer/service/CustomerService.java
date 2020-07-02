package com.example.democustomer.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democustomer.model.Customer;
import com.example.democustomer.repo.CustomerRepository;
import com.github.javafaker.Faker;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	public Customer getCustomerById(Long id) {
		return customerRepo.findById(id).orElse(null);
	}

	public Customer saveCustomer(Customer c) {
		return customerRepo.save(c);
	}

	public Customer generateAndSaveRandomCustomer() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		int age = ThreadLocalRandom.current().nextInt(18, 99 + 1);
		return saveCustomer(new Customer(firstName, lastName, age));
	}

	public Iterable<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
		;
	}
}
