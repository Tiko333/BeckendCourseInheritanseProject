package picsart.exceptions.refrigeratorExceptions;

public class DimensionsException extends RuntimeException {
    public DimensionsException() {
        super("Dimensions must be not blank: ");
    }
}
