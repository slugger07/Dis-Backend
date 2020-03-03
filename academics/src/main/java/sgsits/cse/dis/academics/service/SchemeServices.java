package sgsits.cse.dis.academics.service;

import java.util.List;

import org.springframework.stereotype.Component;


public interface SchemeServices {
	List<String> getAllSubjectAcronym();
	List<String> getSubjectCodesByYearAndSemester(String year,String sem);

}
