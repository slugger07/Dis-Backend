package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;
/**
 * <h1><b>InfrasturctureService</b> interface.</h1>
 * <p>This interface lists all the Infrasturcutre services which can be implemented by class extending it.
 * 
 * @author Arjit Mishra.
 * @version 1.0.
 * @since 2-DEC-2019.
 * @throws ConflictException.
 * @throws NotFoundException.
 * @throws EventDoesNotExistException.
 * @throws DataIntegrityViolationException
 * @throws MethodArgumentNotValidException
 * @see NotFoundException.
 * @see DataIntegrityViolationException
 * @see MethodArgumentNotValidException
 */
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
	Infrastructure getInfrastructureById(String id) throws NotFoundException;
}
