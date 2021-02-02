package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.user.model.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, String> {
    List<Group> findByCreatedBy(String username);
}
