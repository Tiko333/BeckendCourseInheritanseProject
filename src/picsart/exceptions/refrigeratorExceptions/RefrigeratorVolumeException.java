package picsart.exceptions.refrigeratorExceptions;

public class RefrigeratorVolumeException extends RuntimeException {
    public RefrigeratorVolumeException(int message) {
        super("Refrigerator volume must be bigger than '0' :" + message);
    }
}
