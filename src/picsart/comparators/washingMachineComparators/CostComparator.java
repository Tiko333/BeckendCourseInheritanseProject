package picsart.comparators.washingMachineComparators;

import picsart.model.washingMachine.WashingMachine;

import java.util.Comparator;

public class CostComparator implements Comparator<WashingMachine> {

    @Override
    public int compare(WashingMachine o1, WashingMachine o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
