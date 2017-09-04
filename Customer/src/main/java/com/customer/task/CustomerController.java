package com.customer.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	
	@RequestMapping("/getcust/{custId}")
	@GetMapping public Customer getCustomer(@PathVariable int custId){
	
		
		Customer cust = customerService.getByCustId(custId);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity("{custId}", String.class);
		// String body = entity.getBody();
		// MediaType contentType = entity.getHeaders().getContentType();
		 int statusCode = entity.getStatusCodeValue();
		 System.out.print(statusCode);
		 if(statusCode != 200) {
			 
			 noCust(statusCode);
			 
			 return null;
		 }
		 
		 else {
		

	return cust;
		 }
}
	
	
	private String noCust(int statusCode) {
		
	return customerService.errorHandler(statusCode);
		
	}


	@RequestMapping("/addcust")
	@PostMapping public String addCustomer(@RequestBody Customer customer){
	
		
	customerService.addCust(customer);

	return "Customer Added";
}

	@RequestMapping("/delcust/{custId}")
	@PostMapping public String addCustomer(@PathVariable int custId){
	
		
	customerService.deleteCust(custId);

	return "Customer Deleted";
}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Customer> getAllUsers() {
		// This returns a JSON or XML with the users
		return customerService.getall();
	}

}