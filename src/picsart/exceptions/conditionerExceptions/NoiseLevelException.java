package picsart.exceptions.conditionerExceptions;

public class NoiseLevelException extends RuntimeException {
    public NoiseLevelException() {
        super("Noise level must be not blank: ");
    }
}
