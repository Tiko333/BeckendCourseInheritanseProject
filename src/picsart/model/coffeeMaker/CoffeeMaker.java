package picsart.model.coffeeMaker;

import picsart.exceptions.coffeeMakerExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class CoffeeMaker extends Electronics implements CoffeeMakerInterface {
    private String coffeeType;
    private String capacity;
    private String materialOfCorpus;
    private String color;
    private double weight;
    private int timer;

    public CoffeeMaker(long id) {
        super(id);
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(String coffeeType) {
        if (StringCheckService.checkString(coffeeType)) {
            throw new CoffeeTypeException();
        }
        this.coffeeType = coffeeType;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        if (StringCheckService.checkString(capacity)) {
            throw new CapacityException();
        }
        this.capacity = capacity;
    }

    public String getMaterialOfCorpus() {
        return materialOfCorpus;
    }

    public void setMaterialOfCorpus(String materialOfCorpus) {
        if (StringCheckService.checkString(materialOfCorpus)) {
            throw new MaterialOfCorpusException();
        }
        this.materialOfCorpus = materialOfCorpus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (StringCheckService.checkString(color)) {
            throw new ColorException();
        }
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 1) {
            throw new WeightException(weight);
        }
        this.weight = weight;
    }

    public int getTimer() {
        return timer;
    }

    @Override
    public void start() {
        System.out.println("Starting timer: " + timer + " minute");
    }

    @Override
    public void setTimer(int time) {
        if (time > 0) {
            System.out.println("Timer set: " + time);
            timer = time;
            return;
        }
        throw new TimerException(time);
    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder("\n Model: ").append(getModel())
                .append(" Capacity: ").append(capacity)
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Coffee type: ").append(coffeeType).append(" \n")
                .append("Capacity: ").append(capacity).append(" \n")
                .append("Material of corpus: ").append(materialOfCorpus).append(" \n")
                .append("Color:").append(color).append(" \n")
                .append("Weight: ").append(weight).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeMaker that = (CoffeeMaker) o;
        return weight == that.weight &&
                Objects.equals(coffeeType, that.coffeeType) &&
                Objects.equals(capacity, that.capacity) &&
                Objects.equals(materialOfCorpus, that.materialOfCorpus) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coffeeType, capacity, materialOfCorpus, color, weight);
    }
}
