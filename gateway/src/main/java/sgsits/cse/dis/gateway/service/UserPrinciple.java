package sgsits.cse.dis.gateway.service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sgsits.cse.dis.gateway.model.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String id;

    private String username;

    private String email;
    
    private Date dob;
    
    private long mobileNo;

    private String userType;
    
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(String id, String username, String email, Date dob, long mobileNo, String userType, String password, 
			    		Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.userType = userType;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getTasks().stream().map(task ->
                new SimpleGrantedAuthority(task.getName())
        ).collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority(user.getUserType()));
        return new UserPrinciple(
                user.getId(),              
                user.getUsername(),
                user.getEmail(),
                user.getDob(),
                user.getMobileNo(),
                user.getUserType(),
                user.getPassword(),
                authorities
        );
    }

    public String getId() {
        return id.toString();
    }

    public String getEmail() {
        return email;
    }
    
    public Date getDob() {
		return dob;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public String getUserType() {
		return userType;
	}

	@Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}