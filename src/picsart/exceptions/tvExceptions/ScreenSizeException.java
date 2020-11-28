package picsart.exceptions.tvExceptions;

public class ScreenSizeException extends RuntimeException {
    public ScreenSizeException() {
        super("Screen size must be not blank: ");
    }
}
