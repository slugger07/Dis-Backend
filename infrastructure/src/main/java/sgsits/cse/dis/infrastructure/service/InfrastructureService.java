package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Component;

import sgsits.cse.dis.infrastructure.model.Infrastructure;
import sgsits.cse.dis.infrastructure.request.UpdateInfraInchargeDetail;
import sgsits.cse.dis.infrastructure.response.InfrastructureInchargeResponse;

@Component
public interface InfrastructureService {
	
	List<String> findInchargeOf(String id);

	List<InfrastructureInchargeResponse> getInfraInchargeDetails();

	Infrastructure updateIncharge(UpdateInfraInchargeDetail details, String id);

}
