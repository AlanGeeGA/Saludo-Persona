package org.microservicio.exception;

public class SinPersonasException extends RuntimeException {
	
	public SinPersonasException(String message) {
		super(message);
	}
	
}
