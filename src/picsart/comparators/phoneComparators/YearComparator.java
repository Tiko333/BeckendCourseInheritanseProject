package picsart.comparators.phoneComparators;

import picsart.model.cellPhone.Phone;
import picsart.model.computer.Laptop;

import java.util.Comparator;

public class YearComparator implements Comparator<Phone> {
    @Override
    public int compare(Phone o1, Phone o2) {
        return o1.getYear() - o2.getYear();
    }
}
