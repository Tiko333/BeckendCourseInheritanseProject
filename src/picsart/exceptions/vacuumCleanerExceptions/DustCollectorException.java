package picsart.exceptions.vacuumCleanerExceptions;

public class DustCollectorException extends RuntimeException {
    public DustCollectorException() {
        super("Dust collector must be not blank: ");
    }
}
