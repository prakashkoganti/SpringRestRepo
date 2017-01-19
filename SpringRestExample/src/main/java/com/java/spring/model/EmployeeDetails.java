package com.java.spring.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Employee_Details", uniqueConstraints = { @UniqueConstraint(columnNames = "accenture_email_id") })
public class EmployeeDetails implements Serializable {

	private static final long serialVersionUID = -3395067890881712084L;

	@Id
	@Column(name = "emp_user_id")
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "Emp_sap_id")
	private String sapId;

	@Column(name = "personal_email_id")
	private String personalEmailId;

	@Column(name = "emp_sex")
	private String sex;

	@Column(name = "aboutMe")
	private String aboutMe;

	@Column(name = "accenture_email_id")
	private String accentureEmailId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "technology_name")
	private String technologyName;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "hobbies")
	private String hobby;

	@Column(name = "date_Of_birth")
	private Date dateOfbirth;

	@OneToOne(targetEntity = UserLogin.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_login_id", referencedColumnName = "user_login_id")
	private UserLogin userLogin;

	@ManyToOne
	@JoinColumn(name = "app_id")
	private AppDetails empAppDetails;
	// @OneToMany(mappedBy = "employeeDetails")
	// private PersonalImage personalImage=new PersonalImage();

	@OneToMany(mappedBy = "employeeDetails")
	private Set<HobbiesDetails> hobbiesDetails = new HashSet<HobbiesDetails>();

	@OneToMany(mappedBy = "employeeDetails")
	private Set<TechnologyDetails> technologyDetails = new HashSet<TechnologyDetails>();

	@OneToMany(mappedBy = "employeeDetails")
	private Set<TimesheetDetails> timesheetDetails = new HashSet<TimesheetDetails>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	public String getAccentureEmailId() {
		return accentureEmailId;
	}

	public void setAccentureEmailId(String accentureEmailId) {
		this.accentureEmailId = accentureEmailId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(Date dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	// public UserLogin getUserLogin() {
	// return userLogin;
	// }
	//
	// public void setUserLogin(UserLogin userLogin) {
	// this.userLogin = userLogin;
	// }

	public Set<TimesheetDetails> getTimesheetDetails() {
		return timesheetDetails;
	}

	public void setTimesheetDetails(Set<TimesheetDetails> timesheetDetails) {
		this.timesheetDetails = timesheetDetails;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Set<TechnologyDetails> getTechnologyDetails() {
		return technologyDetails;
	}

	public void setTechnologyDetails(Set<TechnologyDetails> technologyDetails) {
		this.technologyDetails = technologyDetails;
	}

	public Set<HobbiesDetails> getHobbiesDetails() {
		return hobbiesDetails;
	}

	public void setHobbiesDetails(Set<HobbiesDetails> hobbiesDetails) {
		this.hobbiesDetails = hobbiesDetails;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public AppDetails getEmpAppDetails() {
		return empAppDetails;
	}

	public void setEmpAppDetails(AppDetails empAppDetails) {
		this.empAppDetails = empAppDetails;
	}

}