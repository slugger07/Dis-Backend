package sgsits.cse.dis.gateway.exception;


import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sun.mail.util.MailConnectException;

import javassist.NotFoundException;
import sgsits.cse.dis.gateway.message.response.ResponseMessage;


@RestControllerAdvice
public class GatewayExceptionHandlerImpl {

	@ExceptionHandler({MailConnectException.class,UnknownHostException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> mailConnectException() {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Cannot connect to smtp server"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({AuthenticationException.class})
	@ResponseBody
	
	public ResponseEntity<ResponseMessage> atuthenticationException() {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Wrong username or password OR user doesn't exist"), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({NotFoundException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> eventNotFoundException(NotFoundException e) {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(e.getMessage()), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({HttpMessageNotReadableException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> formatException() {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("please enter data in proper format"), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseBody
	public ResponseEntity<ResponseMessage> notValiException() {
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("please fill entire form properly"), HttpStatus.BAD_REQUEST);
	}

	
}

