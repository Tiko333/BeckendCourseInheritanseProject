package picsart.comparators.conditionerComparators;

import picsart.model.camera.Camera;
import picsart.model.conditioner.Conditioner;

import java.util.Comparator;

public class YearComparator implements Comparator<Conditioner> {
    @Override
    public int compare(Conditioner o1, Conditioner o2) {
        return o1.getYear() - o2.getYear();
    }
}
