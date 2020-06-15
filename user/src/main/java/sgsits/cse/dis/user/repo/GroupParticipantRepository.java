package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.user.model.GroupParticipant;

public interface GroupParticipantRepository extends JpaRepository<GroupParticipant,String> {
}
