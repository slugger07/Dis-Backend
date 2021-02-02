package sgsits.cse.dis.gateway.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.gateway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByMobileNo(long mobileNo);
    Optional<User> findByEmail(String email);
    Optional<User> findUserByResetToken(String token);
    Optional<User> findUserByActivationToken(String token);
	List<User> findByUserType(String string);
}