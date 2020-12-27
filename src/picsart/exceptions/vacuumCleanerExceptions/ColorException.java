package picsart.exceptions.vacuumCleanerExceptions;

public class ColorException extends RuntimeException {
    public ColorException() {
        super("Color must be not blank: ");
    }
}
