package picsart.exceptions.electronicsException;

public class IDException extends RuntimeException {
    public IDException(long id) {
        super("Id must have 9 numbers: " + id);
    }
}
