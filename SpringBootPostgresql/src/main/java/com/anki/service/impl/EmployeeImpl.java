package com.anki.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.anki.constant.AppConstants;
import com.anki.exception.CustomException;
import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;
import com.anki.models.PersonRequest;
import com.anki.models.PersonalDTO;
import com.anki.models.PersonalDetails;
import com.anki.repository.EmployeeRepository;
import com.anki.repository.PersonalDetailsRepository;
import com.anki.servie.EmployeeService;
import com.anki.utility.DateFormat;

import jakarta.transaction.Transactional;

@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	@Autowired
	private PersonalDetailsRepository personalRepo;
	@Autowired
	private KafkaTemplate<String, EmployeeDetails> kafkaTemplate;
	@Transactional
	@Override
	public EmployeeDTO saveEmployee(EmployeeRequest e) {
	
		try {
			if(e.getEmpName()!=null) {

				EmployeeDTO dto=new EmployeeDTO();			
				DateFormat date=new DateFormat();
				if(e.getDob() !=null) {
				Date dob=date.formateDate( e.getDob());
				EmployeeDetails emp=new EmployeeDetails();
				emp.setEmpName(e.getEmpName());
				emp.setDob(dob);
				emp.setJoiningDate(LocalDate.now());
				emp.setRole(e.getRole());
				emp.setSkills(e.getSkills());
				emp.setPan(e.getPan());
				EmployeeDetails em=repo.save(emp);
				sendEmployeeToKafka(em);

				dto.setEmpId(em.getId());
				dto.setEmpName(em.getEmpName());
				dto.setDept(em.getRole());
				dto.setJoiningDate(em.getJoiningDate());
				}else {
					throw new CustomException("Date should not be  empty");

				}
				return dto;
			}else {
				throw new CustomException("Unable to find the Request Data");
			}
		}catch(Exception ex) {
			throw ex;
		}
	


	}
	@Override
	public EmployeeDetails getEmployeeDetails(int id) {
		
		Optional<EmployeeDetails> rmp = repo.findById(id);
	    
	    // If not found, throw CustomException
	    EmployeeDetails employee = rmp.orElseThrow(() -> new CustomException("Employee not found with id: " + id));

	    // Return the employee details
	    return employee;
		
	}
	   public void sendEmployeeToKafka(EmployeeDetails employeeRequest) {
	        kafkaTemplate.send(AppConstants.TOPIC, employeeRequest); // Send employee data to Kafka topic
	    }
	@Override
	public PersonalDTO savePersonalDetails(PersonRequest e) {
		PersonalDTO dto=null;
		try {
			
			EmployeeDetails ls=	repo.findByEmployeeId(e.getEmpId());
			if(!ls.getPan().isEmpty()) {
				PersonalDetails details =new PersonalDetails();
				details.setEmpId(e.getEmpId());
				details.setName(e.getEmpName());
				details.setPan(e.getPan());
				details.setSalary(e.getSalary());
				PersonalDetails em=personalRepo.save(details);

				dto=new PersonalDTO();
				dto.setEmp(details.getEmpId());
				dto.setName(details.getName());
				dto.setSalary(details.getSalary());
			}else {
				throw new Exception("DATA modifcation");

			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return dto;
	}

}