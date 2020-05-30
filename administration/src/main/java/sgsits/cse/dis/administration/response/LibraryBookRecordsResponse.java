package sgsits.cse.dis.administration.response;
/**
 * <h1>LibraryBookRecordsResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class LibraryBookRecordsResponse {

	private String authorName;
	
	private String edition;
	
	private String title;
	
	private String status;
	
	private String subjectCategory;

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
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

	public String getSubjectCategory() {
		return subjectCategory;
	}

	public void setSubjectCategory(String subjectCategory) {
		this.subjectCategory = subjectCategory;
	}

	
	
}
