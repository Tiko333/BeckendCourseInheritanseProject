package picsart.comparators.computerComparators;

import picsart.model.computer.Computer;

import java.util.Comparator;

public class CostComparator implements Comparator<Computer> {

    @Override
    public int compare(Computer o1, Computer o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
