package sgsits.cse.dis.academics.service;

import java.util.List;

import sgsits.cse.dis.academics.response.FacultyNameListResponse;

public interface SemTimeTableServices {
	List<FacultyNameListResponse> getFacultyNameList();
}
