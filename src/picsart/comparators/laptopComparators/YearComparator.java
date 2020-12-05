package picsart.comparators.laptopComparators;

import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;

import java.util.Comparator;

public class YearComparator implements Comparator<Laptop> {
    @Override
    public int compare(Laptop o1, Laptop o2) {
        return o1.getYear() - o2.getYear();
    }
}
