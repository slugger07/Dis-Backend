package sgsits.cse.dis.user.dto;

public class MarkAllAsReadDto {
	
	 private String username;

	public MarkAllAsReadDto(String username) {
		this.username = username;
	}

	public MarkAllAsReadDto() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
