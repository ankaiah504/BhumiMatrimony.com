package com.anki.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {
	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be null")
	private String empName;
	private String pan;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;

	private List<String> skills;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;

	private String qualification;

	private String role;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public EmployeeRequest(String empName, String pan, Date dob, List<String> skills, LocalDate joiningDate,
			String qualification, String role) {
		super();
		this.empName = empName;
		this.pan = pan;
		this.dob = dob;
		this.skills = skills;
		this.joiningDate = joiningDate;
		this.qualification = qualification;
		this.role = role;
	}

	public EmployeeRequest() {
		super();
	}





}
