package sgsits.cse.dis.academics.response;
/**
 * <h1>ResponseMessage</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class ResponseMessage {
	private String message;

	public ResponseMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
