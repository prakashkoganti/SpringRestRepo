package com.java.spring.constants;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PortalConstants {

	private Long constantId;
	private String constantKey;
	private String constantValue;
	/**
	 * @return the constantId
	 */
	public Long getConstantId() {
		return constantId;
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
