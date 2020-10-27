package sgsits.cse.dis.user.dto;

public class MarkAsReadDto {

    private String username;
    private String notificationId;

    public MarkAsReadDto() {
    }

    public MarkAsReadDto(String username, String notificationId) {
        this.username = username;
        this.notificationId = notificationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
}
