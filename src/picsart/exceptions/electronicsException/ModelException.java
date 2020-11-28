package picsart.exceptions.electronicsException;

public class ModelException extends RuntimeException {
    public ModelException() {
        super("Model must be not blank: ");
    }
}
