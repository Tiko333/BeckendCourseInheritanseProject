package picsart.model.microwave;

import picsart.exceptions.microwaveExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class Microwave extends Electronics implements MicrowaveInterface {
    private String ovenCapacity;
    private String control;
    private String switches;
    private String dimension;
    private double weight;
    private boolean screen;
    private int timer;

    public Microwave(long id) {
        super(id);
    }

    public String getOvenCapacity() {
        return ovenCapacity;
    }

    public void setOvenCapacity(String ovenCapacity) {
        if (StringCheckService.checkString(ovenCapacity)) {
            throw new OvenCapacityException();
        }
        this.ovenCapacity = ovenCapacity;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        if (StringCheckService.checkString(control)) {
            throw new ControlException();
        }
        this.control = control;
    }

    public String getSwitches() {
        return switches;
    }

    public void setSwitches(String switches) {
        if (StringCheckService.checkString(switches)) {
            throw new SwitchesException();
        }
        this.switches = switches;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        if (StringCheckService.checkString(dimension)) {
            throw new DimensionException();
        }
        this.dimension = dimension;
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

    public boolean isScreen() {
        return screen;
    }

    public void setScreen(boolean screen) {
        this.screen = screen;
    }

    @Override
    public void start() {
        System.out.println("Starting:");
    }

    @Override
    public void setTimer(int time) throws TimerException {
        if (time <= 0) {
            throw new TimerException(time);
        }
        timer = time;
        System.out.println("Timer set: " + time);

    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Model: ").append(getModel()).append(" \n")
                .append(" Oven capacity: ").append(ovenCapacity).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Oven capacity: ").append(getOvenCapacity()).append(" \n")
                .append("Control: ").append(getControl()).append(" \n")
                .append("Switches: ").append(getSwitches()).append(" \n")
                .append("Dimension:").append(getDimension()).append(" \n")
                .append("Weight: ").append(getWeight()).append(" \n")
                .append("Screen: ").append(isScreen() ? "yes" : "no").append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Microwave microwave = (Microwave) o;
        return Double.compare(microwave.weight, weight) == 0 &&
                screen == microwave.screen &&
                Objects.equals(ovenCapacity, microwave.ovenCapacity) &&
                Objects.equals(control, microwave.control) &&
                Objects.equals(switches, microwave.switches) &&
                Objects.equals(dimension, microwave.dimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ovenCapacity, control, switches, dimension, weight, screen);
    }
}
