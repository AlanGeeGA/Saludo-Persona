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
	public ResponseEntity<ErrorDetails> SaludoExistenteException(PSQLException exception, WebRequest webRequest) {
		ErrorDetails errorDetalles = new ErrorDetails(900, "Tipo de saludo existente");
		return new ResponseEntity<>(errorDetalles, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
