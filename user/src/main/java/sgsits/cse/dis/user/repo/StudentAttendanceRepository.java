package sgsits.cse.dis.user.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.StudentAttendance;

@Repository()
public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, Long>{
	List<StudentAttendance> findByEnrollmentIdAndSubjectCode(String enrollmentId, String subjectCode);
	int countByEnrollmentIdAndSubjectCodeAndClassType(String enrollmentId, String subjectCode, char classType);
	int countByEnrollmentIdAndSubjectCodeAndClassTypeAndAttendance(String enrollmentId, String subjectCode, char classType, char attendance);
	
}
