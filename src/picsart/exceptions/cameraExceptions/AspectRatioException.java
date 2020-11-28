package picsart.exceptions.cameraExceptions;

public class AspectRatioException extends RuntimeException {
    public AspectRatioException() {
        super("Aspect ratio must be not blank: ");
    }
}
