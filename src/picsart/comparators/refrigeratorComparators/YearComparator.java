package picsart.comparators.refrigeratorComparators;

import picsart.model.refrigerator.Refrigerator;

import java.util.Comparator;

public class YearComparator implements Comparator<Refrigerator> {
    @Override
    public int compare(Refrigerator o1, Refrigerator o2) {
        return o1.getYear() - o2.getYear();
    }
}
