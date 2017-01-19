package com.java.spring.controller;

import java.util.List;

import com.java.spring.constants.PortalConstants;

public class ErrorConstantDetails {

	public String errorCode;
	public String errorMessage;
	public List<PortalConstants> portalConstants;
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return the portalConstants
	 */
	public List<PortalConstants> getPortalConstants() {
		return portalConstants;
	}
	/**
	 * @param portalConstants the portalConstants to set
	 */
	public void setPortalConstants(List<PortalConstants> portalConstants) {
		this.portalConstants = portalConstants;
	}
	
}
