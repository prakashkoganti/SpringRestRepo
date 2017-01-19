package com.java.spring.utils;

public class ThrowingExcp extends Exception {
	private static final long serialVersionUID = 4664456874499611218L;
	private String errorCode = "Unknown_Exception";

	public ThrowingExcp(Throwable message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}
}
