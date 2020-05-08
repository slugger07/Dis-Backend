package sgsits.cse.dis.user.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.StudentProfile;
/**
 * <h1>StudentRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 27-JAN-2020
 */
@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<StudentProfile, String>{
	Optional<StudentProfile> findByEmail(String email);
	Optional<StudentProfile> findByEnrollmentId(String enrollmentId);
	Optional<StudentProfile> findByUserId(String id);
	boolean existsByEnrollmentIdAndMobileNoAndDob(String username, long l, Date dob);
	Optional<StudentProfile> findByEnrollmentIdAndMobileNoAndDob(String username, long mobileNo, Date dob);
	Optional<StudentProfile> findByMobileNo(long mobileNo);
	List<StudentProfile> findAllById(Iterable<String> ids);
}
