package sgsits.cse.dis.administration.exception;

public class EventDoesNotExistException extends Exception {

		private static final long serialVersionUID = 1L;
	
		private String message;
		
		public EventDoesNotExistException() {
			super();
		}

		public EventDoesNotExistException(String message) {
			this.message=message;
		}

		public String getMessage() {
			return message;
		}
		
}
