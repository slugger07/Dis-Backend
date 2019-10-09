package sgsits.cse.dis.administration.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgsits.cse.dis.administration.model.EventParticipantsStaff;


@Repository("")
public interface EventParticipantsStaffRepository extends JpaRepository< EventParticipantsStaff, Long> {
	
}
