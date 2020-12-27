package picsart.comparators.microwaveComparators;

import picsart.model.microwave.Microwave;

import java.util.Comparator;

public class CostComparator implements Comparator<Microwave> {

    @Override
    public int compare(Microwave o1, Microwave o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
