package sgsits.cse.dis.user.service;

import javassist.NotFoundException;

public interface UserServices {
	boolean existsByUsername(String userName) throws NotFoundException;
}
