package picsart.exceptions.videoGameConsoleExceptions;

public class StorageException extends RuntimeException {
    public StorageException() {
        super("Storage must be not blank: ");
    }
}
