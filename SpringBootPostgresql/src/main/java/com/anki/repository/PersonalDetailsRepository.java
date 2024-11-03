package com.anki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anki.models.PersonalDetails;

public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Integer>{

}
