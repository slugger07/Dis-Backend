package sgsits.cse.dis.academics.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.academics.repo.SchemeRepository;
import sgsits.cse.dis.academics.service.SchemeServices;

@Component
public class SchemeServiceImpl implements SchemeServices {
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Override
	public List<String> getAllSubjectAcronym() {
		List<String> subjectAcronymList;
		subjectAcronymList = schemeRepository.findDistinctSubjectAcronym();
		return subjectAcronymList;
	}

	@Override
	public List<String> getSubjectCodesByYearAndSemester(String year, String sem) {
		return schemeRepository.findByYearAndSemester(year,sem).stream()
				.map(scheme->scheme.getSubjectCode())
				.sorted()
				.collect(Collectors.toList());
	}

}
