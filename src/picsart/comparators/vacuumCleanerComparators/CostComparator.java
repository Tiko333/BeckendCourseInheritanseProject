package picsart.comparators.vacuumCleanerComparators;

import picsart.model.vacuumCleaner.VacuumCleaner;

import java.util.Comparator;

public class CostComparator implements Comparator<VacuumCleaner> {

    @Override
    public int compare(VacuumCleaner o1, VacuumCleaner o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
