package com.java.spring.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "Employee_timesheet")
public class TimesheetDetails implements Serializable {

	private static final long serialVersionUID = 4584104875755641764L;

	@Id
	@Column(name = "time_sheet_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "Area_id")
	private AreaDetails areaDetails;

	@ManyToOne
	@JoinColumn(name = "Category_id")
	private CategoryDetails categoryDetails;

	@ManyToOne
	@JoinColumn(name = "app_id")
	private AppDetails appDetails;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_user_id", nullable = false)
	private EmployeeDetails employeeDetails;
	
	@Column(name = "area")
	private String area;

	@Column(name = "ticket_id")
	private String ticketId;

	@Column(name = "task_desc")
	private String taskDesc;

	@Column(name = "td_hours")
	private Long timeSheetHours;

	@Column(name = "td_date")
	private Date timeSheetDate;
	
	@Column(name = "updated_timestamp")
	private Date updatedTimestamp;
	
	@Column(name = "created_timestamp")
	private Date createdTimestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public Long getTimeSheetHours() {
		return timeSheetHours;
	}

	public void setTimeSheetHours(Long timeSheetHours) {
		this.timeSheetHours = timeSheetHours;
	}

	public Date getTimeSheetDate() {
		return timeSheetDate;
	}

	public void setTimeSheetDate(Date timeSheetDate) {
		this.timeSheetDate = timeSheetDate;
	}

	public AppDetails getAppDetails() {
		return appDetails;
	}

	public void setAppDetails(AppDetails appDetails) {
		this.appDetails = appDetails;
	}

	public CategoryDetails getCategoryDetails() {
		return categoryDetails;
	}

	public void setCategoryDetails(CategoryDetails categoryDetails) {
		this.categoryDetails = categoryDetails;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public AreaDetails getAreaDetails() {
		return areaDetails;
	}

	public void setAreaDetails(AreaDetails areaDetails) {
		this.areaDetails = areaDetails;
	}

}