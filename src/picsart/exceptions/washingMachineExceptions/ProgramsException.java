package picsart.exceptions.washingMachineExceptions;

public class ProgramsException extends RuntimeException {
    public ProgramsException() {
        super("Programs must be not blank: ");
    }
}
