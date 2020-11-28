package picsart.exceptions.laptopExceptions;

public class ColorException extends RuntimeException {
    public ColorException() {
        super("Color must be not blank: ");
    }
}
