package picsart.comparators.tvComparators;

import picsart.model.cellPhone.Phone;
import picsart.model.tv.Tv;

import java.util.Comparator;

public class CostComparator implements Comparator<Tv> {

    @Override
    public int compare(Tv o1, Tv o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
