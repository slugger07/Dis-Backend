package sgsits.cse.dis.academics.repo;

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
	
}
