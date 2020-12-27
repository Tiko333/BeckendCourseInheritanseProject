package picsart.exceptions.vacuumCleanerExceptions;

public class TypeException extends RuntimeException {
    public TypeException() {
        super("Type must be not blank: ");
    }
}
