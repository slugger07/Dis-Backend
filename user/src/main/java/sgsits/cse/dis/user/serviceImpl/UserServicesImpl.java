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

import javassist.NotFoundException;
import sgsits.cse.dis.user.message.request.SignUpForm;
import sgsits.cse.dis.user.message.response.ActiveStaffListResponse;
import sgsits.cse.dis.user.model.StaffProfile;
import sgsits.cse.dis.user.model.StudentProfile;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.StaffRepository;
import sgsits.cse.dis.user.repo.StudentRepository;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.UserServices;
/**
 * <h1><b>UserServicesImpl</b> class.</h1>
 * <p>This class contains implementation of all the library services which are defined in the <b>UserServices</b> interface.
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
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean existsByUsername(String username) throws NotFoundException {
			if(userRepository.existsByUsername(username))
				return true;
			else
				return false;
	}

	@Override
	public boolean findUser(SignUpForm signup)
	{
		boolean exist = false;
		exist = staffRepository.existsByEmailAndMobileNoAndDob(signup.getEmail(),signup.getMobileNo(),signup.getDob());
		if(exist == false)
		{
			exist = studentRepository.existsByEnrollmentIdAndMobileNoAndDob(signup.getUsername(),signup.getMobileNo(),signup.getDob());
		}
		return exist;
	}

	@Override
	public String findUserType(SignUpForm signup)
	{
		String type = null;
		Optional<StaffProfile> staff = staffRepository.findByEmailAndMobileNoAndDob(signup.getEmail(),signup.getMobileNo(),signup.getDob());
		if(staff.isPresent()){
			if(staff.get().getClasss().equals("I") || staff.get().getClasss().equals("II")){
				type = "faculty";
			}
			if(staff.get().getClasss().equals("III")){
				type = "staff";
			}
			if(staff.get().getClasss().equals("IV")){
				type = "attendent";
			}
		}
		else{
			Optional<StudentProfile> stud = studentRepository.findByEnrollmentIdAndMobileNoAndDob(signup.getUsername(),signup.getMobileNo(),signup.getDob());
			if(stud.isPresent()){
				type = "student";
			}
		}
		return type;
	}

	@Override
	public boolean updateEmailAndUserId(long mobileNo)
	{
		Optional<User> user = userRepository.findByMobileNo(mobileNo);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(user.get().getUserType().equals("student")) {
			Optional<StudentProfile> stud = studentRepository.findByMobileNo(mobileNo);
			stud.get().setUserId(user.get().getId());
			stud.get().setEmail(user.get().getEmail());
			stud.get().setModifiedBy(user.get().getId());
			stud.get().setModifiedDate(simpleDateFormat.format(new Date()));
			studentRepository.save(stud.get());
			return true;
		}
		else {
			Optional<StaffProfile> staff = staffRepository.findByMobileNo(mobileNo);
			staff.get().setUserId(user.get().getId());
			staff.get().setEmail(user.get().getEmail());
			staff.get().setModifiedBy(user.get().getId());
			staff.get().setModifiedDate(simpleDateFormat.format(new Date()));
			staffRepository.save(staff.get());
			return true;
		}
	}

	@Override
	public List<ActiveStaffListResponse> getActiveStaffList() throws NotFoundException {
		List<User> users = userRepository.findAllByEnabledAndUserTypeNot(true,"Student");
		if(users.isEmpty())
			throw new NotFoundException("Activated staff accounts not found");
		List<ActiveStaffListResponse> activeStaffListResponses = new ArrayList<ActiveStaffListResponse>();
		for(User user : users) {	
			activeStaffListResponses.add(new ActiveStaffListResponse(user.getId(),
					staffRepository.findByEmail(user.getEmail()).get().getName(),
					user.getEmail()));
		}
		
		return activeStaffListResponses;
	}

}

