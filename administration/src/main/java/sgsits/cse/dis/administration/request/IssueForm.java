package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;

public class IssueForm {
	
	@NotBlank(message = "username cannot be empty.")
	private String username;
	
	private String bookId;
	
	private Long thesisId;
	
	public IssueForm() {
		super();
	}

	public IssueForm(@NotBlank(message = "username cannot be empty.") String username, String bookId, Long thesisId) {
		super();
		this.username = username;
		this.bookId = bookId;
		this.thesisId = thesisId;
	}

	public String getUsername() {
		return username;
	}

	public String getBookId() {
		return bookId;
	}

	public Long getThesisId() {
		return thesisId;
	}
		
}
