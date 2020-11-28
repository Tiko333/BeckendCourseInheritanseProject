package picsart.exceptions.videoGameConsoleExceptions;

public class AVOutputException extends RuntimeException {
    public AVOutputException() {
        super("AVOutput must be not blank: ");
    }
}
