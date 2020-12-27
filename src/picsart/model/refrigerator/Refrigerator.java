package picsart.model.refrigerator;

import picsart.exceptions.cameraExceptions.MegapixelsException;
import picsart.exceptions.phoneExceptions.MemoryException;
import picsart.exceptions.refrigeratorExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

public class Refrigerator extends Electronics implements RefrigeratorInterface {
    private int temperature;
    private String type;
    private String energyConsumptionClass;
    private String dimensions;
    private String freezerPosition;
    private int freezerVolume;
    private int totalVolume;
    private int refrigeratorVolume;
    private String shelfMaterial;
    private String management;
    private boolean freshnessChamber;
    private String color;
    private boolean deFrost;
    private boolean noFrost;

    public Refrigerator(long id) {
        super(id);
        temperature = 0;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
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

    public String getEnergyConsumptionClass() {
        return energyConsumptionClass;
    }

    public void setEnergyConsumptionClass(String energyConsumptionClass) {
        if (StringCheckService.checkString(energyConsumptionClass)) {
            throw new EnergyConsumptionException();
        }
        this.energyConsumptionClass = energyConsumptionClass;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        if (StringCheckService.checkString(dimensions)) {
            throw new EnergyConsumptionException();
        }
        this.dimensions = dimensions;
    }

    public String getFreezerPosition() {
        return freezerPosition;
    }

    public void setFreezerPosition(String freezerPosition) {
        if (StringCheckService.checkString(freezerPosition)) {
            throw new FreezerPositionException();
        }
        this.freezerPosition = freezerPosition;
    }

    public int getFreezerVolume() {
        return freezerVolume;
    }

    public void setFreezerVolume(int freezerVolume) {
        if (freezerVolume <= 0) {
            throw new MemoryException(freezerVolume);
        }
        this.freezerVolume = freezerVolume;
    }

    public int getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(int totalVolume) {
        if (totalVolume <= 0) {
            throw new TotalVolumeException(totalVolume);
        }
        this.totalVolume = totalVolume;
    }

    public int getRefrigeratorVolume() {
        return refrigeratorVolume;
    }

    public void setRefrigeratorVolume(int refrigeratorVolume) {
        if (refrigeratorVolume <= 0) {
            throw new RefrigeratorVolumeException(refrigeratorVolume);
        }

        this.refrigeratorVolume = refrigeratorVolume;
    }

    public String getShelfMaterial() {
        return shelfMaterial;
    }

    public void setShelfMaterial(String shelfMaterial) {
        if (StringCheckService.checkString(shelfMaterial)) {
            throw new FreezerPositionException();
        }
        this.shelfMaterial = shelfMaterial;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        if (StringCheckService.checkString(management)) {
            throw new FreezerPositionException();
        }
        this.management = management;
    }

    public boolean isFreshnessChamber() {
        return freshnessChamber;
    }

    public void setFreshnessChamber(boolean freshnessChamber) {
        this.freshnessChamber = freshnessChamber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (StringCheckService.checkString(color)) {
            throw new FreezerPositionException();
        }
        this.color = color;
    }

    public boolean isDeFrost() {
        return deFrost;
    }

    public void setDeFrost(boolean deFrost) {
        this.deFrost = deFrost;
    }

    public boolean isNoFrost() {
        return noFrost;
    }

    public void setNoFrost(boolean noFrost) {
        this.noFrost = noFrost;
    }

    @Override
    public void openDoor() {
        System.out.println("Door opened");
    }

    @Override
    public void closeDoor() {
        System.out.println("Door closed");
    }

    @Override
    public int increaseTemperature() {
        return ++temperature;
    }

    @Override
    public int decreaseTemperature() {
        return --temperature;
    }

    @Override
    public void printInfo() {

        System.out.println(new StringBuilder()
                .append("Model: ").append(getModel()).append(" \n")
                .append("Total Volume: ").append(totalVolume).append(" \n")
                .append("De Frost: ").append(deFrost).append(" \n")
                .append("Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {

        return super.toString() + new StringBuilder()
                .append("Type: ").append(type).append(" \n")
                .append("Energy Consumption Class: ").append(energyConsumptionClass).append(" \n")
                .append("Dimensions: ").append(dimensions).append(" \n")
                .append("Freezer Position: ").append(freezerPosition).append(" \n")
                .append("Freezer Volume: ").append(freezerVolume).append(" \n")
                .append("Total Volume: ").append(totalVolume).append(" \n")
                .append("Refrigerator Volume: ").append(refrigeratorVolume).append(" \n")
                .append("Shelf Material: ").append(shelfMaterial).append(" \n")
                .append("Management: ").append(management).append(" \n")
                .append("Freshness Chamber: ").append(freshnessChamber ?  "yes" : "no").append(" \n")
                .append("color: ").append(color).append(" \n")
                .append("De Frost: ").append(deFrost ?  "yes" : "no").append(" \n")
                .append("No Frost: ").append(noFrost ?  "yes" : "no").append(" \n").toString();
    }

    @Override
    public void printType() {
        System.out.println(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return temperature == that.temperature &&
                freezerVolume == that.freezerVolume &&
                totalVolume == that.totalVolume &&
                refrigeratorVolume == that.refrigeratorVolume &&
                freshnessChamber == that.freshnessChamber &&
                deFrost == that.deFrost &&
                noFrost == that.noFrost &&
                Objects.equals(type, that.type) &&
                Objects.equals(energyConsumptionClass, that.energyConsumptionClass) &&
                Objects.equals(dimensions, that.dimensions) &&
                Objects.equals(freezerPosition, that.freezerPosition) &&
                Objects.equals(shelfMaterial, that.shelfMaterial) &&
                Objects.equals(management, that.management) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, type, energyConsumptionClass, dimensions, freezerPosition, freezerVolume, totalVolume, refrigeratorVolume, shelfMaterial, management, freshnessChamber, color, deFrost, noFrost);
    }
}
