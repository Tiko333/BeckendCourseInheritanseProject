package picsart.exceptions.laptopExceptions;

public class WifiTypeException extends RuntimeException {
    public WifiTypeException() {
        super("WIFI type be not blank: ");
    }
}
