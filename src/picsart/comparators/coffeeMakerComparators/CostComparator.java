package picsart.comparators.coffeeMakerComparators;

import picsart.model.coffeeMaker.CoffeeMaker;

import java.util.Comparator;

public class CostComparator implements Comparator<CoffeeMaker> {

    @Override
    public int compare(CoffeeMaker o1, CoffeeMaker o2) {
        return Double.compare(o1.getPrice(), o2.getPrice());
    }
}
