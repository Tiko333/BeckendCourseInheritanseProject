package picsart.model.vacuumCleaner;

import picsart.exceptions.vacuumCleanerExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class VacuumCleaner extends Electronics implements VacuumCleanerInterface {
    private String type;
    private String pipeType;
    private String dustCollector;
    private String typeOfManagement;
    private String color;
    private boolean floorAndCarpetKnob;
    private boolean softFurnitureKnob;
    private boolean cornersKnob;
    private int workingPower;

    public VacuumCleaner(long id) {
        super(id);
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

    public String getPipeType() {
        return pipeType;
    }

    public void setPipeType(String pipeType) {
        if (StringCheckService.checkString(pipeType)) {
            throw new PipeTypeException();
        }
        this.pipeType = pipeType;
    }

    public String getDustCollector() {
        return dustCollector;
    }

    public void setDustCollector(String dustCollector) {
        if (StringCheckService.checkString(dustCollector)) {
            throw new DustCollectorException();
        }
        this.dustCollector = dustCollector;
    }

    public String getTypeOfManagement() {
        return typeOfManagement;
    }

    public void setTypeOfManagement(String typeOfManagement) {
        if (StringCheckService.checkString(typeOfManagement)) {
            throw new TypeOfManagementException();
        }
        this.typeOfManagement = typeOfManagement;
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

    public boolean isFloorAndCarpetKnob() {
        return floorAndCarpetKnob;
    }

    public void setFloorAndCarpetKnob(boolean floorAndCarpetKnob) {
        this.floorAndCarpetKnob = floorAndCarpetKnob;
    }

    public boolean isSoftFurnitureKnob() {
        return softFurnitureKnob;
    }

    public void setSoftFurnitureKnob(boolean softFurnitureKnob) {
        this.softFurnitureKnob = softFurnitureKnob;
    }

    public boolean isCornersKnob() {
        return cornersKnob;
    }

    public void setCornersKnob(boolean cornersKnob) {
        this.cornersKnob = cornersKnob;
    }

    public int getWorkingPower() {
        return workingPower;
    }

    @Override
    public void setWorkingPower(int power) {
        if (power >= 0) {
            System.out.println("Power set: " + power);
            workingPower = power;
            return;
        }
        throw new WorkingPowerException(power);
    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder("\n Model: ").append(getModel())
                .append(" Type: ").append(type)
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Type: ").append(type).append(" \n")
                .append("Pipe type: ").append(pipeType).append(" \n")
                .append("Dust collector: ").append(dustCollector).append(" \n")
                .append("Type of management: ").append(typeOfManagement).append(" \n")
                .append("Color:").append(color).append(" \n")
                .append("Floor and carpet knob: ").append(floorAndCarpetKnob ? "yes" : "no").append(" \n")
                .append("Soft furniture knob: ").append(softFurnitureKnob ? "yes" : "no").append(" \n")
                .append("Corners knob: ").append(cornersKnob ? "yes" : "no").append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return floorAndCarpetKnob == that.floorAndCarpetKnob &&
                softFurnitureKnob == that.softFurnitureKnob &&
                cornersKnob == that.cornersKnob &&
                Objects.equals(type, that.type) &&
                Objects.equals(pipeType, that.pipeType) &&
                Objects.equals(dustCollector, that.dustCollector) &&
                Objects.equals(typeOfManagement, that.typeOfManagement) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, pipeType, dustCollector, typeOfManagement, color, floorAndCarpetKnob, softFurnitureKnob, cornersKnob);
    }
}
