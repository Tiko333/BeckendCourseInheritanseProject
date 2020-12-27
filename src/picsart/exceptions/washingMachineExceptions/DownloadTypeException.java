package picsart.exceptions.washingMachineExceptions;

public class DownloadTypeException extends RuntimeException {
    public DownloadTypeException() {
        super("Download type must be not blank: ");
    }
}
