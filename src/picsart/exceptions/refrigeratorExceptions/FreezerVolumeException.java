package picsart.exceptions.refrigeratorExceptions;

public class FreezerVolumeException extends RuntimeException {
    public FreezerVolumeException(int message) {
        super("Freezer volume must be bigger than '0' :" + message);
    }
}
