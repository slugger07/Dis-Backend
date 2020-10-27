package sgsits.cse.dis.user.dtos;

public class ProfilePictureDto {

    private long id;
    private String name;
    private String type;
    private byte[] picByte;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(final byte[] picByte) {
        this.picByte = picByte;
    }
}
