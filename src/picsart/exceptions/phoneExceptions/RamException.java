package picsart.exceptions.phoneExceptions;

public class RamException extends RuntimeException {
    public RamException(int ram) {
        super("Ram must be bigger than '1' :" + ram);
    }
}
