package sgsits.cse.dis.administration.response;
/**
 * <h1>AddBookRsponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class AddBookResponse {
	private String message;
	private String bookId;
	
	public AddBookResponse(String message, String bookId) {
		super();
		this.message = message;
		this.bookId = bookId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}
