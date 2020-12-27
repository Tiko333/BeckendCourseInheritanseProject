package picsart.exceptions.speakerExceptions;

public class FrequencyException extends RuntimeException {
    public FrequencyException() {
        super("Frequency must be not blank: ");
    }
}
