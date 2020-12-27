package picsart.exceptions.refrigeratorExceptions;

public class FreezerPositionException extends RuntimeException {
    public FreezerPositionException() {
        super("Freezer position must be not blank: ");
    }
}
