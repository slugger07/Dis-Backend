package sgsits.cse.dis.administration.exceptionHandler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import sgsits.cse.dis.administration.exception.BookDoesNotExistException;

@RestControllerAdvice
public class LibraryExceptionHandler {

	@ExceptionHandler
	public String handleBookNotFoundController(BookDoesNotExistException exception) {
		return exception.getMessage();
	}
}
