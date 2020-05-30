package sgsits.cse.dis.infrastructure.exception;
/**
 * <h1>ConflictException</h1> class.
 * This class is exception class for the conflicting entries in the database.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
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
