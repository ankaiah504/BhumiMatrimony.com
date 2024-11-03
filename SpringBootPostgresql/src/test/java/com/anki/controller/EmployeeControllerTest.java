package com.anki.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.anki.exception.GenaricException;
import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;
import com.anki.service.impl.EmployeeImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(EmployeeController.class)

public class EmployeeControllerTest {


	@MockBean
	private EmployeeImpl impl;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	EmployeeDTO dto; 
	EmployeeRequest request;
	@BeforeEach
	public void setUp() throws Exception {
		request = new EmployeeRequest();
		dto = new EmployeeDTO();

		request.setEmpName("John Doe");
		request.setPan("ABCDE1234F");

		String data = "2030-12-12"; // Adjust the date as needed
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(data);
		request.setDob(date);
		request.setSkills(List.of("Java", "Spring"));
		request.setJoiningDate(LocalDate.of(2022, 1, 1));
		request.setQualification("Bachelor's");
		request.setRole("Developer");

		dto.setDept("Developer");
		dto.setEmpId(1);
		dto.setEmpName("Ankaiah");	    }

	@Test
	public void saveEmployeeDetails() throws Exception {
		if(request.getDob()==null) {
	        Exception exception = assertThrows(GenaricException.class, () -> {
	        	when(impl.saveEmployee(request)).thenReturn(dto);
	        });
	        assertEquals("Unable to find the Request Data", exception.getMessage());
		}
		String jsonRequest = objectMapper.writeValueAsString(request);

		mockMvc.perform(post("/api/emp/register")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRequest))
		.andExpect(status().isOk()); // Adjust based on your expected response

	}
	@Test
	public void getEmployeeDetails() throws Exception {
	    int empId = 1;
        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setId(empId);
        employeeDetails.setEmpName("John Doe");
        
	    when(impl.getEmployeeDetails(empId)).thenReturn(Optional.of(employeeDetails));

	    mockMvc.perform(get("/api/emp/{emp_id}", empId)
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk()); // Adjust based on your logic
	}
}
