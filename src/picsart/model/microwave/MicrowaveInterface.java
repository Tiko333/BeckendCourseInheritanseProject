package picsart.model.microwave;

import picsart.exceptions.microwaveExceptions.TimerException;

public interface MicrowaveInterface {
    void start();
    void setTimer(int time) throws TimerException;
}