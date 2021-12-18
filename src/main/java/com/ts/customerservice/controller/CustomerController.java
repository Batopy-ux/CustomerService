package com.ts.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ts.customerservice.model.Customer;
import com.ts.customerservice.service.CustomerService;

/**
 * This class is used for Customer related operations.
 * @author prath
 *
 */
@RestController
@RequestMapping(value = "/customers")
  //http://localhost:9001/customers
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.addCustomer(customer));

	}
	
//	http://localhost:9001/customers/add-multiple-customers
	@PostMapping(value = "/add-multiple-customers")
	public List<Customer> addMultipleCustomer(@RequestBody List<Customer> customers) {
		return customerService.addMultipleCustomer(customers);
	}
	
	@GetMapping
	public List<Customer> getMultipleCustomer() {
		return customerService.getMultipleCustomer();
	}
	
	@GetMapping(value = "/get-customers-byid/{custId}")
	public Optional<Customer> getById(@PathVariable Integer custId) {
		return customerService.getCustById(custId);
	}
	
	@GetMapping(value = "/{custName}")
	public Customer getByCustName(@PathVariable String custName) {
		return customerService.getByCustName(custName);
	}
	
}
