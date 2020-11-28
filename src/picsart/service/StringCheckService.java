package picsart.service;

public class StringCheckService {
    public static boolean checkString(String text) {
        return text == null || text.isEmpty();
    }
}
