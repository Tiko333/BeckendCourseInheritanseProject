package picsart.exceptions.microwaveExceptions;

public class DimensionException extends RuntimeException {
    public DimensionException() {
        super("Dimension must be not blank: ");
    }
}
