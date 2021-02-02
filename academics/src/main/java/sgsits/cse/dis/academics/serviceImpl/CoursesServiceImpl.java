package sgsits.cse.dis.academics.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.academics.repo.CoursesReposiotry;
import sgsits.cse.dis.academics.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService {
	
	@Autowired
	private CoursesReposiotry coursesReposiotry;
	
	@Override
	public String getCourseIdByName(String name) {
		
		return coursesReposiotry.findCourseIdByName(name).getCourseId();
	}

	@Override
	public String getNameByCourseId(String courseId) {
		
		return coursesReposiotry.findNameByCourseId(courseId).getName();
	}

	@Override
	public List<String> getCourseList() {
		 return coursesReposiotry.findDistinctName();
	}

}
