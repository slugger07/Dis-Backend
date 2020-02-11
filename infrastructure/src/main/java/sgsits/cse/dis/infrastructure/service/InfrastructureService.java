package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;

public interface InfrastructureService {
	List<String> getListOfInfrastructureLocations();
	List<String> getInfrastructureTypeList();
	List<InfrastructureBrief> getInfrastructureByType(String type);
	String addNewInfrastructureLocation(String location) throws ConflictException ;
}
