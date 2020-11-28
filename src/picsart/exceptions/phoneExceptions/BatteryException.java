package picsart.exceptions.phoneExceptions;

public class BatteryException extends RuntimeException {
    public BatteryException() {
        super("Battery must be not blank: ");
    }
}
