package sgsits.cse.dis.user.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	
	@Query(value = "UPDATE staff_basic_profile SET user_id =?1 WHERE email = ?2", nativeQuery = true)
	@Modifying
	void updateUserIdByEmailId(String userId, String email);

	@Query(value = "SELECT user.username, staff_basic_profile.name  FROM staff_basic_profile, user where staff_basic_profile.user_id=user.id", nativeQuery = true)
	List<Object[]> findAllUserIdAndUsername();

}