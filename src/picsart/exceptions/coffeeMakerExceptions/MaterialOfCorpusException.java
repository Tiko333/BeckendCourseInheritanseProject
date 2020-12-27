package picsart.exceptions.coffeeMakerExceptions;

public class MaterialOfCorpusException extends RuntimeException {
    public MaterialOfCorpusException() {
        super("Material of corpus must be not blank: ");
    }
}
