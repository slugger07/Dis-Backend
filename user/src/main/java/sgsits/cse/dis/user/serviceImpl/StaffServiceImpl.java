package sgsits.cse.dis.user.serviceImpl;

import org.mapstruct.factory.Mappers;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.dtos.FacultyDataDto;
import sgsits.cse.dis.user.dtos.StaffBasicProfileDto;
import sgsits.cse.dis.user.exception.ConflictException;
import sgsits.cse.dis.user.exception.InternalServerError;
import sgsits.cse.dis.user.mappers.StaffServiceMapper;
import sgsits.cse.dis.user.message.request.AddNewUser;
import sgsits.cse.dis.user.model.StaffBasicProfile;
import sgsits.cse.dis.user.repo.StaffBasicProfileRepository;
import sgsits.cse.dis.user.service.StaffService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Component
public class StaffServiceImpl implements StaffService {

    private final StaffBasicProfileRepository staffBasicProfileRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    private final StaffServiceMapper staffServiceMapper = Mappers.getMapper(StaffServiceMapper.class);

    public StaffServiceImpl(StaffBasicProfileRepository staffRepo) {
        this.staffBasicProfileRepository = staffRepo;
    }
    
	@Override
	public String getNameById(String userId) {
		if (userId.equals(null)) {
			return "userId is null";
		}
		Optional<StaffBasicProfile> temp = staffBasicProfileRepository.findByUserId(userId);
		if(temp.isPresent())
			return temp.get().getName();
		return "Not Found";
	}

    @Override
    public List<FacultyDataDto> getFacultyData() {

        List<StaffBasicProfile> staffBasicProfiles =
                staffBasicProfileRepository.findByClasssOrClasssOrderByCurrentDesignation("I", "II");

        return staffServiceMapper.convertStaffBasicProfileListIntoFacultyDataDtoList(staffBasicProfiles);
    }

    @Override
    public List<FacultyDataDto> getStaffData() {

        List<StaffBasicProfile> staffBasicProfiles =
                staffBasicProfileRepository.findByClasssOrClasssOrderByCurrentDesignation("III", "IV");

        return staffServiceMapper.convertStaffBasicProfileListIntoFacultyDataDtoList(staffBasicProfiles);
    }

    @Override
    public String addNewMember(final AddNewUser addNewUser, final String addedBy) throws
            ConflictException, DataIntegrityViolationException {

        try {
            StaffBasicProfile test = staffBasicProfileRepository.save(new StaffBasicProfile(addedBy, simpleDateFormat.format(new Date()), addNewUser.getEmployeeId(),
                    addNewUser.getName(), addNewUser.getCurrentDesignation(), addNewUser.getClasss(),
                    addNewUser.getType(), addNewUser.getEmail(), addNewUser.getDob(), addNewUser.getMobileNo(),
                    addNewUser.getJoiningDate()));
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Employee already Exists.");
        }
        return "Member added successfully";
    }

    @Override
    public List<FacultyDataDto> getStaffWithName(final String name) {

        List<StaffBasicProfile> staffBasicProfiles =
                staffBasicProfileRepository.findByNameContainingIgnoreCase(name);

        return staffServiceMapper.convertStaffBasicProfileListIntoFacultyDataDtoList(staffBasicProfiles);
    }

    @Override
    public void updateUserIdByEmail(String userId, String email) {
        staffBasicProfileRepository.updateUserIdByEmailId(userId, email);

    }

    @Override
    public List<Object[]> getAllEmployeeNamesAndUserId() {
        return staffBasicProfileRepository.findAllUserIdAndUsername();
    }

    @Override
    public List<Object[]> getAllUsernameAndEmail() {
        return null;
    }
    
    @Override
	public String getNameByIdOptional(Optional<String> userId) {
		System.out.println("Inside getNameByIdOptional : "+userId.get());	
		if (!userId.get().equals("null")) {
			Optional<StaffBasicProfile> temp = staffBasicProfileRepository.findById(userId.get().replace("\"", ""));
			if(temp.isPresent())
				return temp.get().getName();
			return "Not Found";
			
		}
		return "userId is null";
	}

    @Override
    public StaffBasicProfileDto getStaffBasicProfile(String userId) throws InternalServerError {

        final Optional<StaffBasicProfile> optionalStaffBasicProfile =
                staffBasicProfileRepository.findByUserId(userId);

        if (optionalStaffBasicProfile.isPresent()) {

            return staffServiceMapper.convertStaffBasicProfileIntoStaffBasicProfileDto(
                    optionalStaffBasicProfile.get());
        } else {
            throw new InternalServerError("couldn't retrieve staff basic profile");
        }
    }

    @Override
    public void addOrUpdateStaffBasicProfile(final StaffBasicProfileDto StaffBasicProfileDto)
            throws InternalServerError {

        try {
            staffBasicProfileRepository.save(staffServiceMapper
                    .convertStaffBasicProfileDtoIntoStaffBasicProfile(StaffBasicProfileDto));
        } catch (Exception e) {
            throw new InternalServerError("Cannot update staff basic profile");
        }

    }
}
