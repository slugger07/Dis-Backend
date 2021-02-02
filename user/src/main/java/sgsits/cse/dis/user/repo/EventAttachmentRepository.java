package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.EventAttachment;

@Repository
public interface EventAttachmentRepository extends JpaRepository<EventAttachment, String> {
}
