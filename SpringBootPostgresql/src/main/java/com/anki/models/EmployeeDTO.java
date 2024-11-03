package com.anki.models;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {

		private int empId;
		
		private String empName;
		
		private String dept;
		
		private LocalDate joiningDate;

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}

		public EmployeeDTO() {
			super();
		}

		public EmployeeDTO(int empId, String empName, String dept, LocalDate joiningDate) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.dept = dept;
			this.joiningDate = joiningDate;
		}
		
		
	}


