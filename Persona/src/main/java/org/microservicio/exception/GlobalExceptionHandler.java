package org.microservicio.exception;

import org.microservicio.response.ErrorDetails;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<ErrorDetails> nombreExistenteException(PSQLException exception, WebRequest webRequest) {
		ErrorDetails errorDetalles = new ErrorDetails(800, "Nombre existente, guardar otro nombre");
		return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(SinPersonasException.class)
	public ResponseEntity<ErrorDetails> sinPersonasException(SinPersonasException exception, WebRequest webRequest) {
		ErrorDetails errorDetalles = new ErrorDetails(1500, "No hay personas en la base de datos");
		return new ResponseEntity<>(errorDetalles, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorDetails> personaDesconocidaException(NullPointerException exception, WebRequest webRequest) {
		ErrorDetails errorDetalles = new ErrorDetails(1000, "Persona desconocida");
		return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
