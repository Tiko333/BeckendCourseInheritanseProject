package picsart.exceptions.vacuumCleanerExceptions;

public class WorkingPowerException extends RuntimeException {
    public WorkingPowerException(int message) {
        super("Working power must not be negative: " + message);
    }
}
