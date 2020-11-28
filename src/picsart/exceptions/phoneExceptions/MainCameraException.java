package picsart.exceptions.phoneExceptions;

public class MainCameraException extends RuntimeException {
    public MainCameraException() {
        super("Main camera must be not blank: ");
    }
}
