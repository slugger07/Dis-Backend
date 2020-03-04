package sgsits.cse.dis.infrastructure.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.repo.InfrastructureRepository;
import sgsits.cse.dis.infrastructure.service.InfrastructureService;

@Component
public class InfrastructureServiceImpl implements InfrastructureService	 {
	
	@Autowired 
	InfrastructureRepository infrastructureRepository;

	@Override
	public List<String> findInchargeOf(String id) {
		List<Infrastructure> infrastructure = infrastructureRepository.findByInchargeOrAssociateInchargeOrStaff(id,id,id);
		List<String> incharge = new ArrayList<String>();
		for(Infrastructure infra : infrastructure)
			incharge.add(infra.getName());
		return incharge;
	}
	
	
}
