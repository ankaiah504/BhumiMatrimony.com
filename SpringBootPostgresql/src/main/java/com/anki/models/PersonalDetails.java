package com.anki.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PersonalDetails {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "pan", unique = true, nullable = false)
	private String pan;
	
	private String name;
	
	private String salary;

	@OneToOne
    @JoinColumn(name = "employee_details_id")
	private EmployeeDetails employeeDetails;
	
	@OneToMany(mappedBy="personalDetails",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<AddressDetails> addressDetails;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public PersonalDetails(int id, String pan, String name, String salary, EmployeeDetails employeeDetails) {
		super();
		this.id = id;
		this.pan = pan;
		this.name = name;
		this.salary = salary;
		this.employeeDetails = employeeDetails;
	}

	public PersonalDetails() {
		super();
	}
	
	
	
}
