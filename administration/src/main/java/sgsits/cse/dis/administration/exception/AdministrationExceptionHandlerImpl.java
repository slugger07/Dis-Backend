package sgsits.cse.dis.administration.exception;


import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import sgsits.cse.dis.administration.response.ExceptionResponseJSON;
/**
 * <h1>AdministrationExceptionHandler</h1> class.
 * This class is exception handler containing handler for different exceptions.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
@RestControllerAdvice
public class AdministrationExceptionHandlerImpl {

	@ExceptionHandler({EventDoesNotExistException.class})
	@ResponseBody
	
	public ResponseEntity<ExceptionResponseJSON> eventDoesNotExistException(HttpServletRequest request,EventDoesNotExistException exception) {
		return new ResponseEntity<ExceptionResponseJSON>(new ExceptionResponseJSON(request.getRequestURL().toString(), exception.getMessage(),HttpStatus.NOT_FOUND,HttpStatus.valueOf("NOT_FOUND")),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ConflictException.class})
	@ResponseBody
	public ResponseEntity<ExceptionResponseJSON> conflictEcException(HttpServletRequest request,ConflictException exception) {
		return new ResponseEntity<ExceptionResponseJSON>(new ExceptionResponseJSON(request.getRequestURL().toString(), exception.getMessage(),HttpStatus.CONFLICT,HttpStatus.valueOf("CONFLICT")),HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler({ParseException.class})
	@ResponseBody
	
	public ResponseEntity<ExceptionResponseJSON> parseException(HttpServletRequest request,EventDoesNotExistException exception) {
		return new ResponseEntity<ExceptionResponseJSON>(new ExceptionResponseJSON(request.getRequestURL().toString(), exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR,HttpStatus.valueOf("INTERNAL_SERVER_ERROR")),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

