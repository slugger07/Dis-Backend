package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgsits.cse.dis.user.model.Notification;

import java.util.List;

/**
 * The interface Notification repository.
 */
@Repository("notificationServiceRepository")
public interface NotificationRepository extends JpaRepository<Notification, String> {
}
