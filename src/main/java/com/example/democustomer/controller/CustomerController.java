package com.example.democustomer.controller;

import com.example.democustomer.model.Customer;
import com.example.democustomer.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepo;

    @GetMapping("/test")
    public Customer getHardCodedCustomer(){
        return new Customer("Marc", "Monachesi",29);
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerRepo.findById(id).orElse(null);
    }

    @PostMapping("/customer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }
}
