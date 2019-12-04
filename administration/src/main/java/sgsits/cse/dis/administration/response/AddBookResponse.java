package sgsits.cse.dis.administration.response;

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
