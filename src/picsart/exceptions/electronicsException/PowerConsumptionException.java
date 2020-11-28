package picsart.exceptions.electronicsException;

public class PowerConsumptionException extends RuntimeException {
    public PowerConsumptionException() {
        super("Power consumption must be not blank: ");
    }
}
