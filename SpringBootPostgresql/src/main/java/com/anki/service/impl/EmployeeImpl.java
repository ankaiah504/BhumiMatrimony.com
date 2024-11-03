package com.anki.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anki.exception.CustomException;
import com.anki.models.EmployeeDTO;
import com.anki.models.EmployeeDetails;
import com.anki.models.EmployeeRequest;
import com.anki.repository.EmployeeRepository;
import com.anki.servie.EmployeeService;
import com.anki.utility.DateFormat;

import jakarta.transaction.Transactional;

@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
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
	public Optional<EmployeeDetails> getEmployeeDetails(int id) {
		
		Optional<EmployeeDetails> rmp=repo.findById(id);
		if(rmp.isPresent()) {
			System.out.println(rmp.get());
		}
		
		return rmp;
		
	}
	
}