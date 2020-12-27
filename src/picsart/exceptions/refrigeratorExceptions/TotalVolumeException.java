package picsart.exceptions.refrigeratorExceptions;

public class TotalVolumeException extends RuntimeException {
    public TotalVolumeException(int message) {
        super("Total volume must be bigger than '0' :" + message);
    }
}
