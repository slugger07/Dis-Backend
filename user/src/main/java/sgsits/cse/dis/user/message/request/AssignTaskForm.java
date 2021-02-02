package sgsits.cse.dis.user.message.request;
/**
 * <h1>AssignTask</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
public class AssignTaskForm {
	public String userId;
	public String taskId;
	public String deadline;
	public String description;
	public String status;
	

	public String getUserId() {
		return userId;
	}
	public String getTaskId() {
		return taskId;
	}
	public String getDeadline() {
		return deadline;
	}
	public String getDescription() {
		return description;
	}
	public String getStatus() {
		return status;
	}
  
	
	
	

}
