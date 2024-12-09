package com.anki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anki.models.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer>{

	
//	@Query(nativeQuery =true ,value = "SELECT ea.id, ea.city, ea.state FROM gfgmicroservicesdemo.address ea join gfgmicroservicesdemo.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
}
