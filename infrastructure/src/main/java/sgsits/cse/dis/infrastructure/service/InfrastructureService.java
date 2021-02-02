package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.InfrastructureResponse;
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

import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;

@Component
public interface InfrastructureService {
	/**
	 * @return
	 */
	List<String> getListOfInfrastructureLocations();

	/**
	 * @return
	 */
	List<String> getInfrastructureTypeList();

	/**
	 * @param type
	 * @return
	 */
	List<InfrastructureBrief> getInfrastructureByType(String type);
	
	/**
	 * @param type
	 * @return
	 */
	List<InfrastructureBrief> getAllInfrastructure();

	/**
	 * @param type
	 * @return
	 */
	List<InfrastructureResponse> getInfrastructureNameAndIdByType(String type);

	/**
	 * @param location
	 * @return
	 * @throws ConflictException
	 */
	String addNewInfrastructureLocation(String location) throws ConflictException;

	/**
	 * @return
	 */
	List<RoomAssociationData> getRooms();

	/**
	 * @param infrastructure
	 * @param addedBy
	 * @return
	 * @throws ConflictException
	 */
	String addNewInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException;

	/**
	 * @param id
	 * @throws ConflictException
	 */
	void deleteInfrastructure(String id) throws ConflictException;

	/**
	 * @param infrastructure
	 * @param addedBy
	 * @return
	 * @throws ConflictException
	 */
	String updateInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException;

	/**
	 * @param name
	 * @return
	 * @throws NotFoundException
	 */
	List<Infrastructure> findInfrastructureByName(String name) throws NotFoundException;

	/**
	 * @param id
	 * @return
	 * @throws NotFoundException
	 */
	Infrastructure getInfrastructureById(String id) throws NotFoundException;

	List<String> findInchargeOf(String id);

	List<InfrastructureInchargeResponse> getInfraInchargeDetails();

	Infrastructure updateIncharge(UpdateInfraInchargeDetail details, String id);

}
