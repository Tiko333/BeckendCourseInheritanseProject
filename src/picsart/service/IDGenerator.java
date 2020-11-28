package picsart.service;

import java.util.Random;

public class IDGenerator {
    private IDGenerator() {
    }

    public static int generateID(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }

    public static boolean checkLength(long id) {
        return Long.toString(id).length() == 9;
    }
}
