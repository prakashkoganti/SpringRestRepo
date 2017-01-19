package com.java.spring.utils;

import org.springframework.dao.DataIntegrityViolationException;

public class ExceptioUtil {//extends Exception {
	/*private static final long serialVersionUID = 4664456874499611218L;
	private String errorCode = "Unknown_Exception";

	public ExceptioUtil(String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}
	*/
	
	public static void CatchAndThrow(Exception e) throws ThrowingExcp{
		try{
			//e.printStackTrace();
			throw e;
		}catch(DataIntegrityViolationException ex){
			throw new ThrowingExcp(ex.getMostSpecificCause(), "My Exception");
		}catch(Exception ex){
			throw new ThrowingExcp(e.getCause(), "My Exception");
		}
	}
}
