package com.anki.models;


public class PersonalDTO {

	private  int empId;
	
	private String name;
	
	private Double salary;

	public int getEmp() {
		return empId;
	}

	public void setEmp(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
}
