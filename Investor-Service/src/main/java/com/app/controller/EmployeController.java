package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.model.EmployeeDetails;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/capi")
public class EmployeController {
    private final WebClient webClient ;
//	@Autowired
//	private RestTemplate restTemplate;
    
    private final String apiUrl = "http://localhost:3000/api/emp";
    private final String SERVICE_NAME="Investor-Service";
    public EmployeController() {
        this.webClient = WebClient.builder().baseUrl(apiUrl).build();
    }
	@CircuitBreaker(name =SERVICE_NAME,fallbackMethod ="getDefaultLoan")
	@GetMapping("/emp/{emp_id}")
	public ResponseEntity<EmployeeDetails> getEmployee(@PathVariable int emp_id){
		EmployeeDetails details=null;
		details=webClient.get()
        .uri(uriBuilder -> uriBuilder.path("/{emp_id}").build(emp_id))
        .retrieve()
        .bodyToMono(EmployeeDetails.class)
        .block();
		//ResponseEntity<EmployeeDetails> response=restTemplate.getForEntity(apiUrl, EmployeeDetails.class,emp_id);
		return new ResponseEntity<>(details,HttpStatus.OK);
		
		
	}

	public ResponseEntity<String> getDefaultLoan(Exception e){
		
		System.out.println("***** fallback method called... *******");
       return new ResponseEntity<>("Fallback method called due to an error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
}
