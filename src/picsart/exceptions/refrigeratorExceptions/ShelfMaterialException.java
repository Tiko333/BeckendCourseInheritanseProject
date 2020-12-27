package picsart.exceptions.refrigeratorExceptions;

public class ShelfMaterialException extends RuntimeException {
    public ShelfMaterialException() {
        super("Shelf material must be not blank: ");
    }
}
