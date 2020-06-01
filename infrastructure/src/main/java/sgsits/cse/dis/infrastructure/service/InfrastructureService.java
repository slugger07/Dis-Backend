package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Component;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;

@Component
public interface InfrastructureService {
	List<String> getListOfInfrastructureLocations();
	List<String> getInfrastructureTypeList();
	List<InfrastructureBrief> getInfrastructureByType(String type);
	String addNewInfrastructureLocation(String location) throws ConflictException;
	List<RoomAssociationData> getRooms();
	String addNewInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException;
	void deleteInfrastructure(String id) throws ConflictException;
	String updateInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException;
	List<Infrastructure> findInfrastructureByName(String name) throws NotFoundException;
	List<String> findInchargeOf(String id);

	List<InfrastructureInchargeResponse> getInfraInchargeDetails();

	Infrastructure updateIncharge(UpdateInfraInchargeDetail details, String id);

}
