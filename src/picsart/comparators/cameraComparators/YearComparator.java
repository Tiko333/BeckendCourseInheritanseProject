package picsart.comparators.cameraComparators;

import picsart.model.camera.Camera;

import java.util.Comparator;

public class YearComparator implements Comparator<Camera> {
    @Override
    public int compare(Camera o1, Camera o2) {
        return o1.getYear() - o2.getYear();
    }
}
