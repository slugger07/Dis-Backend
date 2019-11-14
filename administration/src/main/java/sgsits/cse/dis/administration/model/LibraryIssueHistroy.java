package sgsits.cse.dis.administration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_issue_history")
public class LibraryIssueHistroy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private long penalty;
	
	@Column(name = "book_id")
	private long bookId;
	
	@Column(name = "thesis_id")
	private long thesisId;

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

	public long getPenalty() {
		return penalty;
	}

	public void setPenalty(long penalty) {
		this.penalty = penalty;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getThesisId() {
		return thesisId;
	}

	public void setThesisId(long thesisId) {
		this.thesisId = thesisId;
	}
	
	
	
}
