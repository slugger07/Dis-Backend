package sgsits.cse.dis.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;

import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.dtos.StaffBasicProfileDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;


public interface StaffService {
	
	List<FacultyDataDto> getFacultyData();

	List<FacultyDataDto> getStaffData();

	StaffBasicProfileDto getStaffBasicProfile(final String userId) throws InternalServerError;

	void addOrUpdateStaffBasicProfile(final StaffBasicProfileDto StaffBasicProfileDto) throws InternalServerError;

	String addNewMember(AddNewUser addNewUser,String addedBy) throws ConflictException,DataIntegrityViolationException;

	List<FacultyDataDto> getStaffWithName(String name);

	void updateUserIdByEmail(String userId,String email);

	String getNameByIdOptional(Optional<String> userId);
	
	public String getNameById(String userId);
	
	List<Object[]> getAllEmployeeNamesAndUserId();

	List<Object[]> getAllUsernameAndEmail();
}
