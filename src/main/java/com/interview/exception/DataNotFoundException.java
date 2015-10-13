package com.interview.exception;

public class DataNotFoundException extends Exception {
	
	private static final long serialVersionUID = -1925686927868402695L;

	private String message;
	
	private String code;
	
	public DataNotFoundException(String message) {
		this.message = message;
		this.code = ErrorCode.DEFAULT_CODE;
	}
	
	public DataNotFoundException(String message, String code) {
		this.message = message;
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
