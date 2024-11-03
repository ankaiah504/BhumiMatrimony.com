package com.anki.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.anki.models.EmployeeRequest;

@SpringBootTest

public class EmployeeDetailsTest {
	 private EmployeeRequest employeeRequest;

	    @BeforeEach
	    public void setUp() {
	        employeeRequest = new EmployeeRequest();
	    }

	    @Test
	    public void testDefaultConstructor() {
	        assertNull(employeeRequest.getEmpName());
	        assertNull(employeeRequest.getPan());
	        assertNull(employeeRequest.getDob());
	        assertNull(employeeRequest.getSkills());
	        assertNull(employeeRequest.getJoiningDate());
	        assertNull(employeeRequest.getQualification());
	        assertNull(employeeRequest.getRole());
	    }

	    @Test
	    public void testParameterizedConstructor() {
	        LocalDate joiningDate = LocalDate.of(2023, 1, 1);
	        Date dob = new Date(); // Use the current date for testing
	        List<String> skills = Arrays.asList("Java", "Spring");
	        
	        employeeRequest = new EmployeeRequest("John Doe", "ABCDE1234F", dob, skills, joiningDate, "B.Tech", "Developer");

	        assertEquals("John Doe", employeeRequest.getEmpName());
	        assertEquals("ABCDE1234F", employeeRequest.getPan());
	        assertEquals(dob, employeeRequest.getDob());
	        assertEquals(skills, employeeRequest.getSkills());
	        assertEquals(joiningDate, employeeRequest.getJoiningDate());
	        assertEquals("B.Tech", employeeRequest.getQualification());
	        assertEquals("Developer", employeeRequest.getRole());
	    }

	    @Test
	    public void testSetEmpName() {
	        employeeRequest.setEmpName("Jane Doe");
	        assertEquals("Jane Doe", employeeRequest.getEmpName());
	    }

	    @Test
	    public void testSetPan() {
	        employeeRequest.setPan("XYZAB1234C");
	        assertEquals("XYZAB1234C", employeeRequest.getPan());
	    }

	    @Test
	    public void testSetDob() {
	        Date dob = new Date(); // Use the current date for testing
	        employeeRequest.setDob(dob);
	        assertEquals(dob, employeeRequest.getDob());
	    }

	    @Test
	    public void testSetSkills() {
	        List<String> skills = Arrays.asList("Java", "JavaScript");
	        employeeRequest.setSkills(skills);
	        assertEquals(skills, employeeRequest.getSkills());
	    }

	    @Test
	    public void testSetJoiningDate() {
	        LocalDate joiningDate = LocalDate.of(2023, 10, 1);
	        employeeRequest.setJoiningDate(joiningDate);
	        assertEquals(joiningDate, employeeRequest.getJoiningDate());
	    }

	    @Test
	    public void testSetQualification() {
	        employeeRequest.setQualification("M.Tech");
	        assertEquals("M.Tech", employeeRequest.getQualification());
	    }

	    @Test
	    public void testSetRole() {
	        employeeRequest.setRole("Senior Developer");
	        assertEquals("Senior Developer", employeeRequest.getRole());
	    }
}