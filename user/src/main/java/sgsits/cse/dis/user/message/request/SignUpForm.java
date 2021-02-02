package sgsits.cse.dis.user.message.request;

import java.util.Date;

import javax.validation.constraints.*;
/**
 * <h1>SignUpFormk</h1>class.
 * This class is pojo form for converting json and mapping into this java object
 * @author Devyani garg
 * @since 8-DEC-2018
 */
public class SignUpForm {

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email
    private String email;
    
    @NotNull
    private Date dob;
    
    @NotNull
    @Digits(integer = 10, fraction = 0)
    private long mobileNo;
      
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

	public Date getDob() {
		return dob;
	}

	public long getMobileNo() {
		return mobileNo;
	}
}