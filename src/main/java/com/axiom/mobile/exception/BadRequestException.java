package com.axiom.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8398704540762490787L;

	public BadRequestException(String value) {
		super("Not a valid value: " + value);
		
	
	}
}
