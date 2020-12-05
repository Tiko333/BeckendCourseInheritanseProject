package picsart.comparators.phoneComparators;

import picsart.model.cellPhone.Phone;
import picsart.model.computer.Laptop;

import java.util.Comparator;

public class CostComparator implements Comparator<Phone> {

    @Override
    public int compare(Phone o1, Phone o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
