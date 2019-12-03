package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_book_count")
public class LibraryBookCount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;
	
	@Column(name = "subject_category", nullable = false)
	private String subjectCategory;
	
	@Column(name = "count",nullable = false)
	private Long count=1l;
	
	public LibraryBookCount() {
		super();
	}

	public LibraryBookCount(String subjectCategory) {
		super();
		this.subjectCategory = subjectCategory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
}
