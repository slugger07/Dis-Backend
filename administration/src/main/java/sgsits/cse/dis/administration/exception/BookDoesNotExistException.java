package sgsits.cse.dis.administration.exception;

public class BookDoesNotExistException extends Exception {

		private static final long serialVersionUID = 1L;
	
		private String message;
		
		public BookDoesNotExistException() {
		}
		
		public BookDoesNotExistException(String message) {
			this.message=message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
		
}
