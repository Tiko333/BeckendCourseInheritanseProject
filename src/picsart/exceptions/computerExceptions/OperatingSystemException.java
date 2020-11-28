package picsart.exceptions.computerExceptions;

public class OperatingSystemException extends RuntimeException {
    public OperatingSystemException() {
        super("Operating system must be not blank: ");
    }
}
