package picsart.exceptions.vacuumCleanerExceptions;

public class TypeOfManagementException extends RuntimeException {
    public TypeOfManagementException() {
        super("Type of management must be not blank: ");
    }
}
