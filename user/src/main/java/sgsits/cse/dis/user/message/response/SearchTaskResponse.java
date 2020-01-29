package sgsits.cse.dis.user.message.response;


public class SearchTaskResponse {
	public String userId;
	public String userName;
	public String taskId;
	public String taskName;
	public String deadline;
	public String description;
	public String status;
		
	public SearchTaskResponse() {
		super();
	}

	public SearchTaskResponse(String userId, String userName, String taskId, String taskName, String deadline,
			String description, String status) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.taskId = taskId;
		this.taskName = taskName;
		this.deadline = deadline;
		this.description = description;
		this.status = status;
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

		
}
