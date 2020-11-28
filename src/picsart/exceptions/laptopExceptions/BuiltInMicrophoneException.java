package picsart.exceptions.laptopExceptions;

public class BuiltInMicrophoneException extends RuntimeException {
    public BuiltInMicrophoneException() {
        super("Built in microphone be not blank: ");
    }
}
