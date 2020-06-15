package sgsits.cse.dis.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group extends AuditInformation implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "group_id", nullable = false, unique = true)
    private String groupId;

    @Column(name="group_name")
    private String groupName;

    @OneToMany(targetEntity = GroupParticipant.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private Set<GroupParticipant> participants;

    public Set<GroupParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<GroupParticipant> participants) {
        this.participants = participants;
    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
