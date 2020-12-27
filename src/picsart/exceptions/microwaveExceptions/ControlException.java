package picsart.exceptions.microwaveExceptions;

public class ControlException extends RuntimeException {
    public ControlException() {
        super("Control must be not blank: ");
    }
}
