package com.ts.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ts.customerservice.exception.CustomerNotFound;
import com.ts.customerservice.model.Customer;
import com.ts.customerservice.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Value("${server.port}")
	private int portNo;
	
	public Optional<Customer> getCustById(Integer custId) {
		return customerRepository.findById(custId);
	}
	
	public Customer addCustomer(Customer cust) {
		if(portNo < 10000) {
			throw new CustomerNotFound("Customer not Found");
		}
		return customerRepository.save(cust);
	}
	
	public List<Customer> addMultipleCustomer(List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}
	
	public List<Customer> getMultipleCustomer() {
		return customerRepository.findAll();
	}
	
	public Customer getByCustName(String custName) {
		return customerRepository.findByCustNameIgnoreCase(custName);
	}
	
}
