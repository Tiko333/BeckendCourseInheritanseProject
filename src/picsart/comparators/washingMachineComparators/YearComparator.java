package picsart.comparators.washingMachineComparators;

import picsart.model.washingMachine.WashingMachine;

import java.util.Comparator;

public class YearComparator implements Comparator<WashingMachine> {
    @Override
    public int compare(WashingMachine o1, WashingMachine o2) {
        return o1.getYear() - o2.getYear();
    }
}
