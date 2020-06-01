package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>LibrarySettings</b> class.</h1>
 * <p>This class is model for table <b>library_settings</b> to act as DAO.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 */
@Entity
@Table(name = "library_settings")
public class LibrarySettings {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name="UUID",
			strategy="org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "id", nullable = false, unique = true)
	private String id;
	
	@Column(name = "return_deadline_days", nullable = false)
	private long returnDeadlineDays;
	
	@Column(name = "no_of_books_allowed", nullable = false)
	private long noOfBooksAllowed;
	
	@Column(name = "penalty_per_day", nullable = false)
	private long penaltyPerDay;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getReturnDeadlineDays() {
		return returnDeadlineDays;
	}

	public void setReturnDeadlineDays(long returnDeadlineDays) {
		this.returnDeadlineDays = returnDeadlineDays;
	}

	public long getNoOfBooksAllowed() {
		return noOfBooksAllowed;
	}

	public void setNoOfBooksAllowed(long noOfBooksAllowed) {
		this.noOfBooksAllowed = noOfBooksAllowed;
	}

	public long getPenaltyPerDay() {
		return penaltyPerDay;
	}

	public void setPenaltyPerDay(long penaltyPerDay) {
		this.penaltyPerDay = penaltyPerDay;
	}

	
}
