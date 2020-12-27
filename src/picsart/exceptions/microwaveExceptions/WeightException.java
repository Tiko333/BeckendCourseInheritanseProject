package picsart.exceptions.microwaveExceptions;

public class WeightException extends RuntimeException {
    public WeightException(double message) {
        super("Weight must be bigger than 0: " + message);
    }
}
