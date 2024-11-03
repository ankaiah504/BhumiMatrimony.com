package com.anki.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AddressDetails {

	@Id
	private int emp_id;
	
	private char addressType;
	
	private String flaot;
	
	private String Streat;
	
	private String country;
	
	private String pincode;
	@ManyToOne
	 @JoinColumn(name = "personal_details_id", nullable = false)
	private PersonalDetails personalDetails;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public char getAddressType() {
		return addressType;
	}
	public void setAddressType(char addressType) {
		this.addressType = addressType;
	}
	public String getFlaot() {
		return flaot;
	}
	public void setFlaot(String flaot) {
		this.flaot = flaot;
	}
	public String getStreat() {
		return Streat;
	}
	public void setStreat(String streat) {
		Streat = streat;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}
	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}
	public AddressDetails(int emp_id, char addressType, String flaot, String streat, String country, String pincode,
			PersonalDetails personalDetails) {
		super();
		this.emp_id = emp_id;
		this.addressType = addressType;
		this.flaot = flaot;
		Streat = streat;
		this.country = country;
		this.pincode = pincode;
		this.personalDetails = personalDetails;
	}
	
}
