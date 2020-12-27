package picsart.exceptions.coffeeMakerExceptions;

public class CoffeeTypeException extends RuntimeException {
    public CoffeeTypeException() {
        super("Coffee type must be not blank: ");
    }
}
