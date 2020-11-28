package picsart.exceptions.videoGameConsoleExceptions;

public class DriveException extends RuntimeException {
    public DriveException() {
        super("Drive must be not blank: ");
    }
}
