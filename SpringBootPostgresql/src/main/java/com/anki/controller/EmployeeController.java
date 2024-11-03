package com.anki.controller;

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

import com.anki.exception.CustomException;
import com.anki.exception.GenaricException;
import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;
import com.anki.service.impl.EmployeeImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	private EmployeeImpl impl;
	@PostMapping("/emp/register")
	public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeRequest emp) {
		EmployeeDTO dto=null;
		try {
			if(emp.getDob()==null) {
				throw new GenaricException("Unable to find the Request Data");

			}else {
				dto	=impl.saveEmployee(emp);
			}
		}catch(Exception e) {
       //  throw e;
			throw new GenaricException(e.getMessage());
		}
		return new ResponseEntity<>(dto,HttpStatus.OK);

	}
	@GetMapping("/emp/{emp_id}")
	public ResponseEntity<EmployeeDetails> getEmployeeDetails(@PathVariable int emp_id) {
		Optional<EmployeeDetails> emp=null;
		try {

			Integer wrapperInt = Integer.valueOf(emp_id);

			if(wrapperInt==null) {
				throw new CustomException("Unable to find the Request Data");
			}else {
				emp=impl.getEmployeeDetails(emp_id);		
			}
		}catch(Exception e) {

			
			e.printStackTrace();

		}
		return new ResponseEntity<>(emp.get(),HttpStatus.OK);

	}

}
