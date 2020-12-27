package picsart.exceptions.microwaveExceptions;

public class SwitchesException extends RuntimeException {
    public SwitchesException() {
        super("Switches must be not blank: ");
    }
}
