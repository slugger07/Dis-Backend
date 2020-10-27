package sgsits.cse.dis.user.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    private String message;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
