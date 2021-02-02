package sgsits.cse.dis.user.exception;

public class InternalServerError extends Exception {

    private static final long serialVersionUID = 1L;

    private String message;

    public InternalServerError() {
        super();
    }

    public InternalServerError(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
