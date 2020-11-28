package picsart.exceptions.phoneExceptions;

public class PlatformOSException extends RuntimeException {
    public PlatformOSException() {
        super("Platform OS must be not blank: ");
    }
}
