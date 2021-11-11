package com.interaxa.app.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PersonRequest {

	@NotEmpty(message = "Name cannot be empty")
	@NotNull(message = "Name cannot be null")
	private String firstName;

	@NotEmpty(message = "Lastname cannot be empty")
	@NotNull(message = "Lastname cannot be null")
	private String lastName;

	private Long dni;

	private Boolean employee;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}
	
	

}
