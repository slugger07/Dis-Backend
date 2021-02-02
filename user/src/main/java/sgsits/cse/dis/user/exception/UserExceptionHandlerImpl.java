package sgsits.cse.dis.user.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;
import sgsits.cse.dis.user.message.response.ResponseMessage;

import java.util.NoSuchElementException;

/**
 * <h1>UserExceptionHandler</h1> class.
 * This class is exception handler containing handler for different exceptions.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */

@RestControllerAdvice
public class UserExceptionHandlerImpl {


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


	@ExceptionHandler({InternalServerError.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> internalServerErrorException(HttpServletRequest request,Exception e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler({NoSuchElementException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> noSuchElementException(HttpServletRequest request,Exception e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()),HttpStatus.NOT_FOUND);
	}
}

