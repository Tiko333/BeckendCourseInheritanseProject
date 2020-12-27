package picsart.comparators.microwaveComparators;

import picsart.model.microwave.Microwave;

import java.util.Comparator;

public class YearComparator implements Comparator<Microwave> {
    @Override
    public int compare(Microwave o1, Microwave o2) {
        return o1.getYear() - o2.getYear();
    }
}
