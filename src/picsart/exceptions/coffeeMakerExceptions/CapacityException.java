package picsart.exceptions.coffeeMakerExceptions;

public class CapacityException extends RuntimeException {
    public CapacityException() {
        super("Capacity must be not blank: ");
    }
}
