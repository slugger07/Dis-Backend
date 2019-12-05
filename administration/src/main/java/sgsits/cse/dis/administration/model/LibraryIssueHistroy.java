package sgsits.cse.dis.administration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "library_issue_history")
public class LibraryIssueHistroy {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name="UUID",
			strategy="org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "issue_id", nullable = false, unique = true)
	private long issueId;
	
	@Column(name = "user_id", nullable = false)
	private long userId;
	
	@Column(name = "issue_date", nullable = false)
	private String issueDate;
	
	@Column(name = "expected_return_date", nullable = false)
	private String expectedReturnDate;
	
	@Column(name = "actual_return_date")
	private String actualReturnDate;
	
	@Column(name = "penalty")
	private Long penalty;
	
	@Column(name = "book_id")
	private Long bookId;
	
	@Column(name = "thesis_id")
	private Long thesisId;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getThesisId() {
		return thesisId;
	}

	public void setThesisId(Long thesisId) {
		this.thesisId = thesisId;
	}


	
	
}
