package sgsits.cse.dis.user.service;

import javassist.NotFoundException;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
/**
 * <h1><b>UserService</b> interface.</h1>
 * <p>This interface lists all the user services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */
public interface UserServices {
	boolean existsByUsername(String userName) throws NotFoundException;
	boolean findUser(SignUpForm signup);
	String findUserType(SignUpForm signup);
	boolean updateEmailAndUserId(@RequestParam("mobileNo") long mobileNo);
	List<ActiveStaffListResponse> getActiveStaffList() throws NotFoundException;
}
