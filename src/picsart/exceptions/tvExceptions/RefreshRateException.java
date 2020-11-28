package picsart.exceptions.tvExceptions;

public class RefreshRateException extends RuntimeException {
    public RefreshRateException() {
        super("Refresh rate must be '60Hz', '120Hz', '240Hz': ");
    }
}
