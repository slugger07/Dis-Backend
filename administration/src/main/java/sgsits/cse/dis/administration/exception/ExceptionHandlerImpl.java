package sgsits.cse.dis.administration.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import sgsits.cse.dis.administration.exception.EventDoesNotExistException;
import sgsits.cse.dis.administration.response.ExceptionResponseJSON;

@RestControllerAdvice
public class ExceptionHandlerImpl {

	@ExceptionHandler({EventDoesNotExistException.class})
	@ResponseBody
	public ExceptionResponseJSON EventDoesNotExistException(HttpServletRequest request,EventDoesNotExistException exception) {
		return new ExceptionResponseJSON(request.getRequestURL().toString(), exception.getMessage(),HttpStatus.NOT_FOUND,HttpStatus.valueOf("NOT_FOUND"));
	}
	
	
}
 