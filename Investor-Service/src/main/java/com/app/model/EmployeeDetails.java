package com.app.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class EmployeeDetails {
	private int id;

	private String empName;
	private String role;
	private Date dob;
	private LocalDate joiningDate;
	private List<String> skills;

	private String pan;

	public EmployeeDetails(int id, String empName, String role, Date dob, LocalDate joiningDate, List<String> skills,
			String pan) {
		super();
		this.id = id;
		this.empName = empName;
		this.role = role;
		this.dob = dob;
		this.joiningDate = joiningDate;
		this.skills = skills;
		this.pan = pan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
	
}
