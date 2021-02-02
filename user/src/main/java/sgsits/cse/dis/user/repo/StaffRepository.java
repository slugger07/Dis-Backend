package sgsits.cse.dis.user.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.message.response.FacultyData;
import sgsits.cse.dis.user.model.StaffProfile;
/**
 * <h1>StaffRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 25-JAN-2020
 */
@Repository("staffRepository")
public interface StaffRepository extends JpaRepository<StaffProfile, String>{
	Optional<StaffProfile> findByEmail(String email);
	Optional<StaffProfile> findByEmployeeId(String employeeId);
	Optional<StaffProfile> findByUserId(String userId);
	//@Query(value="SELECT s.name, s.email from staff_basic_profile s where class = 'I' or class = 'II' order by current_designation", nativeQuery=true)
	List<StaffProfile> findByClasssOrClasssOrderByCurrentDesignation(String classs1, String classs2);
	boolean existsByEmailAndMobileNoAndDob(String email, long mobileNo, Date dob);
	Optional<StaffProfile> findByEmailAndMobileNoAndDob(String email, long mobileNo, Date dob);
	Optional<StaffProfile> findByMobileNo(Long mobileNo);
	StaffProfile findNameByUserId(String userId);
	List<StaffProfile> findByNameContainingIgnoreCase(String name);
	Optional<StaffProfile> findById(String id);
}