package com.axiom.mobile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;

@ControllerAdvice
public class MobileExceptionController {
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> badRequestException(BadRequestException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ResourceAccessException.class)
	public ResponseEntity<Object> unknownHostException(ResourceAccessException exception) {
		return new ResponseEntity<>("Handset Search API is not reachable. Please try after sometime",
				HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<Object> internalServerException(RuntimeException exception) {
		return new ResponseEntity<>("There is some unexpected error in the system.Please contact Axiom Telecom support",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}