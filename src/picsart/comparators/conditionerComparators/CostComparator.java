package picsart.comparators.conditionerComparators;

import picsart.model.conditioner.Conditioner;

import java.util.Comparator;

public class CostComparator implements Comparator<Conditioner> {

    @Override
    public int compare(Conditioner o1, Conditioner o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
