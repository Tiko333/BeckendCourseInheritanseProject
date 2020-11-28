package picsart.exceptions.cameraExceptions;

public class SensorSizeException extends RuntimeException {
    public SensorSizeException() {
        super("Sensor size must be not blank: ");
    }
}
