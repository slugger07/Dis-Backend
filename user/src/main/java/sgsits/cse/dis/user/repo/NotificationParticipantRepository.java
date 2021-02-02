package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.NotificationParticipant;
import sgsits.cse.dis.user.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The interface Notification participant repository.
 */
@Repository("notificationParticipantRepository")
public interface NotificationParticipantRepository extends JpaRepository<NotificationParticipant, String> {
    /**
     * Find all by user list.
     *
     * @param user the user
     * @return the list
     */
    List<NotificationParticipant> findAllByUser(User user);

    @Transactional
    @Modifying
    @Query("update NotificationParticipant n set n.readStatus = :readStatus where n.notification.id = :notificationId and n.user.id = :userId")
    void modifyReadStatus(@Param("notificationId") final String notificationId, @Param("userId") final String userId, @Param("readStatus") final boolean status);
    
    @Transactional
    @Modifying
    @Query("update NotificationParticipant n set n.readStatus = :readStatus where n.user.id = :userId")
    void modifyReadStatusOfAll(@Param("userId") final String userId, @Param("readStatus") final boolean status);
    
}
