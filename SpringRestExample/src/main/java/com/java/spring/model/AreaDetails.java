package com.java.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Area_details")
public class AreaDetails implements Serializable {

	private static final long serialVersionUID = 1765157903658338655L;

	@Id
	@Column(name = "Area_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Area_desc")
	private String areaDesc;
	
	@OneToMany(mappedBy="areaDetails",cascade=CascadeType.ALL)
	private Set<TimesheetDetails> timesheetDetailsSet;
	
	public AreaDetails() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	public Set<TimesheetDetails> getTimesheetDetailsSet() {
		return timesheetDetailsSet;
	}

	public void setTimesheetDetailsSet(Set<TimesheetDetails> timesheetDetailsSet) {
		this.timesheetDetailsSet = timesheetDetailsSet;
	}

}