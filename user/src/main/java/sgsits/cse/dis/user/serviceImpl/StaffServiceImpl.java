package sgsits.cse.dis.user.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.service.StaffService;


@Component
public class StaffServiceImpl implements StaffService {

	private final StaffBasicProfileRepository staffBasicProfileRepository;
	
	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public StaffServiceImpl(StaffBasicProfileRepository staffRepo) {
		this.staffBasicProfileRepository = staffRepo;
	}

	@Override
	public List<FacultyData> getFacultyData() {
		List<StaffBasicProfile> staffBasicProfiles =
				staffBasicProfileRepository.findByClasssOrClasssOrderByCurrentDesignation("I", "II");
		List<FacultyData> facultyData = new ArrayList<>();
		for (StaffBasicProfile faculty : staffBasicProfiles) {
			facultyData.add(new FacultyData(faculty.getId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return facultyData;
	}

	@Override
	public List<FacultyData> getStaffData() {
		List<StaffBasicProfile> staffBasicProfiles =
				staffBasicProfileRepository.findByClasssOrClasssOrderByCurrentDesignation("III", "IV");
		List<FacultyData> staffData = new ArrayList<>();
		for (StaffBasicProfile faculty : staffBasicProfiles) {
			staffData.add(new FacultyData(faculty.getId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return staffData;
	}

	@Override
	public String addNewMember(AddNewUser addNewUser,String addedBy) throws ConflictException,DataIntegrityViolationException{
		try{
			StaffBasicProfile test = staffBasicProfileRepository.save(new StaffBasicProfile(addedBy, simpleDateFormat.format(new Date()),addNewUser.getEmployeeId(),
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
		List<StaffBasicProfile> staffBasicProfiles = staffBasicProfileRepository.findByNameContainingIgnoreCase(name);
		List<FacultyData> facultyData = new ArrayList<>();
		for (StaffBasicProfile faculty : staffBasicProfiles) {
			facultyData.add(new FacultyData(faculty.getId(), faculty.getName(), faculty.getNameAcronym(),
					null, faculty.getCurrentDesignation(), faculty.getEmail(), faculty.getMobileNo(), faculty.getAlternateMobileNo()));
		}
		return facultyData;
	}

	@Override
	public void updateUserIdByEmail(String userId, String email) {
		staffBasicProfileRepository.updateUserIdByEmailId(userId,email);
		
	}

	@Override
	public List<Object[]> getAllEmployeeNamesAndUserId() {
		return staffBasicProfileRepository.findAllUserIdAndUsername();
	}

	@Override
	public List<Object[]> getAllUsernameAndEmail() {
		return staffBasicProfileRepository.findAllUserIdAndEmails();
	}
}
