package com.java.spring.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Emp {

	private String sapId;
	private String empName;
	private String projectName;
	private List<String> technologys;
	private String dateOfbirth;
	private String mobile;
	private String accentureEmail;
	private String personalEmail;
	private String sex;
	private  List<String>  hobbies;
	private String hobby;
	private String username;
	private String pwd;
	private String aboutMe;
	private boolean login;
	private MultipartFile imgSrc;
	private byte[] fetchImage;
	private Long dpid;
	private Long empId;
	private String errorMsg;
	
	private StatusDto errorStatus=new StatusDto();
	private Long appId;
	private String appName;

	public byte[] getFetchImage() {
		return fetchImage;
	}

	public void setFetchImage(byte[] fetchImage) {
		this.fetchImage = fetchImage;
	}

	public Emp() {
	}


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDateOfbirth() {
		return dateOfbirth;
	}

	public void setDateOfbirth(String dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAccentureEmail() {
		return accentureEmail;
	}

	public void setAccentureEmail(String accentureEmail) {
		this.accentureEmail = accentureEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}


	public MultipartFile getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(MultipartFile imgSrc) {
		this.imgSrc = imgSrc;
	}

	public Long getDpid() {
		return dpid;
	}

	public void setDpid(Long dpid) {
		this.dpid = dpid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getTechnologys() {
		return technologys;
	}

	public void setTechnologys(List<String> technologys) {
		this.technologys = technologys;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getSapId() {
		return sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public StatusDto getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(StatusDto errorStatus) {
		this.errorStatus = errorStatus;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

}