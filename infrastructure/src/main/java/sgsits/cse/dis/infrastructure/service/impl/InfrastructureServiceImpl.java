package sgsits.cse.dis.infrastructure.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.repo.InfrastructureRepository;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;
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

	@Override
	public List<InfrastructureInchargeResponse> getInfraInchargeDetails() {
		List<InfrastructureInchargeResponse> details = new ArrayList<>();
		List<Infrastructure> allInfras = infrastructureRepository.findAll();
		for(Infrastructure infra : allInfras) {
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
		if(cc.isPresent()) {
			cc.get().setInchargeName(details.getInchargeName());
			cc.get().setIncharge(details.getInchargeId());
			cc.get().setModifiedBy(id);
			cc.get().setModifiedDate((new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).format(new Date()));
		}
		Infrastructure test = infrastructureRepository.save(cc.get());
		return test;
	}
	
	
}
