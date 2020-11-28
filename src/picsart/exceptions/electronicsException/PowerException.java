package picsart.exceptions.electronicsException;

public class PowerException extends RuntimeException {
    public PowerException() {
        super("Power must be not blank: ");
    }
}
