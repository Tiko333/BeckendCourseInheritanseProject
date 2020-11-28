package picsart.exceptions.cameraExceptions;

public class PixelDimensionsException extends RuntimeException {
    public PixelDimensionsException() {
        super("Pixel dimensions must be not blank: ");
    }
}
