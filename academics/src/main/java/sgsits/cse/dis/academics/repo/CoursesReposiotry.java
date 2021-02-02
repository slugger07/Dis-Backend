package sgsits.cse.dis.academics.repo;

import sgsits.cse.dis.academics.model.Courses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 * <h1>CourseRepository</h1> interface.
 * this repository contains Jpafunciton to perform crud operation.
 * @author Arjit Mishra
 * @since 2-DEC-2019
 */
public interface CoursesReposiotry extends JpaRepository<Courses, String> {

	Courses findCourseIdByName(String name);

	Courses findNameByCourseId(String courseId);

	@Query(value = "SELECT DISTINCT name FROM courses", nativeQuery = true)
	List<String> findDistinctName();

}
