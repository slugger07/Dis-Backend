package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>Task</b> class.</h1>
 * <p>This class is model for table <b>task</b> to act as DAO.
 * Task table contains list of all the task that can be assigned to anyone.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 4-JAN-2020.
 */
@Entity
@Table(name = "task")
public class Task {
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
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "category", nullable = false)
    private String category;

	public Task(String id, String createdBy, String createdDate, String modifiedBy, String modifiedDate, String name,
			String category) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.name = name;
		this.category = category;
	}

	public Task() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    

}
