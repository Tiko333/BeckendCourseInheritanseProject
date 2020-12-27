package picsart.exceptions.microwaveExceptions;

public class OvenCapacityException extends RuntimeException {
    public OvenCapacityException() {
        super("Oven capacity must be not blank: ");
    }
}
