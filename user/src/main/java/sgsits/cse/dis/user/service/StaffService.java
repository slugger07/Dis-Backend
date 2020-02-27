package sgsits.cse.dis.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
/**
 * <h1><b>StaffService</b> interface.</h1>
 * <p>This interface lists all the staff services which can be implemented by class extending it. 
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
public interface StaffService {
	
	List<FacultyData> getFacultyData();
	List<FacultyData> getStaffData();
	String addNewMember(AddNewUser addNewUser,String addedBy) throws ConflictException,DataIntegrityViolationException;
	List<FacultyData> getStaffWithName(String name);
	void updateUserIdByEmail(String userId,String email);
	String getNameById(String userId);
	String getNameByIdOptional(Optional<String> userId);
}
