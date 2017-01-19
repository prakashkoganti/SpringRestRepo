package com.java.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category_details")
public class CategoryDetails implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5730978325130362777L;

	@Id
	@Column(name = "Category_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Category_desc")
	private String categoryDesc;
	
	@OneToMany(mappedBy="categoryDetails")
	private Set<TimesheetDetails> timesheetDetailsSet;

	public CategoryDetails() {
		
	}
	public CategoryDetails(Long id, String categoryDesc) {
		super();
		this.id = id;
		this.categoryDesc = categoryDesc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public Set<TimesheetDetails> getTimesheetDetailsSet() {
		return timesheetDetailsSet;
	}
	public void setTimesheetDetailsSet(Set<TimesheetDetails> timesheetDetailsSet) {
		this.timesheetDetailsSet = timesheetDetailsSet;
	}

}