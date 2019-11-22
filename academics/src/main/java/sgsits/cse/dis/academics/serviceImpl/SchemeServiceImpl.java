package sgsits.cse.dis.academics.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.academics.repo.SchemeRepository;
import sgsits.cse.dis.academics.service.SchemeServices;

@Component
public class SchemeServiceImpl implements SchemeServices {
	
	@Autowired
	SchemeRepository schemeRepository;
	
	@Override
	public List<String> getAllSubjectAcronym() {
		List<String> subjectAcronymList;
		subjectAcronymList = schemeRepository.findDistinctSubjectAcronym();
		return subjectAcronymList;
	}

}
