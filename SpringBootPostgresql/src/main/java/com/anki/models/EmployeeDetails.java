package com.anki.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="employee_details",uniqueConstraints = @UniqueConstraint(columnNames = "pan"))
@NamedNativeQuery(name = "EmployeeDetails.findByEmployeeId", query = "select * from employee_details where emp_id = ?1", resultClass = EmployeeDetails.class)

public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int id;
	@Column(name = "employee_name",length = 100)
	private String empName;
	private String role;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate joiningDate;
	private List<String> skills;
	@OneToOne(mappedBy = "employeeDetails")
	private PersonalDetails persionalDetails;
	@Column(name ="pan", unique = true, nullable = false)
	private String pan;
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
	public PersonalDetails getPersionalDetails() {
		return persionalDetails;
	}
	public void setPersionalDetails(PersonalDetails persionalDetails) {
		this.persionalDetails = persionalDetails;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
}
