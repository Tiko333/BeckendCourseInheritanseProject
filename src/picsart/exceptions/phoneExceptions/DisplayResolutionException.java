package picsart.exceptions.phoneExceptions;

public class DisplayResolutionException extends RuntimeException {
    public DisplayResolutionException() {
        super("Display resolution must be not blank: ");
    }
}
