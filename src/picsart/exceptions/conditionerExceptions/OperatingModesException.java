package picsart.exceptions.conditionerExceptions;

public class OperatingModesException extends RuntimeException {
    public OperatingModesException() {
        super("Operating modes must be not blank: ");
    }
}
