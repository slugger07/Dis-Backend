package sgsits.cse.dis.academics.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.academics.feignClient.UserClient;
import sgsits.cse.dis.academics.response.FacultyNameListResponse;
import sgsits.cse.dis.academics.service.SemTimeTableServices;

@Service
public class SemTimeTableServiceImpl implements SemTimeTableServices {

	@Autowired
	private UserClient userClient;
	
	@Override
	public List<FacultyNameListResponse> getFacultyNameList() {
		return userClient.getFacultyNameList()
				.stream()
				.map(faculty -> new FacultyNameListResponse(faculty.getId(), faculty.getName()))
				.sorted(Comparator.comparing(FacultyNameListResponse::getName))
				.collect(Collectors.toList());
	}

}
