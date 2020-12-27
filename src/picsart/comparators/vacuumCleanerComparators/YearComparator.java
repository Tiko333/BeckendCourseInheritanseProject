package picsart.comparators.vacuumCleanerComparators;

import picsart.model.vacuumCleaner.VacuumCleaner;

import java.util.Comparator;

public class YearComparator implements Comparator<VacuumCleaner> {
    @Override
    public int compare(VacuumCleaner o1, VacuumCleaner o2) {
        return o1.getYear() - o2.getYear();
    }
}
