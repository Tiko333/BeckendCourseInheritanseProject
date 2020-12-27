package picsart.comparators.speakerComparators;

import picsart.model.speaker.Speaker;

import java.util.Comparator;

public class YearComparator implements Comparator<Speaker> {
    @Override
    public int compare(Speaker o1, Speaker o2) {
        return o1.getYear() - o2.getYear();
    }
}
