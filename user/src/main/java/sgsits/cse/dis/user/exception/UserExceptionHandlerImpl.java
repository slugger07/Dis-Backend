package sgsits.cse.dis.user.exception;




import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javassist.NotFoundException;



@RestControllerAdvice
public class UserExceptionHandlerImpl {

	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ResponseEntity<String> eventDoesNotExistException(HttpServletRequest request,NotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseBody
	public ResponseEntity<String> integrityConstraintViolationExistException(HttpServletRequest request) {
		return new ResponseEntity<String>("This user is already assigned to same task.",HttpStatus.NOT_FOUND);
	}

}

