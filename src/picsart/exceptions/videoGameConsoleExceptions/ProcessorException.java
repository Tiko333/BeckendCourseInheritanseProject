package picsart.exceptions.videoGameConsoleExceptions;

public class ProcessorException extends RuntimeException {
    public ProcessorException() {
        super("Processor must be not blank: ");
    }
}
