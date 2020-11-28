package picsart.exceptions.computerExceptions;

public class StorageTypeException extends RuntimeException {
    public StorageTypeException() {
        super("Storage type must be not blank: ");
    }
}
