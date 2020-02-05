package com.heber.backendfinddevs.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.heber.backendfinddevs.services.exception.ObjectNotAllowedException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotAllowedException.class)
	public ResponseEntity<StandardError> objectNotAllowed(ObjectNotAllowedException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Inserção não permitida",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
