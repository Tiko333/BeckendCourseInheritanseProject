package picsart.model.computer;

import picsart.model.electronics.Electronics;

public class Computer extends Electronics {

    private String processorModel = NOT_INDICATED;
    private String videoCard = NOT_INDICATED;
    private String operatingSystem = NOT_INDICATED;
    private int storageCapacity = 100;
    private String storageType = NOT_INDICATED;
    private int ram = 2;

    public Computer(long id) {
        super(id);
    }

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        if (processorModel != null && !processorModel.isEmpty()) {
            this.processorModel = processorModel;
            return;
        }
        System.err.println("Enter processor model: ");
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        if (videoCard != null && !videoCard.isEmpty()) {
            this.videoCard = videoCard;
            return;
        }
        System.err.println("Enter video card: ");
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        if (operatingSystem != null && !operatingSystem.isEmpty()) {
            this.operatingSystem = operatingSystem;
            return;
        }
        System.err.println("Enter operating system: ");
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        if (storageCapacity >= 100 && storageCapacity <= 8000) {
            this.storageCapacity = storageCapacity;
            return;
        }
        System.err.println("Storage capacity must be bigger than '100' and smaller than '8000' GB: ");
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        if (storageType != null && !storageType.isEmpty()) {
            this.storageType = storageType;
            return;
        }
        System.err.println("Enter storage type: ");
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram >= 2 && ram <= 512) {
            this.ram = ram;
            return;
        }
        System.err.println("RAM must be bigger than '2' and smaller than '512' GB: ");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Processor model: " + processorModel + " \n" +
                "Video card: " + videoCard + " \n" +
                "Operation system: " + operatingSystem + " \n" +
                "Storage capacity: " + storageCapacity + " \n" +
                "Storage Type: " + storageType + " \n" +
                "RAM: " + ram + " \n";
    }
}
