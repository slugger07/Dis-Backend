package sgsits.cse.dis.infrastructure.response;

public class InfrastructureInchargeResponse {
	private String id;
	private String location;
	private String previousIncharge;
	private String previousInchargeId;
	public String getPreviousInchargeId() {
		return previousInchargeId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPreviousInchargeId(String previousInchargeId) {
		this.previousInchargeId = previousInchargeId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPreviousIncharge() {
		return previousIncharge;
	}
	public void setPreviousIncharge(String previousIncharge) {
		this.previousIncharge = previousIncharge;
	}

}
