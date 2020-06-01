package sgsits.cse.dis.user.exception;

public class UnauthorizedException extends Exception {

    private static final long serialVersionUID = 1L;

    private String message;

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
