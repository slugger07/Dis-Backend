package sgsits.cse.dis.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.user.model.Notification;

import java.util.List;

/**
 * The interface Notification repository.
 */
public interface NotificationRepository extends JpaRepository<Notification, String> {
}
