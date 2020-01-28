package sgsits.cse.dis.user.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.user.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByMobileNo(long mobielNo);
    Optional<User> findByEmail(String email);
    Optional<User> findByMobileNo(long mobileNo);
	List<User> findAllByEnabledAndUserTypeNot(boolean enabled, String userType);



}