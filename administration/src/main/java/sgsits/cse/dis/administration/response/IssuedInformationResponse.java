package sgsits.cse.dis.administration.response;
/**
 * <h1>IssuedInformationResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class IssuedInformationResponse {
	
	private String username;

	private long penalty;

	public IssuedInformationResponse(String username, long penalty) {
		super();
		this.username = username;
		this.penalty = penalty;
	}

	public IssuedInformationResponse() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getPenalty() {
		return penalty;
	}

	public void setPenalty(long penalty) {
		this.penalty = penalty;
	}
	
}
