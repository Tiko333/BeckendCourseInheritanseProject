package picsart.exceptions.conditionerExceptions;

public class MaximumWorkingAreaException extends RuntimeException {
    public MaximumWorkingAreaException() {
        super("Maximum working area must be not blank: ");
    }
}
