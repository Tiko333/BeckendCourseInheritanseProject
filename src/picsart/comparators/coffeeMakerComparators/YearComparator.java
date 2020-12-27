package picsart.comparators.coffeeMakerComparators;

import picsart.model.coffeeMaker.CoffeeMaker;

import java.util.Comparator;

public class YearComparator implements Comparator<CoffeeMaker> {
    @Override
    public int compare(CoffeeMaker o1, CoffeeMaker o2) {
        return o1.getYear() - o2.getYear();
    }
}
