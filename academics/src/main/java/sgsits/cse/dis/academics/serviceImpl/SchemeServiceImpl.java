package sgsits.cse.dis.academics.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.academics.repo.SchemeRepository;
import sgsits.cse.dis.academics.service.CoursesService;
import sgsits.cse.dis.academics.service.SchemeServices;

@Component
public class SchemeServiceImpl implements SchemeServices {
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Autowired
	private CoursesService coursesService;
	
	@Override
	public List<String> getAllSubjectAcronym() {
		List<String> subjectAcronymList;
		subjectAcronymList = schemeRepository.findDistinctSubjectAcronym();
		return subjectAcronymList;
	}

	@Override
	public List<String> getSubjectCodesByYearAndSemesterAndCourse(String year, String sem,String course) {
		return schemeRepository.findByYearAndSemesterAndCourseId(year, sem, coursesService.getCourseIdByName(course))
				.stream()
				.map(scheme -> scheme.getSubjectCode())
				.sorted()
				.collect(Collectors.toList());
		
	}

}
