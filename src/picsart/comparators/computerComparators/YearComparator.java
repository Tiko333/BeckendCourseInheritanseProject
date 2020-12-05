package picsart.comparators.computerComparators;

import picsart.model.computer.Computer;

import java.util.Comparator;

public class YearComparator implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getYear() - o2.getYear();
    }
}
