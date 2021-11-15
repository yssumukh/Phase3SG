package com.Phase3project.Phase3projsocgen.exception;


public class UserNotFoundException extends Throwable
{
	private String message;

	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}

	public UserNotFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
