package picsart.exceptions.washingMachineExceptions;

public class TypeOfInstallationException extends RuntimeException {
    public TypeOfInstallationException() {
        super("Type of installation must be not blank: ");
    }
}
