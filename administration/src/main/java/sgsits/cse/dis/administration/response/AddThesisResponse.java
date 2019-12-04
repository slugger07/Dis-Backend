package sgsits.cse.dis.administration.response;

public class AddThesisResponse {
	private String message;
	private String thesisId;
	
	public AddThesisResponse(String message, String thesisId) {
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
	public String getThesisId() {
		return thesisId;
	}
	public void setThesisId(String thesisId) {
		this.thesisId = thesisId;
	}

}
