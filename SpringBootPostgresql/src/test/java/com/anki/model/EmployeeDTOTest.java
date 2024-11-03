package com.anki.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.anki.models.EmployeeDTO;

public class EmployeeDTOTest {

	private EmployeeDTO employeeDTO;

    @BeforeEach
    public void setUp() {
        employeeDTO = new EmployeeDTO();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(0, employeeDTO.getEmpId());
        assertEquals(null, employeeDTO.getEmpName());
        assertEquals(null, employeeDTO.getDept());
        assertEquals(null, employeeDTO.getJoiningDate());
    }

    @Test
    public void testParameterizedConstructor() {
        LocalDate joiningDate = LocalDate.of(2023, 1, 1);
        employeeDTO = new EmployeeDTO(1, "John Doe", "Engineering", joiningDate);
        
        assertEquals(1, employeeDTO.getEmpId());
        assertEquals("John Doe", employeeDTO.getEmpName());
        assertEquals("Engineering", employeeDTO.getDept());
        assertEquals(joiningDate, employeeDTO.getJoiningDate());
    }

    @Test
    public void testSetEmpId() {
        employeeDTO.setEmpId(2);
        assertEquals(2, employeeDTO.getEmpId());
    }

    @Test
    public void testSetEmpName() {
        employeeDTO.setEmpName("Jane Doe");
        assertEquals("Jane Doe", employeeDTO.getEmpName());
    }

    @Test
    public void testSetDept() {
        employeeDTO.setDept("HR");
        assertEquals("HR", employeeDTO.getDept());
    }

    @Test
    public void testSetJoiningDate() {
        LocalDate joiningDate = LocalDate.of(2023, 10, 1);
        employeeDTO.setJoiningDate(joiningDate);
        assertEquals(joiningDate, employeeDTO.getJoiningDate());
    }
}
