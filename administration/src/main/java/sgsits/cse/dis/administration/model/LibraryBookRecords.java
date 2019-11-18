package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library_Book_records")

public class LibraryBookRecords {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false, unique = true)
	private long bookId;
	
	@Column(name = "ISBN_no")
	private String isbn;
	
	@Column(name = "subject_category", nullable = false)
	private String subjectCategory;
	
	@Column(name = "author_name")
	private String authorName;
	
	@Column(name = "year_of_publication")
	private String yearOfPublication;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "publisher_and_place")
	private String publisherAndPlace;
	
	@Column(name = "no_of_pages")
	private long noOfPages;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "purchase_date")
	private String purchaseDate;
	
	@Column(name = "entry_date", nullable = false)
	private String entryDate;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "status")
	private String status="Availabe";
	
	@Column(name = "remarks")
	private String remarks;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getPublisherAndPlace() {
		return publisherAndPlace;
	}

	public void setPublisherAndPlace(String publisherAndPlace) {
		this.publisherAndPlace = publisherAndPlace;
	}

	public long getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(long noOfPages) {
		this.noOfPages = noOfPages;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
}
