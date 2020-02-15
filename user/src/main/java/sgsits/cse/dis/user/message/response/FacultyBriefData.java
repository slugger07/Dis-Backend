package sgsits.cse.dis.user.message.response;
/**
 * <h1>FacultyBriefData</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class FacultyBriefData {
	
	private String name;
	private String nameAcronym;
	private String profilePicture;
	private String currentDesignation;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameAcronym() {
		return nameAcronym;
	}
	public void setNameAcronym(String nameAcronym) {
		this.nameAcronym = nameAcronym;
	}
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getCurrentDesignation() {
		return currentDesignation;
	}
	public void setCurrentDesignation(String currentDesignation) {
		this.currentDesignation = currentDesignation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
