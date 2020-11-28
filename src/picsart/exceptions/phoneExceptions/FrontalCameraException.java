package picsart.exceptions.phoneExceptions;

public class FrontalCameraException extends RuntimeException {
    public FrontalCameraException() {
        super("Frontal camera must be not blank: ");
    }
}
