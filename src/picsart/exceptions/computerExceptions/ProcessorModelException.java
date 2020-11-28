package picsart.exceptions.computerExceptions;

public class ProcessorModelException extends RuntimeException {
    public ProcessorModelException() {
        super("Processor model must be not blank: ");
    }
}
