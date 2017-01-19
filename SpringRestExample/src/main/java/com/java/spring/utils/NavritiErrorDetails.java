package com.java.spring.utils;

import java.util.List;

import com.java.spring.dto.NavritiDto;

public class NavritiErrorDetails {

	public String errorCode;
	public String errorMessage;
	public List<NavritiDto> navritiDto;
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
	 * @return the navritiDto
	 */
	public List<NavritiDto> getNavritiDto() {
		return navritiDto;
	}
	/**
	 * @param navritiDto the navritiDto to set
	 */
	public void setNavritiDto(List<NavritiDto> navritiDto) {
		this.navritiDto = navritiDto;
	}
	
}
