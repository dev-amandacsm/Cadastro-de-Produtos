package com.projetweb.cadproduto.resources.excepetions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetweb.cadproduto.services.exceptions.DatabaseException;
import com.projetweb.cadproduto.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler (ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e , HttpServletRequest request){
		
		 String erro = "Recurso não encontrado";
		 HttpStatus status = HttpStatus.NOT_FOUND;
		 StandardError err = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e , HttpServletRequest request){
		
		 String erro = "Erro no Database";
		 HttpStatus status = HttpStatus.BAD_REQUEST;
		 StandardError err = new StandardError(Instant.now(),status.value(),erro,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
}
