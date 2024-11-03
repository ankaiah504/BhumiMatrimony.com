package com.anki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anki.models.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer>{

}
