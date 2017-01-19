package com.java.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personal_image")
public class PersonalImage implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9098895481641359436L;

	@Id
	@Column(name = "PI_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long piId;
	
	@Lob
	@Column(name = "PI_IMAGE",columnDefinition="longblob")
	private byte[] image;

	@Column(name="PI_IMAGE_NAME", nullable=false)
	private String imageName;
	
//	@ManyToOne
//	@JoinColumn(name = "emp_user_id", nullable = false)
//	private EmployeeDetails employeeDetails;
	 
	public Long getPiId() {
		return piId;
	}

	public void setPiId(Long piId) {
		this.piId = piId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public PersonalImage() {
	}

}