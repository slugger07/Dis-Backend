package sgsits.cse.dis.user.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.UserServices;

@Component
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean existsByUsername(String username) throws NotFoundException {
			if(userRepository.existsByUsername(username))
				return true;
			else
				return false;
	}

}
