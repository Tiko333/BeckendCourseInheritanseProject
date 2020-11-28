package picsart.exceptions.electronicsException;

public class PriceException extends RuntimeException {
    public PriceException(double price) {
        super("Price must be not negative: " + price);
    }
}
