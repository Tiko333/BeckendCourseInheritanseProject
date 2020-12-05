package picsart.comparators.consoleComparators;

import picsart.model.videoGameConsole.Console;

import java.util.Comparator;

public class YearComparator implements Comparator<Console> {
    @Override
    public int compare(Console o1, Console o2) {
        return o1.getYear() - o2.getYear();
    }
}
