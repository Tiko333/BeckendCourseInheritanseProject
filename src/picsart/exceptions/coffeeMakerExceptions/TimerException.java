package picsart.exceptions.coffeeMakerExceptions;

public class TimerException extends RuntimeException {
    public TimerException(int time) {
        super("Timer must be bigger than 0: " + time);
    }
}
