package sgsits.cse.dis.user.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;


@Entity
@Table(name = "event_participant")
public class EventParticipant implements Serializable {

		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(
				name="UUID",
				strategy="org.hibernate.id.UUIDGenerator"
			)
		@Column(name = "id", nullable = false, unique = true)
		private String id;

    @Column(name = "event_id", nullable = false)
    private String eventId;

    @Column(name = "participant_id", nullable = false)
    private String participantId;

    public EventParticipant() {}

    public EventParticipant(String id, String participantId, Event event) {
        super();
        this.participantId = participantId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}