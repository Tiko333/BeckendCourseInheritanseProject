package picsart.exceptions.tvExceptions;

public class ScreenTypeException extends RuntimeException {
    public ScreenTypeException() {
        super("Screen type must be not blank: ");
    }
}
