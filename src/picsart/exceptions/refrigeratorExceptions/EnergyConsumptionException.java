package picsart.exceptions.refrigeratorExceptions;

public class EnergyConsumptionException extends RuntimeException {
    public EnergyConsumptionException() {
        super("Energy consumption must be not blank: ");
    }
}
