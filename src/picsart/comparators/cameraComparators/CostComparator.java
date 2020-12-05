package picsart.comparators.cameraComparators;

import picsart.model.camera.Camera;

import java.util.Comparator;

public class CostComparator implements Comparator<Camera> {

    @Override
    public int compare(Camera o1, Camera o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
