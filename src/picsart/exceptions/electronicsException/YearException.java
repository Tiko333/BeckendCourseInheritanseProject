package picsart.exceptions.electronicsException;

public class YearException extends RuntimeException {
    public YearException(int year) {
        super("Year must be bigger then 1990 and smaller than 2021: " + year);
    }
}
