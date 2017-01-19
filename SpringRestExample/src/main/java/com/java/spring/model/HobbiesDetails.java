package com.java.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hobbies_details")
public class HobbiesDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5280275945564435186L;

	@Id
	@Column(name = "hobbies_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "hobbies_desc")
	private String hobbiesDesc;
	
	@ManyToOne
	@JoinColumn(name = "emp_user_id", nullable = false)
	private EmployeeDetails employeeDetails;

	public HobbiesDetails() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getHobbiesDesc() {
		return hobbiesDesc;
	}


	public void setHobbiesDesc(String hobbiesDesc) {
		this.hobbiesDesc = hobbiesDesc;
	}


	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}


	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}



}