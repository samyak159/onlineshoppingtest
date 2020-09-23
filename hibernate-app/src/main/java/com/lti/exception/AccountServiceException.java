package com.lti.exception;

public class AccountServiceException extends RuntimeException
{

	public AccountServiceException() {
		super();
		
	}

	public AccountServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

	public AccountServiceException(String message, Throwable cause) {
		super(message, cause);

	}

	public AccountServiceException(String message) {
		super(message);
	
	}

	public AccountServiceException(Throwable cause) {
		super(cause);
		
	}
	
}
