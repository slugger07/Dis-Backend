package sgsits.cse.dis.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Date modifiedDate;
	
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
    private Date resetTokenExpiry;
    
	@Column(name = "user_type")
	private String userType;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
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

	public Date getResetTokenExpiry() {
		return resetTokenExpiry;
	}

	public void setResetTokenExpiry(Date resetTokenExpiry) {
		this.resetTokenExpiry = resetTokenExpiry;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}