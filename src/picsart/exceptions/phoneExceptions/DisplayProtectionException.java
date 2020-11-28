package picsart.exceptions.phoneExceptions;

public class DisplayProtectionException extends RuntimeException {
    public DisplayProtectionException() {
        super("Display protection must be not blank: ");
    }
}
