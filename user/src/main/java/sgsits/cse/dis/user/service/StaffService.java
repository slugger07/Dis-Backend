package sgsits.cse.dis.user.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;


public interface StaffService {
	
	List<FacultyData> getFacultyData();
	List<FacultyData> getStaffData();
	String addNewMember(AddNewUser addNewUser,String addedBy) throws ConflictException,DataIntegrityViolationException;
	List<FacultyData> getStaffWithName(String name);
	void updateUserIdByEmail(String userId,String email);
	List<Object[]> getAllEmployeeNamesAndUserId();
}
