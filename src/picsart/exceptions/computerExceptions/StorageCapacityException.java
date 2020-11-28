package picsart.exceptions.computerExceptions;

public class StorageCapacityException extends RuntimeException {
    public StorageCapacityException(int storageCapacity) {
        super("Storage capacity must be bigger than 1GB: " + storageCapacity);
    }
}
