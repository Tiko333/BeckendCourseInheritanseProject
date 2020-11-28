package picsart.exceptions.phoneExceptions;

public class DisplaySizeException extends RuntimeException {
    public DisplaySizeException() {
        super("Display size must be not blank: ");
    }
}
