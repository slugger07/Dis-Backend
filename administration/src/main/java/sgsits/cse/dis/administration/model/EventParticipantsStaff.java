package sgsits.cse.dis.administration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "event_participants_staff")
public class EventParticipantsStaff {
		
		@Id
		@GeneratedValue(generator = "UUID")
		@GenericGenerator(
				name="UUID",
				strategy="org.hibernate.id.UUIDGenerator"
			)
		@Column(name = "id", nullable = false, unique = true)
		private String id;
		
		@Column(name = "created_by", nullable = false)
		private Long createdBy;

		@Column(name = "created_date", nullable = false)
		private String createdDate;

		@Column(name = "modified_by")
		private Long modifiedBy;

		@Column(name = "modified_date")
		private String modifiedDate;
		
		@Column(name = "event_id", nullable = false)
		private String eventId;
		
		@Column(name = "participant_id", nullable = false)
		private String participantId;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public Long getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(Long createdBy) {
			this.createdBy = createdBy;
		}

		public String getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(String createdDate) {
			this.createdDate = createdDate;
		}

		public Long getModifiedBy() {
			return modifiedBy;
		}

		public void setModifiedBy(Long modifiedBy) {
			this.modifiedBy = modifiedBy;
		}

		public String getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(String modifiedDate) {
			this.modifiedDate = modifiedDate;
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
