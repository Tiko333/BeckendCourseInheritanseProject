package picsart.exceptions.speakerExceptions;

public class InterfaceTypeException extends RuntimeException {
    public InterfaceTypeException() {
        super("Interface type must be not blank: ");
    }
}
