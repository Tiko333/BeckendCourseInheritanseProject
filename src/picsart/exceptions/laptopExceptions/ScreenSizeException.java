package picsart.exceptions.laptopExceptions;

public class ScreenSizeException extends RuntimeException {
    public ScreenSizeException() {
        super("Screen size must be not blank: ");
    }
}
