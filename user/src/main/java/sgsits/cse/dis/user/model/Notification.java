package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Notification.
 */
@Entity
@Table(name = "notifications")
public class Notification extends AuditInformation {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
      name = "UUID",
      strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", nullable = false, unique = true)
  private String id;
  /**
   * The Heading.
   */
  @Column(name = "heading")
  private String heading;
  /**
   * The Description.
   */
  @Column(name = "description")
  private String description;
  /**
   * The Is active.
   */
  @Column(name = "is_active")
  private Boolean isActive;

  @OneToMany(mappedBy = "notification", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<NotificationParticipant> notificationParticipants = new HashSet<>();

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
   * Gets heading.
   *
   * @return the heading
   */
  public String getHeading() {
    return heading;
  }

  /**
   * Sets heading.
   *
   * @param heading the heading
   */
  public void setHeading(final String heading) {
    this.heading = heading;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * Gets active.
   *
   * @return the active
   */
  public Boolean getActive() {
    return isActive;
  }

  /**
   * Sets active.
   *
   * @param active the active
   */
  public void setActive(final Boolean active) {
    isActive = active;
  }

  /**
   * Gets notification participants.
   *
   * @return the notification participants
   */
  public Set<NotificationParticipant> getNotificationParticipants() {
    return notificationParticipants;
  }

  /**
   * Sets notification participants.
   *
   * @param notificationParticipants the notification participants
   */
  public void setNotificationParticipants(
      final Set<NotificationParticipant> notificationParticipants) {
    this.notificationParticipants = notificationParticipants;
  }
}
