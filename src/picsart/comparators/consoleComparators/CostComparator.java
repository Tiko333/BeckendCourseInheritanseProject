package picsart.comparators.consoleComparators;

import picsart.model.videoGameConsole.Console;

import java.util.Comparator;

public class CostComparator implements Comparator<Console> {

    @Override
    public int compare(Console o1, Console o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
