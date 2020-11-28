package picsart.exceptions.phoneExceptions;

public class PlatformChipsetException extends RuntimeException {
    public PlatformChipsetException() {
        super("Platform chipset must be not blank: ");
    }
}
