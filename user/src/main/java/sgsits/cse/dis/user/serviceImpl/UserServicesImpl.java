package sgsits.cse.dis.user.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sgsits.cse.dis.user.model.User;
import sgsits.cse.dis.user.repo.UserRepository;
import sgsits.cse.dis.user.service.UserServices;

@Component
public class UserServicesImpl implements UserServices{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String getUserId(String username) {
		Optional<User> dbUser = userRepository.findByUsername(username);
		if (dbUser.isPresent()) {
			User user = dbUser.get();
			return user.getId();
		} 
		return null;
	}

}
