package picsart.exceptions.conditionerExceptions;

public class SizeException extends RuntimeException {
    public SizeException() {
        super("Size must be not blank: ");
    }
}
