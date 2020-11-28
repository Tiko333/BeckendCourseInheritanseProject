package picsart.exceptions.tvExceptions;

public class ResolutionException extends RuntimeException {
    public ResolutionException() {
        super("Resolution must be not blank: ");
    }
}
