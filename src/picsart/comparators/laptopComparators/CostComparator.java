package picsart.comparators.laptopComparators;

import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;

import java.util.Comparator;

public class CostComparator implements Comparator<Laptop> {

    @Override
    public int compare(Laptop o1, Laptop o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
