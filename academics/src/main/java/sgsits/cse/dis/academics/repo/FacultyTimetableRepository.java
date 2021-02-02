package sgsits.cse.dis.academics.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.academics.model.FacultyTimetable;

/**
 * <h1>FacultyTimetableRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 5-MAR-2020
 */

@Repository
public interface FacultyTimetableRepository extends JpaRepository<FacultyTimetable, String> {

	List<FacultyTimetable> findByFacultyId(String facultyId);

	List<FacultyTimetable> findByFacultyIdAndSemTimeTableId(String facultyId, String id);
	
}
