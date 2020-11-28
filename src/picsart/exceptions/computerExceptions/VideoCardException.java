package picsart.exceptions.computerExceptions;

public class VideoCardException extends RuntimeException {
    public VideoCardException() {
        super("Video card must be not blank: ");
    }
}
