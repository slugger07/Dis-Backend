package sgsits.cse.dis.academics.service;

import java.util.List;

import org.springframework.stereotype.Component;

public interface CoursesService {
	String getCourseIdByName(String name);
	
	String getNameByCourseId(String courseId);
	
	List<String> getCourseList();
}
