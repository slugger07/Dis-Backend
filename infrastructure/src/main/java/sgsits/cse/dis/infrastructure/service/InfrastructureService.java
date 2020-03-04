package sgsits.cse.dis.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface InfrastructureService {
	
	List<String> findInchargeOf(String id);

}
