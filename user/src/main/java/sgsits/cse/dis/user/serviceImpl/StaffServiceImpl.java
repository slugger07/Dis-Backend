package sgsits.cse.dis.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.model.StaffProfile;
import sgsits.cse.dis.user.repo.StaffRepository;
import sgsits.cse.dis.user.service.StaffService;
/**
 * <h1><b>StaffServiceimpl</b> class.</h1>
 * <p>This class contains implementation of all the library services which are defined in the <b>StaffService</b> interface.
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

@Component
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@Override
	public List<FacultyData> getFacultyData() {
		List<StaffProfile> staffProfiles = staffRepository.findByClasssOrClasssOrderByCurrentDesignation("I", "II");
		List<FacultyData> facultyData = new ArrayList<FacultyData>();
		for (StaffProfile faculty : staffProfiles) {
			facultyData.add(new FacultyData(faculty.getUserId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return facultyData;
	}

	@Override
	public List<FacultyData> getStaffData() {
		List<StaffProfile> staffProfiles = staffRepository.findByClasssOrClasssOrderByCurrentDesignation("III", "IV");
		List<FacultyData> staffData = new ArrayList<FacultyData>();
		for (StaffProfile faculty : staffProfiles) {
			staffData.add(new FacultyData(faculty.getUserId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return staffData;
	}

	@Override
	public String addNewMember(AddNewUser addNewUser,String addedBy) throws ConflictException,DataIntegrityViolationException{
		try{StaffProfile test = staffRepository.save(new StaffProfile(addedBy, simpleDateFormat.format(new Date()),addNewUser.getEmployeeId(),
				addNewUser.getName(), addNewUser.getCurrentDesignation(), addNewUser.getClasss(), 
				addNewUser.getType(), addNewUser.getEmail(), addNewUser.getDob(), addNewUser.getMobileNo(),
				addNewUser.getJoiningDate()));
				if(test.equals(null))
						throw new ConflictException("Unable to add member.");
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Eployee already Exists.");
		}
		return "Member added successfully";
	}

	@Override
	public List<FacultyData> getStaffWithName(String name) {
		List<StaffProfile> staffProfiles = staffRepository.findByNameContainingIgnoreCase(name);
		List<FacultyData> facultyData = new ArrayList<FacultyData>();
		for (StaffProfile faculty : staffProfiles) {
			facultyData.add(new FacultyData(faculty.getUserId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return facultyData;
	}

	@Override
	public void updateUserIdByEmail(String userId, String email) {
		staffRepository.updateUserIdByEmailId(userId,email);
		
	}

	@Override
	public String getNameById(String userId) {
		if (userId.equals(null)) {
			return "userId is null";
		}
		Optional<StaffProfile> temp = staffRepository.findByUserId(userId);
		if(temp.isPresent())
			return temp.get().getName();
		return "Not Found";
	}
	
	@Override
	public String getNameByIdOptional(Optional<String> userId) {
		System.out.println("Inside getNameByIdOptional : "+userId.get());	
		if (!userId.get().equals("null")) {
			Optional<StaffProfile> temp = staffRepository.findByUserId(userId.get().replace("\"", ""));
			if(temp.isPresent())
				return temp.get().getName();
			return "Not Found";
			
		}
		return "userId is null";
	}
}
