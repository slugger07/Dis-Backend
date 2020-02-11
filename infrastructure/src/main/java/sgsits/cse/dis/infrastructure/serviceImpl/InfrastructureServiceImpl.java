package sgsits.cse.dis.infrastructure.serviceImpl;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import sgsits.cse.dis.infrastructure.exception.ConflictException;
import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.model.InfrastructureLocation;
import sgsits.cse.dis.infrastructure.repo.InfrastructureLocationRepository;
import sgsits.cse.dis.infrastructure.repo.InfrastructureRepository;
import sgsits.cse.dis.infrastructure.repo.InfrastructureTypeRepository;
import sgsits.cse.dis.infrastructure.response.InfrastructureBrief;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@Service("infrastructureService")
public class InfrastructureServiceImpl implements InfrastructureService {
	
	@Autowired
	private InfrastructureRepository infrastructureRepository;
	
	@Autowired
	private InfrastructureTypeRepository infrastructureTypeRepository;
	
	@Autowired
	private InfrastructureLocationRepository infrastructureLocationRepository;
	
	@Override
	public List<String> getListOfInfrastructureLocations() {	
		return infrastructureLocationRepository.findAll().stream()
				.map(temp -> temp.getName())
				.collect(Collectors.toList());
		
	}
	@Override
	public List<InfrastructureBrief> getInfrastructureByType(String type) {
		
		Function<? super Infrastructure, ? extends InfrastructureBrief> infrastructureBriefMapper = temp -> new InfrastructureBrief(temp.getId(), temp.getName(), temp.getArea(), 
				temp.getNameAcronym(), temp.getLocation(), temp.getIncharge(), temp.getAssociateIncharge(),
				temp.getStaff(), temp.getAttendant());
		
		return infrastructureRepository.findByType(type).stream()
			.map(infrastructureBriefMapper)
			.collect(Collectors.toList());
	}
	@Override
	public List<String> getInfrastructureTypeList() {
		
		return infrastructureTypeRepository.findAll().stream()
				.map(temp -> temp.getType()).collect(Collectors.toList());
	}
	@Override
	public String addNewInfrastructureLocation(String location) throws ConflictException {
	    try{
	    	infrastructureLocationRepository.save(new InfrastructureLocation(location));
	    }
	    catch(DataIntegrityViolationException e){
	    	throw new DataIntegrityViolationException("Location ["+location+"] already present");
	    }
	    catch(Exception e){
	    	throw new ConflictException("Cannot add value");
	    }
	    
		return "["+location+"] location added sucessfully.";
	}

	
}