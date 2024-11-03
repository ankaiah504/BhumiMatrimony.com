package com.anki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anki.models.AddressDetails;

public interface AddressDetailsRepository extends JpaRepository<AddressDetails, Integer> {

}
