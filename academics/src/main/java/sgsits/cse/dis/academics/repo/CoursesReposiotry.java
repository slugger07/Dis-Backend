package sgsits.cse.dis.academics.repo;

import sgsits.cse.dis.academics.model.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesReposiotry extends JpaRepository<Courses, Long> {

	Courses findCourseIdByName(String name);

}
