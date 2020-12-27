package picsart.comparators.speakerComparators;

import picsart.model.speaker.Speaker;

import java.util.Comparator;

public class CostComparator implements Comparator<Speaker> {

    @Override
    public int compare(Speaker o1, Speaker o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
