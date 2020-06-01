package sgsits.cse.dis.administration.response;

import org.springframework.http.HttpStatus;
/**
 * <h1>ExceptionResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class ExceptionResponseJSON {

		private String url;
		private String message;
		private HttpStatus error;
		private int code;


		public ExceptionResponseJSON(String url, String message, HttpStatus error,HttpStatus code) {
			super();
			this.url = url;
			this.message = message;
			this.error = error;
			this.code = code.value();
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public HttpStatus getError() {
			return error;
		}

		public void setError(HttpStatus error) {
			this.error = error;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
		
		
}
