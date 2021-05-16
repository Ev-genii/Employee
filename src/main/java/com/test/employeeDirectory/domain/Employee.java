package com.test.employeeDirectory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Surname cannot be empty")
	private String surname;
	
	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Last name cannot be empty")
	private String lastName;
	
	@NotBlank(message = "Position cannot be empty")
	private String position;
	
	@NotBlank(message = "Date of birth cannot be empty")
	private String dateOfBirth; 
	
	@NotBlank(message = "Mobile phone cannot be empty")
	private String mobilePhone; 
	
	@Email(message = "Email is not correct")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	
	private String filename;

	public Employee() {
	}

	public Employee(String surname, String name, String lastName, String position, String dateOfBirth,
			String mobilePhone, String email) {
		this.surname = surname;
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.dateOfBirth = dateOfBirth;
		this.mobilePhone = mobilePhone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
