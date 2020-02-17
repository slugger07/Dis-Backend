package sgsits.cse.dis.administration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>LibraryCurrentIssues</b> class.</h1>
 * <p>This class is model for table <b>library_current_issues</b> to act as DAO.
 * This table contains  currently issued book/thesis data.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@Entity
@Table(name = "library_current_issues")
public class LibraryCurrentIssues {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name="UUID",
			strategy="org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "issue_id", nullable = false, unique = true)
	private String issueId;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "issue_date", nullable = false)
	private String issueDate;
	
	@Column(name = "expected_return_date", nullable = false)
	private String expectedReturnDate;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "book_id",  unique = true)
	private String bookId = null;
	
	@Column(name = "thesis_id", unique = true)
	private Long thesisId = null;

	public LibraryCurrentIssues() {
		super();
	}

	public LibraryCurrentIssues(String username, String issueDate, String expectedReturnDate,
			String title, String bookId, Long thesisId) {
		super();
		this.username = username;
		this.issueDate = issueDate;
		this.expectedReturnDate = expectedReturnDate;
		this.title = title;
		this.bookId = bookId;
		this.thesisId = thesisId;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpectedReturnDate() {
		return expectedReturnDate;
	}

	public void setExpectedReturnDate(String expectedReturnDate) {
		this.expectedReturnDate = expectedReturnDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Long getThesisId() {
		return thesisId;
	}

	public void setThesisId(Long thesisId) {
		this.thesisId = thesisId;
	}
	
	
}
