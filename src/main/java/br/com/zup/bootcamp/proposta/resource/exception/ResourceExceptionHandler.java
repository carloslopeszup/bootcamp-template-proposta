package br.com.zup.bootcamp.proposta.resource.exception;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.zup.bootcamp.proposta.exception.UnprocessableEntityException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(UnprocessableEntityException.class)
	public ResponseEntity<StandardError>unprocessableEntityException(UnprocessableEntityException e, HttpRequest http){
		
		StandardError err 
		= new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage(), System.currentTimeMillis());
	
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
}
