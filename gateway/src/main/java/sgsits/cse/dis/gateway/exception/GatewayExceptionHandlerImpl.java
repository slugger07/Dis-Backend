package sgsits.cse.dis.gateway.exception;


import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sun.mail.util.MailConnectException;

import sgsits.cse.dis.gateway.message.response.ResponseMessage;

@RestControllerAdvice
public class GatewayExceptionHandlerImpl {

	@ExceptionHandler({MailConnectException.class,UnknownHostException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> eventDoesNotExistException() {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Cannot connect to stmp server"), HttpStatus.BAD_REQUEST);
	}

	
}

