package picsart.exceptions.phoneExceptions;

public class MemoryException extends RuntimeException {
    public MemoryException(int memory) {
        super("Memory must be bigger than '16' :" + memory);
    }
}
