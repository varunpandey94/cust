package com.customer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
public Customer getByCustId(int custId) {
		
		//Customer fetched_cust = customerRepository.findBycustID(custId);	
	Customer fetched_cust = customerRepository.findOne(custId);		
	
		return fetched_cust;
	}

	public void addCust(Customer customer) {
		
		customerRepository.save(customer);
			
		
	}
	
	public void deleteCust(int custId) {
		
		customerRepository.delete(custId);
			
		
	}

	public Iterable<Customer> getall() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public String errorHandler(int statusCode) {

		if (statusCode == 500)
		return "Customer Does Not Exist";
		
		else 
			return "other error";
	}



}
