package us.brianolsen.spring.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		return "error";
		
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(AccessDeniedException ex){
		return "denied";
		
	}
}
