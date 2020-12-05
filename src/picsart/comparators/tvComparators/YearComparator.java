package picsart.comparators.tvComparators;

import picsart.model.cellPhone.Phone;
import picsart.model.tv.Tv;

import java.util.Comparator;

public class YearComparator implements Comparator<Tv> {
    @Override
    public int compare(Tv o1, Tv o2) {
        return o1.getYear() - o2.getYear();
    }
}
