package picsart.exceptions.videoGameConsoleExceptions;

public class MemoryException extends RuntimeException {
    public MemoryException() {
        super("Memory must be not blank: ");
    }
}
