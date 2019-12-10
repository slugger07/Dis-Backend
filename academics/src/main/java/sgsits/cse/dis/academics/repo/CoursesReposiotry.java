package sgsits.cse.dis.academics.repo;

import sgsits.cse.dis.academics.model.Courses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoursesReposiotry extends JpaRepository<Courses, Long> {

	Courses findCourseIdByName(String name);

	Courses findNameByCourseId(String courseId);

	@Query(value = "SELECT DISTINCT name FROM courses", nativeQuery = true)
	List<String> findDistinctName();

}
