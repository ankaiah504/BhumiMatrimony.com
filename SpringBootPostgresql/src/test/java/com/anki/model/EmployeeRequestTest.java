package com.anki.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anki.models.EmployeeRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class EmployeeRequestTest {

	private Validator validator;

    @BeforeEach
    public void setUp() {
    	
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidEmployeeRequest() throws ParseException {
        EmployeeRequest request = new EmployeeRequest();
        request.setEmpName("John Doe");
        request.setPan("ABCDE1234F");
        String data="3030-12-12";
	     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	     Date date = formatter.parse(data);
     
        request.setDob(date);
        request.setSkills(List.of("Java", "Spring"));
        request.setJoiningDate(LocalDate.of(2022, 1, 1));
        request.setQualification("Bachelor's");
        request.setRole("Developer");

        Set<ConstraintViolation<EmployeeRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "Validation should succeed for valid request");
    }

}
