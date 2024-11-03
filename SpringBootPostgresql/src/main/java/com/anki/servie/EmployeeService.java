package com.anki.servie;

import java.util.Optional;

import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;

public interface EmployeeService {

	 EmployeeDTO saveEmployee(EmployeeRequest e);
	 
	 Optional<EmployeeDetails>  getEmployeeDetails(int id);
}
