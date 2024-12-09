package com.anki.service.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;
import com.anki.repository.EmployeeRepository;
import com.anki.service.impl.EmployeeImpl;

@SpringBootTest
public class EmployeeImplTest {

	@InjectMocks
	private EmployeeImpl employeeService;

	@Mock
	private EmployeeRepository repo;


	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	public void testSaveEmployee() throws Exception {
	    int empid = 1;
	    String dateString = "2023-10-20";
	    EmployeeRequest request = new EmployeeRequest();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = formatter.parse(dateString);
	    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate date1 = LocalDate.parse(dateString, formatter1);

	    request.setDob(date);
	    request.setEmpName("Anki");
	    request.setJoiningDate(date1);
	    request.setPan("AXFPN9904S");
	    request.setQualification("TEst");
	    request.setRole("SE");
	    request.setSkills(null);

	    EmployeeDetails test = new EmployeeDetails();
	    test.setDob(request.getDob());
	    test.setEmpName(request.getEmpName());
	    test.setId(empid);
	    test.setJoiningDate(request.getJoiningDate());
	    test.setPan(request.getPan());
	    test.setRole(request.getRole());

	    // Mocking the save operation
	    when(repo.save(test)).thenReturn(test);

	    EmployeeDetails test1 = repo.save(test); // this should now return the mocked object

	    EmployeeDTO dto = new EmployeeDTO();
	    dto.setEmpId(empid);
	    dto.setEmpName(test1.getEmpName());
	    dto.setJoiningDate(test1.getJoiningDate());
	    dto.setDept("Computer");

//	    when(employeeService.saveEmployee(request)).thenReturn(dto);

	    // Additional assertions to verify behavior
	}
	@Test
	public void testGetEmployee() throws Exception {
		int empId = 1;
		String dateString = "2023-10-20";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(dateString);
		EmployeeDetails employee = new EmployeeDetails();
		employee.setDob(date);
		employee.setEmpName("Anki");
		employee.setId(empId);
		employee.setPan("AXFPN9904S");
		employee.setPersionalDetails(null);
		when(repo.findById(empId)).thenReturn(Optional.of(employee));

		Optional<EmployeeDetails> result = employeeService.getEmployeeDetails(empId);

		assertThat(result).isPresent();
		assertThat(result.get().getEmpName()).isEqualTo("Anki");
	}
}
