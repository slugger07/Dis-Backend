package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>USerTasks</b> class.</h1>
 * <p>This class is model for table <b>user_tasks</b> to act as DAO.
 * This table contains mapping between userId and taskId to store which user is assigned which tasks.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 4-JAN-2020.
 */
@Entity
@Table(name = "user_tasks")
public class UserTasks {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    
    @Column(name = "created_date", nullable = false)
    private String createdDate;
    
    @Column(name = "modified_by")
    private String modifiedBy;
    
    @Column(name = "modified_date")
    private String modifiedDate;
    
    @Column(name = "user_id", nullable = false)
    private String userId;
    
    @Column(name = "task_id", nullable = false)
    private String taskId;
    
    @Column(name = "deadline")
    private String deadline;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "status")
    private String status;

//	public UserTasks(String id, String createdBy, String createdDate, String modifiedBy, String modifiedDate,
//			String userId, String taskId, String deadline, String description, String status) {
//		super();
//		this.id = id;
//		this.createdBy = createdBy;
//		this.createdDate = createdDate;
//		this.modifiedBy = modifiedBy;
//		this.modifiedDate = modifiedDate;
//		this.userId = userId;
//		this.taskId = taskId;
//		this.deadline = deadline;
//		this.description = description;
//		this.status = status;
//	}
	
	public UserTasks( String createdBy, String createdDate, String modifiedBy, String modifiedDate,
			String userId, String taskId, String deadline, String description, String status) {
		super();
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.userId = userId;
		this.taskId = taskId;
		this.deadline = deadline;
		this.description = description;
		this.status = status;
	}
	

	public UserTasks() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
