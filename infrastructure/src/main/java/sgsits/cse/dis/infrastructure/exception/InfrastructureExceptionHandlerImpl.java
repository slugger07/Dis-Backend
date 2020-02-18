package sgsits.cse.dis.infrastructure.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.response.ResponseMessage;
/**
 * <h1>InfrastructureExceptionHandler</h1> class.
 * This class is exception handler containing handler for different exceptions.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */


@RestControllerAdvice
public class InfrastructureExceptionHandlerImpl {

	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> eventDoesNotExistException(HttpServletRequest request,Exception e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ConstraintViolationException.class,DataIntegrityViolationException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> integrityConstraintViolationExistException(HttpServletRequest request,Exception e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ConflictException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> conflictException(HttpServletRequest request,Exception e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> notValiException(HttpServletRequest request,MethodArgumentNotValidException e) {
		System.out.println(e);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Fill all mandatory field."), HttpStatus.BAD_REQUEST);
		
	}
}

