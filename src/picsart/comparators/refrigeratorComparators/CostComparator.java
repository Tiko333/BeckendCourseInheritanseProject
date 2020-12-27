package picsart.comparators.refrigeratorComparators;

import picsart.model.refrigerator.Refrigerator;

import java.util.Comparator;

public class CostComparator implements Comparator<Refrigerator> {

    @Override
    public int compare(Refrigerator o1, Refrigerator o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
