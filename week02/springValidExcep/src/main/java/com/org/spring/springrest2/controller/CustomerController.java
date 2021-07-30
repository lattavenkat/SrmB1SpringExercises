package com.org.spring.springrest2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.org.spring.springrest2.exceptionhandler.ResourceNotFoundException1;
import com.org.spring.springrest2.model.Customer;
// import com.org.spring.springrest2.model.Customer;
import com.org.spring.springrest2.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerRepository CustomerRepository;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return CustomerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException1 {
                Customer customer = CustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException1("customer not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@Valid @RequestBody Customer customer) {
        return CustomerRepository.save(customer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
            @Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException1 {
                Customer customer = CustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException1("customer cannot be found for this id :: " + customerId));
                customer.setName(customerDetails.getName());
                customer.setEmail(customerDetails.getEmail());
                customer.setMobilenumber(customerDetails.getMobilenumber());
                
        final Customer updatedCustomer = CustomerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws ResourceNotFoundException1 {
                Customer customer = CustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException1("customer not found for this id :: " + customerId));

        CustomerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}