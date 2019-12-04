package sgsits.cse.dis.administration.response;

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
