package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.user.model.NotificationParticipant;
import sgsits.cse.dis.user.model.User;

import java.util.List;

/**
 * The interface Notification participant repository.
 */
public interface NotificationParticipantRepository extends JpaRepository<NotificationParticipant, String> {
    /**
     * Find all by user list.
     *
     * @param user the user
     * @return the list
     */
    List<NotificationParticipant> findAllByUser(User user);
}
