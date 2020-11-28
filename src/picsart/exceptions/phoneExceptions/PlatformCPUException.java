package picsart.exceptions.phoneExceptions;

public class PlatformCPUException extends RuntimeException {
    public PlatformCPUException() {
        super("Platform CPU must be not blank: ");
    }
}
