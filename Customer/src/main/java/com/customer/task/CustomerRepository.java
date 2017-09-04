package com.customer.task;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	

	//public Customer findBycustID(int custId);
	
	

	//public void deleteBycustID(int custId);

}