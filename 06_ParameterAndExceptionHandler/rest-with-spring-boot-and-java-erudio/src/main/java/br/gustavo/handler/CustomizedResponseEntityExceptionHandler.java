package br.gustavo.handler;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.gustavo.exceptions.ExceptionsResponse;
import br.gustavo.exceptions.UnsuportedMathOperationsException;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionsResponse> handleAllExceptions(Exception ex, WebRequest request) {

		ExceptionsResponse exceptionResponse = new ExceptionsResponse(new Date(1), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnsuportedMathOperationsException.class)
	public final ResponseEntity<ExceptionsResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

		ExceptionsResponse exceptionResponse = new ExceptionsResponse(new Date(1), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
