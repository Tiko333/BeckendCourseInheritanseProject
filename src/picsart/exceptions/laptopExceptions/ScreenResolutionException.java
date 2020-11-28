package picsart.exceptions.laptopExceptions;

public class ScreenResolutionException extends RuntimeException {
    public ScreenResolutionException() {
        super("Screen resolution must be not blank: ");
    }
}
