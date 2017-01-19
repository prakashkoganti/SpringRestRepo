package com.java.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portal_constants")
public class PortalConstantsDetails implements Serializable {

	private static final long serialVersionUID = -3395067890881712084L;

	@Id
	@Column(name = "constant_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long constantId;

	@Column(name = "constant_key")
	private String constantKey;
	
	@Column(name = "constant_value")
	private String constantValue;

	/**
	 * @return the constantId
	 */
	public Long getConstantId() {
		return constantId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PortalConstantsDetails [constantId=" + constantId + ", constantKey=" + constantKey + ", constantValue="
				+ constantValue + "]";
	}

	/**
	 * @param constantId the constantId to set
	 */
	public void setConstantId(Long constantId) {
		this.constantId = constantId;
	}

	/**
	 * @return the constantKey
	 */
	public String getConstantKey() {
		return constantKey;
	}

	/**
	 * @param constantKey the constantKey to set
	 */
	public void setConstantKey(String constantKey) {
		this.constantKey = constantKey;
	}

	/**
	 * @return the constantValue
	 */
	public String getConstantValue() {
		return constantValue;
	}

	/**
	 * @param constantValue the constantValue to set
	 */
	public void setConstantValue(String constantValue) {
		this.constantValue = constantValue;
	}

	
}