package sgsits.cse.dis.administration.request;

import javax.validation.constraints.NotBlank;
/**
 * <h1>AddBookForm</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra
 * @since 2-DEC-2020
 */
public class AddBookForm {
	
	private String isbn;
	
	@NotBlank(message = "Subject Category cannot be empty.")
	private String subjectCategory;
	
	private String authorName;
	
	private String yearOfPublication;
	
	private String edition;
	
	private String publisherAndPlace;
	
	private long noOfPages;
	
	private long price;
	
	private String purchaseDate;
	
	@NotBlank(message = "Title cannot be empty.")
	private String title;

	private String remarks;

	public String getIsbn() {
		return isbn;
	}

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public String getEdition() {
		return edition;
	}

	public String getPublisherAndPlace() {
		return publisherAndPlace;
	}

	public long getNoOfPages() {
		return noOfPages;
	}

	public long getPrice() {
		return price;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public String getTitle() {
		return title;
	}

	public String getRemarks() {
		return remarks;
	}
	
	

}
