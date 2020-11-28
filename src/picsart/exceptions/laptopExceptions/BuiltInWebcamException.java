package picsart.exceptions.laptopExceptions;

public class BuiltInWebcamException extends RuntimeException {
    public BuiltInWebcamException() {
        super("Built in webcam be not blank: ");
    }
}
