package picsart.exceptions.cameraExceptions;

public class MegapixelsException extends RuntimeException {
    public MegapixelsException() {
        super("Megapixels must be not blank: ");
    }
}
