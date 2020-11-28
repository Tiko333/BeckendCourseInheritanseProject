package picsart.exceptions.cameraExceptions;

public class ImageProcessorException extends RuntimeException {
    public ImageProcessorException() {
        super("Image processor must be not blank: ");
    }
}
