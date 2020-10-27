package sgsits.cse.dis.administration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceRequestNotFoundException extends RuntimeException {

	public ResourceRequestNotFoundException(String message) {
		super(message);
	}
	
}
