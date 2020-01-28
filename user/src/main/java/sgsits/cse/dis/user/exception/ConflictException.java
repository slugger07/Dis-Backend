package sgsits.cse.dis.user.exception;

public class ConflictException extends Exception{
	
		private static final long serialVersionUID = 1L;
		
		private String message;
		
		public ConflictException() {
			super();
		}

		public ConflictException(String message) {
			super();
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

			
	}
