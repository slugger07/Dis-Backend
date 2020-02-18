package sgsits.cse.dis.administration.response;
/**
 * <h1>AddThesisResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class AddThesisResponse {
	private String message;
	private Long thesisId;
	
	public AddThesisResponse(String message, Long thesisId) {
		super();
		this.message = message;
		this.thesisId = thesisId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getThesisId() {
		return thesisId;
	}
	public void setThesisId(Long thesisId) {
		this.thesisId = thesisId;
	}

}
