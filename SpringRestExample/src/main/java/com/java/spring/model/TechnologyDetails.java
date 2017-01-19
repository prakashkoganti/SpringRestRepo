package com.java.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "technology_details")
public class TechnologyDetails implements Serializable {

	private static final long serialVersionUID = 2647861956999223791L;

	@Id
	@Column(name = "tech_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "technology_desc")
	private String technologyDesc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_user_id")
	private EmployeeDetails employeeDetails;

	public TechnologyDetails() {

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}


	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public String getTechnologyDesc() {
		return technologyDesc;
	}


	public void setTechnologyDesc(String technologyDesc) {
		this.technologyDesc = technologyDesc;
	}



}