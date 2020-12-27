package picsart.exceptions.refrigeratorExceptions;

public class ManagementException extends RuntimeException {
    public ManagementException() {
        super("Management must be not blank: ");
    }
}
