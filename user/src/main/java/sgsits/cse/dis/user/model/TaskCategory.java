package sgsits.cse.dis.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * <h1><b>TaskCategory</b> class.</h1>
 * <p>This class is model for table <b>task_category</b> to act as DAO.
 * this table contains list of categories in which tasks are divided.
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 4-JAN-2020.
 */
@Entity
@Table(name = "task_category")
public class TaskCategory {

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
    
    @Column(name = "category_name", nullable = false)
    private String categoryName;

	public TaskCategory(String id, String createdBy, String createdDate, String modifiedBy, String modifiedDate,
			String categoryName) {
		super();
		this.id = id;
		this.createdBy = createdBy;
		
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.categoryName = categoryName;
	}

	public TaskCategory() {
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
		return categoryName;
	}

	public void setUserId(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    
    
    
}
