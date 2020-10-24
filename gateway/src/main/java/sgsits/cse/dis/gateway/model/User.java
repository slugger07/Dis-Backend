package sgsits.cse.dis.gateway.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "user", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"username"
		}),
		@UniqueConstraint(columnNames = {
				"email"
		}),
		@UniqueConstraint(columnNames = {
				"mobile_no"
		})
})
public class User{
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

	@NotBlank
	@Size(min=3, max = 50)
	@Column(name = "username")
	private String username;

	@NaturalId
	@NotBlank
	@Size(max = 50)
	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "mobile_no")
	private long mobileNo;

	@NotBlank
	@Size(min=6, max = 100)
	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "reset_token")
	private String resetToken;

	@Column(name = "reset_token_expiry")
	private String resetTokenExpiry;

	@Column(name = "activation_token")
	private String activationToken;

	@Column(name = "activation_token_expiry")
	private String activationTokenExpiry;

	@Column(name = "last_login")
	private String lastLogin;

	@Column(name = "user_type")
	private String userType;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_tasks",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "task_id"))
	private Set<Task> tasks = new HashSet<>();

	public User() {}

	public User(String username, String email, Date dob, long mobileNo, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.mobileNo = mobileNo;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public String getResetTokenExpiry() {
		return resetTokenExpiry;
	}

	public void setResetTokenExpiry(String resetTokenExpiry) {
		this.resetTokenExpiry = resetTokenExpiry;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public String getActivationToken() {
		return activationToken;
	}

	public void setActivationToken(String activationToken) {
		this.activationToken = activationToken;
	}

	public String getActivationTokenExpiry() {
		return activationTokenExpiry;
	}

	public void setActivationTokenExpiry(String activationTokenExpiry) {
		this.activationTokenExpiry = activationTokenExpiry;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
}