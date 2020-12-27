package picsart.exceptions.microwaveExceptions;

public class TimerException extends Throwable {
    public TimerException(int time) {
        super("Timer must be bigger than 0: ");
    }
}
