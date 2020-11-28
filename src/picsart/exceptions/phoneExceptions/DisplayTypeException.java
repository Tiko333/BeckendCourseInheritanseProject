package picsart.exceptions.phoneExceptions;

public class DisplayTypeException extends RuntimeException {
    public DisplayTypeException() {
        super("Display type must be not blank: ");
    }
}
