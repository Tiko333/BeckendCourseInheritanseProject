package picsart.exceptions.washingMachineExceptions;

public class WeightException extends RuntimeException {
    public WeightException(int message) {
        super("Weight must be bigger than 0: " + message);
    }
}
