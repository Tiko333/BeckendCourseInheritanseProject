package picsart.exceptions.computerExceptions;

public class RamException extends RuntimeException {
    public RamException(int ram) {
        super("RAM must be bigger than 1GB: " + ram);
    }
}
