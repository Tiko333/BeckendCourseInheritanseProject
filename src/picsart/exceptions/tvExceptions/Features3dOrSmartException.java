package picsart.exceptions.tvExceptions;

public class Features3dOrSmartException extends RuntimeException {
    public Features3dOrSmartException() {
        super("Features must be or '3d' or 'smart': ");
    }
}
