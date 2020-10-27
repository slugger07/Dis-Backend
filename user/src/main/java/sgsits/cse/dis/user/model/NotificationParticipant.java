package sgsits.cse.dis.user.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * The type Notification participant.
 */
@Entity
@Table(name = "notification_participant")
public class NotificationParticipant extends AuditInformation {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", nullable = false, unique = true)
  private String id;
  @ManyToOne
  private Notification notification;
  @ManyToOne
  private User user;
  @Column(name = "read_status")
  private Boolean readStatus;

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(final String id) {
    this.id = id;
  }

  /**
   * Gets notification.
   *
   * @return the notification
   */
  public Notification getNotification() {
    return notification;
  }

  /**
   * Sets notification.
   *
   * @param notification the notification
   */
  public void setNotification(final Notification notification) {
    this.notification = notification;
  }

  /**
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(final User user) {
    this.user = user;
  }

  /**
   * Gets read status.
   *
   * @return the read status
   */
  public Boolean getReadStatus() {
    return readStatus;
  }

  /**
   * Sets read status.
   *
   * @param readStatus the read status
   */
  public void setReadStatus(final Boolean readStatus) {
    this.readStatus = readStatus;
  }
}
