package sgsits.cse.dis.academics.service;

import java.util.List;

import javassist.NotFoundException;
import sgsits.cse.dis.academics.exception.ConflictException;
import sgsits.cse.dis.academics.request.FacultyTimeTableForm;

/**
 * <h1><b>SemesterTimeTableServices</b> interface.</h1>
 * <p>This interface defines all the time table services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 3-MAR-2020.
 * @throws ConflictException.
 */


public interface SemesterTimeTableServices {
	String addTimeTable(FacultyTimeTableForm facultyTimeTableForm,String userId) throws ConflictException;
	List<String> getSubjectCodesByFacultyIdAndSession(String facultyId,String session);
	FacultyTimeTableForm getTimeTableByFacultyIdAndSessionAndSubjectCode(String facultyId,String session,String subjectCode) throws NotFoundException;
}
