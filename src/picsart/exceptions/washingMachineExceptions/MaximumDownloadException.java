package picsart.exceptions.washingMachineExceptions;

public class MaximumDownloadException extends RuntimeException {
    public MaximumDownloadException() {
        super("Maximum download must be not blank: ");
    }
}
