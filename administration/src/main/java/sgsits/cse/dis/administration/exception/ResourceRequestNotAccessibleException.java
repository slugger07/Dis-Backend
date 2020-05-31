package sgsits.cse.dis.administration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceRequestNotAccessibleException extends RuntimeException {

	public ResourceRequestNotAccessibleException(String message) {
		super(message);
	}
	
}
