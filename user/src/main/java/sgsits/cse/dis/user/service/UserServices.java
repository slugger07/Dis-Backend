package sgsits.cse.dis.user.service;

import javassist.NotFoundException;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;

public interface UserServices {
	boolean existsByUsername(String userName) throws NotFoundException;
	boolean findUser(SignUpForm signup);
	String findUserType(SignUpForm signup);
	boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo);
	List<ActiveStaffListResponse> getActiveStaffList();
}
