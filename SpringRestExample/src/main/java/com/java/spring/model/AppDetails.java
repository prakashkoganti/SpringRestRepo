package com.java.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "App_details")
public class AppDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5280275945564435186L;

	@Id
	@Column(name = "app_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "app_desc")
	private String appDesc;
	
	@OneToMany(mappedBy="appDetails")
	private Set<TimesheetDetails> timesheetDetailsSet;
	
	@OneToMany(mappedBy="empAppDetails")
	private Set<EmployeeDetails> employeeDetailsSet;
	
	@ManyToOne
	@JoinColumn(name = "portfolio_id")
	private PortfolioDetails portfolioDetails;
	
	
	public AppDetails() {

	}

	public AppDetails(Long id, String appDesc) {
		super();
		this.id = id;
		this.appDesc = appDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public Set<TimesheetDetails> getTimesheetDetailsSet() {
		return timesheetDetailsSet;
	}

	public void setTimesheetDetailsSet(Set<TimesheetDetails> timesheetDetailsSet) {
		this.timesheetDetailsSet = timesheetDetailsSet;
	}

	public PortfolioDetails getPortfolioDetails() {
		return portfolioDetails;
	}

	public void setPortfolioDetails(PortfolioDetails portfolioDetails) {
		this.portfolioDetails = portfolioDetails;
	}

	public Set<EmployeeDetails> getEmployeeDetailsSet() {
		return employeeDetailsSet;
	}

	public void setEmployeeDetailsSet(Set<EmployeeDetails> employeeDetailsSet) {
		this.employeeDetailsSet = employeeDetailsSet;
	}

}