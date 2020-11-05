package sgsits.cse.dis.infrastructure.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javassist.NotFoundException;
import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.feignClient.UserClient;
import sgsits.cse.dis.infrastructure.model.FacultyRoomAssociation;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.model.InfrastructureLocation;
import sgsits.cse.dis.infrastructure.repo.FacultyRoomAssociationRepository;
import sgsits.cse.dis.infrastructure.repo.InfrastructureLocationRepository;
import sgsits.cse.dis.infrastructure.repo.InfrastructureRepository;
import sgsits.cse.dis.infrastructure.repo.InfrastructureTypeRepository;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.response.InfrastructureResponse;
import sgsits.cse.dis.infrastructure.response.RoomAssociationData;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;
/**
 * <h1><b>InfrastructureServiceImpl</b> class.</h1>
 * <p>This class contains implementation of all the library services which are defined in the <b>InfrastructureService</b> interface.
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
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@Service("infrastructureService")
public class InfrastructureServiceImpl implements InfrastructureService {
	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Autowired
	private InfrastructureRepository infrastructureRepository;

	@Autowired
	private InfrastructureTypeRepository infrastructureTypeRepository;

	@Autowired
	private InfrastructureLocationRepository infrastructureLocationRepository;

	@Autowired
	private FacultyRoomAssociationRepository facultyRoomAssociationRepository;

	@Autowired
	private UserClient userClient;

	@Override
	public List<String> getListOfInfrastructureLocations() {
		return infrastructureLocationRepository.findAll().stream().map(temp -> temp.getName())
				.collect(Collectors.toList());

	}
	

	@Override
	public List<InfrastructureBrief> getAllInfrastructure() {
		Function<? super Infrastructure, ? extends InfrastructureBrief> infrastructureBriefMapper = temp -> new InfrastructureBrief(
				temp.getId(), temp.getName(), temp.getArea(), temp.getNameAcronym(), temp.getLocation(),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getIncharge())),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getAssociateIncharge())),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getStaff())), temp.getAttendant());

		return infrastructureRepository.findAll()
				.stream().map(infrastructureBriefMapper)
				.collect(Collectors.toList());
	}

	@Override
	public List<InfrastructureBrief> getInfrastructureByType(String type) {

		Function<? super Infrastructure, ? extends InfrastructureBrief> infrastructureBriefMapper = temp -> new InfrastructureBrief(
				temp.getId(), temp.getName(), temp.getArea(), temp.getNameAcronym(), temp.getLocation(),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getIncharge())),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getAssociateIncharge())),
				userClient.getUserNameByIdOptional(Optional.ofNullable(temp.getStaff())), temp.getAttendant());

		return infrastructureRepository.findByType(type).stream().map(infrastructureBriefMapper)
				.collect(Collectors.toList());
	}

	@Override
	public List<String> getInfrastructureTypeList() {

		return infrastructureTypeRepository.findAll().stream().map(temp -> temp.getType()).collect(Collectors.toList());
	}

	@Override
	public String addNewInfrastructureLocation(String location) throws ConflictException {
		try {
			infrastructureLocationRepository.save(new InfrastructureLocation(location));
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Location [" + location + "] already present");
		} catch (Exception e) {
			throw new ConflictException("Cannot add value");
		}

		return "[" + location + "] location added sucessfully.";
	}

	@Override
	public List<RoomAssociationData> getRooms() {
		// List<Infrastructure> facultyRoom =
		// infrastructureRepository.findByType("Faculty Room");
		//
		// List<RoomAssociationData> associationDatas;
		// facultyRoom.stream()
		// .map(room -> new RoomAssociationData(room.getId(), room.getName(),
		// room.getArea(),
		// room.getLocation())).
		// .forEach(room -> room.setAssociatedTo(associatedTo));

		List<Infrastructure> infra = infrastructureRepository.findByType("Faculty Room");
		List<RoomAssociationData> roomAssociatedData = new ArrayList<>();
		for (Infrastructure inf : infra) {
			RoomAssociationData rad = new RoomAssociationData();
			rad.setId(inf.getId());
			rad.setArea(inf.getArea());
			rad.setLocation(inf.getLocation());
			rad.setName(inf.getName());
			List<FacultyRoomAssociation> facultyRoomId = facultyRoomAssociationRepository.findByRoomId(inf.getName());
			int number = facultyRoomId.size();
			String facultyAssociated[] = new String[number];
			int i = 0;
			for (FacultyRoomAssociation fra : facultyRoomId) {
				facultyAssociated[i] = userClient.getUserNameById(fra.getFacultyId());
				i++;
			}
			rad.setAssociatedTo(facultyAssociated);
			roomAssociatedData.add(rad);
		}
		return roomAssociatedData;
	}

	@Override
	public String addNewInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException {
		infrastructure.setCreatedDate(simpleDateFormat.format(new Date()));
		infrastructure.setCreatedBy(addedBy);
		try {
			if (infrastructureRepository.save(infrastructure).equals(null)) {
				throw new ConflictException("Unable to add Infrastructure.");
			}

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Infrastructure already Exists. "
					+ "This is due to same Infrastructure name [" + infrastructure.getName() + "] "
					+ "or same attendent name [" + userClient.getUserNameById(infrastructure.getAttendant()) + "]");
		}
		return "Infrastructure [" + infrastructure.getName() + "] added sucessfully";
	}

	@Transactional
	@Override
	public void deleteInfrastructure(String id) throws ConflictException {
		if (infrastructureRepository.deleteInfrastructureById(id) <= 0)
			throw new ConflictException("Unable to delete infrastructure");

	}

	@Override
	public String updateInfrastructure(Infrastructure infrastructure, String addedBy) throws ConflictException {
		infrastructure.setModifiedDate(simpleDateFormat.format(new Date()));
		infrastructure.setModifiedBy(addedBy);
		try {
			if (infrastructureRepository.save(infrastructure).equals(null)) {
				throw new ConflictException("Unable to update Infrastructure.");
			}

		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Infrastructure cannot be updated. "
					+ "This is due to same Infrastructure name [" + infrastructure.getName() + "] "
					+ "or same attendent name [" + userClient.getUserNameById(infrastructure.getAttendant()) + "]");
		}
		return "Infrastructure [" + infrastructure.getName() + "] updated sucessfully";
	}

	@Override
	public List<Infrastructure> findInfrastructureByName(String name) throws NotFoundException {
		List<Infrastructure> temp = infrastructureRepository.findByNameContainingIgnoreCase(name);
		if (temp.isEmpty())
			throw new NotFoundException("Not infrastructure with name [" + name + "] found.");
		temp.stream().forEach((infra) -> {
			infra.setIncharge(userClient.getUserNameByIdOptional(Optional.ofNullable(infra.getIncharge())));
			infra.setAssociateIncharge(
					userClient.getUserNameByIdOptional(Optional.ofNullable(infra.getAssociateIncharge())));
			infra.setStaff(userClient.getUserNameByIdOptional(Optional.ofNullable(infra.getStaff())));
		});
		return temp;

	}

	@Override
	public Infrastructure getInfrastructureById(String id) throws NotFoundException {
		Optional<Infrastructure> infrastructre = infrastructureRepository.findById(id);
		if (infrastructre.equals(Optional.empty()))
			throw new NotFoundException("No ifrastructure found by given id [" + id + "]");
		return infrastructre.get();
	}

	@Override
	public List<InfrastructureResponse> getInfrastructureNameAndIdByType(String type) {

		return infrastructureRepository.findByType(type).stream()
				.map(infrastructure -> new InfrastructureResponse(infrastructure.getId(), infrastructure.getName(),
						infrastructure.getNameAcronym()))
				.sorted(Comparator.comparing(InfrastructureResponse::getName)).collect(Collectors.toList());
	}

	@Override
	public List<String> findInchargeOf(String id) {
		List<Infrastructure> infrastructure = infrastructureRepository.findByInchargeOrAssociateInchargeOrStaff(id, id,
				id);
		List<String> incharge = new ArrayList<String>();
		for (Infrastructure infra : infrastructure)
			incharge.add(infra.getName());
		return incharge;
	}

	@Override
	public List<InfrastructureInchargeResponse> getInfraInchargeDetails() {
		List<InfrastructureInchargeResponse> details = new ArrayList<>();
		List<Infrastructure> allInfras = infrastructureRepository.findAll();
		for (Infrastructure infra : allInfras) {
			InfrastructureInchargeResponse res = new InfrastructureInchargeResponse();
			res.setId(infra.getId());
			res.setLocation(infra.getName());
			res.setPreviousIncharge(infra.getInchargeName());
			res.setPreviousInchargeId(infra.getIncharge());
			details.add(res);
		}
		return details;
	}

	@Override
	public Infrastructure updateIncharge(UpdateInfraInchargeDetail details, String id) {
		Optional<Infrastructure> cc = infrastructureRepository.findById(details.getLocationId());
		if (cc.isPresent()) {
			cc.get().setInchargeName(details.getInchargeName());
			cc.get().setIncharge(details.getNewIncharge());
			cc.get().setModifiedBy(id);
			cc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
		}
		Infrastructure test = infrastructureRepository.save(cc.get());
		return test;
	}


}