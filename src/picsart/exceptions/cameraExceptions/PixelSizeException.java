package picsart.exceptions.cameraExceptions;

public class PixelSizeException extends RuntimeException {
    public PixelSizeException() {
        super("Pixel size must be not blank: ");
    }
}
