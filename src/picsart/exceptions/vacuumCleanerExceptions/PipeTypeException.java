package picsart.exceptions.vacuumCleanerExceptions;

public class PipeTypeException extends RuntimeException {
    public PipeTypeException() {
        super("Pipe type must be not blank: ");
    }
}
