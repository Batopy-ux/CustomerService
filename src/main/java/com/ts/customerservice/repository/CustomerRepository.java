package com.ts.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ts.customerservice.model.Customer;

/**
 * @author prath
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
	 * Select * from customer customer name = query
	 * @param custName
	 * @return
	 */
	public Customer findByCustNameIgnoreCase(String custName);
	
}
