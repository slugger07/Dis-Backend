package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "event_attachment")
public class EventAttachment implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "event_id", nullable = true)
    private String eventId;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Lob
    @Column(name = "file_data", nullable = false)
    private byte[] fileData;

    public EventAttachment() {
    }

    public EventAttachment(String fileName, byte[] fileData) {
        super();
        this.fileName = fileName;
        this.fileData = fileData;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
