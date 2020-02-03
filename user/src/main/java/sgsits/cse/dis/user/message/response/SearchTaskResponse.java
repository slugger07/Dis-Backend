package sgsits.cse.dis.user.message.response;


public class SearchTaskResponse {
	private String userId;
	private String userName;
	private String taskId;
	private String taskName;
	private String deadline;
	private String description;
	private String status;
	private String createdDate;
		
	public SearchTaskResponse() {
		super();
	}

	public SearchTaskResponse(String userId, String userName, String taskId, String taskName, String deadline,
			String description, String status,String createdDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.taskId = taskId;
		this.taskName = taskName;
		this.deadline = deadline;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
		if(deadline.equals("null"))
			this.deadline=null;
		if(description.equals("null"))
			this.description=null;
		if(status.equals("null"))
			this.status=null;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
		
}
