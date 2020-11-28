package picsart.exceptions.videoGameConsoleExceptions;

public class WeightException extends RuntimeException {
    public WeightException(double weight) {
        super("Weight must be bigger than 0: " + weight);
    }
}
