package sgsits.cse.dis.administration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>LibraryIssuehistory</b> class.</h1>
 * <p>This class is model for table <b>library_issue_history</b> to act as DAO.
 * This table conatins issue history of library books and htesis.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@Entity
@Table(name = "library_issue_history")
public class LibraryIssueHistory {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name="UUID",
			strategy="org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "id", nullable = false, unique = true)
	private String id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "issue_date", nullable = false)
	private String issueDate;
	
	@Column(name = "expected_return_date", nullable = false)
	private String expectedReturnDate;
	
	@Column(name = "actual_return_date", nullable = false)
	private String actualReturnDate;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "book_id")
	private String bookId;
	
	@Column(name = "thesis_id")
	private Long thesisId;
	
	@Column(name = "penalty")
	private Long penalty;

	public LibraryIssueHistory() {
		super();
	}

	public LibraryIssueHistory(String userName, String issueDate, String expectedReturnDate,
			String actualReturnDate, String title, String bookId, Long thesisId, Long penalty) {
		super();
		this.username = userName;
		this.issueDate = issueDate;
		this.expectedReturnDate = expectedReturnDate;
		this.actualReturnDate = actualReturnDate;
		this.title = title;
		this.bookId = bookId;
		this.thesisId = thesisId;
		this.penalty = penalty;
	}

	public String getIssueId() {
		return id;
	}

	public void setIssueId(String issueId) {
		this.id = issueId;
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

	public String getActualReturnDate() {
		return actualReturnDate;
	}

	public void setActualReturnDate(String actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}

	public Long getPenalty() {
		return penalty;
	}

	public void setPenalty(Long penalty) {
		this.penalty = penalty;
	}
	
	
	
}
