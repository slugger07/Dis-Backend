package sgsits.cse.dis.user.message.response;
/**
 * <h1>SearchTaskResponse</h1>class.
 * This class is pojo form for return java object as a response to request over network.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class SearchTaskResponse {
	private String id;
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

	public SearchTaskResponse(String id,String userId, String userName, String taskId, String taskName, String deadline,
			String description, String status,String createdDate) {
		super();
		this.id=id;
		this.userId = userId;
		this.userName = userName;
		this.taskId = taskId;
		this.taskName = taskName;
		this.deadline = deadline;
		this.description = description;
		this.status = status;
		this.createdDate = createdDate;
	}

	
	public SearchTaskResponse(String id,String userId, String userName, String taskId, String taskName, Object deadline,
			Object description, Object status,String createdDate) {
		super();
		this.id=id;
		this.userId = userId;
		this.userName = userName;
		this.taskId = taskId;
		this.taskName = taskName;
		this.createdDate = createdDate;
		if(String.valueOf(deadline).equals("null"))
			this.deadline=null;
		else
			this.deadline = String.valueOf(deadline);
		
		if(String.valueOf(description).equals("null"))
			this.description=null;
		else
			this.description = String.valueOf(description);
			
		if(String.valueOf(status).equals("null"))
			this.status=null;
		else
			this.status = String.valueOf(status);
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
