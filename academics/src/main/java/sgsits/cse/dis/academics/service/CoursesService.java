package sgsits.cse.dis.academics.service;

import org.springframework.stereotype.Component;

@Component
public interface CoursesService {
	String getCourseIdByName(String name);
	
	String getNameByCourseId(String courseId);
}
