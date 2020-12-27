package picsart.model.conditioner;

import picsart.exceptions.conditionerExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class Conditioner extends Electronics implements ConditionerInterface {
    private String type;
    private String operationModes;
    private String noiseLevel;
    private String color;
    private String maximumWorkingArea;
    private String size;
    private int temperature;

    public Conditioner(long id) {
        super(id);
        temperature = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (StringCheckService.checkString(type)) {
            throw new TypeException();
        }
        this.type = type;
    }

    public String getOperationModes() {
        return operationModes;
    }

    public void setOperationModes(String operationModes) {
        if (StringCheckService.checkString(operationModes)) {
            throw new OperatingModesException();
        }
        this.operationModes = operationModes;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        if (StringCheckService.checkString(noiseLevel)) {
            throw new NoiseLevelException();
        }
        this.noiseLevel = noiseLevel;
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

    public String getMaximumWorkingArea() {
        return maximumWorkingArea;
    }

    public void setMaximumWorkingArea(String maximumWorkingArea) {
        if (StringCheckService.checkString(maximumWorkingArea)) {
            throw new MaximumWorkingAreaException();
        }
        this.maximumWorkingArea = maximumWorkingArea;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        if (StringCheckService.checkString(size)) {
            throw new SizeException();
        }
        this.size = size;
    }

    @Override
    public void increaseTemperature() {
        System.out.println("Temperature: " + ++temperature);
    }

    @Override
    public void decreaseTemperature() {
        System.out.println("Temperature: " + --temperature);
    }


    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Conditioner model: ").append(getModel()).append(" \n")
                .append(" Type: ").append(type).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Type: ").append(type).append(" \n")
                .append("Operation Modes: ").append(operationModes).append(" \n")
                .append("Noise Level: ").append(noiseLevel).append(" \n")
                .append("Color: ").append(color).append(" \n")
                .append("Maximum Working Area: ").append(maximumWorkingArea).append(" \n")
                .append("Size: ").append(size).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conditioner that = (Conditioner) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(operationModes, that.operationModes) &&
                Objects.equals(noiseLevel, that.noiseLevel) &&
                Objects.equals(color, that.color) &&
                Objects.equals(maximumWorkingArea, that.maximumWorkingArea) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, operationModes, noiseLevel, color, maximumWorkingArea, size);
    }
}
