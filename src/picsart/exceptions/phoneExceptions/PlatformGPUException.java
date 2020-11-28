package picsart.exceptions.phoneExceptions;

public class PlatformGPUException extends RuntimeException {
    public PlatformGPUException() {
        super("Platform GPU must be not blank: ");
    }
}
