//package com.anki.repo;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//import org.junit.jupiter.api.BeforeEach;
//
//import com.anki.models.EmployeeDetails;
//import com.anki.models.EmployeeRequest;
//import com.anki.repository.EmployeeRepository;
//
//public class EmployeeTestRepo {
//
//	 private EmployeeRepository repo;
//
//	    @BeforeEach
//	    public void setUp() {
//	    	EmployeeRequest employee=new EmployeeRequest();
//	        employee.setEmpName("John Doe");
//	        employee.setRole("Developer");
//	        employee.setDob(java.sql.Date.valueOf("1990-01-01"));
//	        employee.setJoiningDate(LocalDate.of(2022, 1, 1));
//	        employee.setSkills(Arrays.asList("Java", "Spring", "Hibernate"));
//	        employee.setPan("AXFPN9904T");
//	        employee.save(employee);
//	    }
//}
