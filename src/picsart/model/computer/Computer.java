package picsart.model.computer;

import picsart.model.electronics.Electronics;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Computer extends Electronics implements ComputerInterface {

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
        if (storageCapacity >= 1) {
            this.storageCapacity = storageCapacity;
            return;
        }
        System.err.println("Storage capacity must be bigger than 1GB: ");
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
        if (ram >= 1) {
            this.ram = ram;
            return;
        }
        System.err.println("RAM must be bigger than 1GB: ");
    }

    @Override
    public void printInfo() {
        System.out.println("\n Model: " + getModel() + " OS: " + operatingSystem + " Price: " + getPrice());
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

    @Override
    public void playVideo() {
        System.out.println("Playing video");
    }

    @Override
    public void playMusic() {
        System.out.println("Playing music");
    }

    @Override
    public void openPicture() {
        System.out.println("Picture opened");
    }

    @Override
    public void openBrowser() {
        System.out.println("Browser opened");
    }

    @Override
    public void createFolder() {
        System.out.println("Folder created");
    }

    @Override
    public void openFolder() {
        System.out.println("Folder opened");
    }

    @Override
    public void printDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss yyyy-dd-MM");
        System.out.println(simpleDateFormat.format(date));
    }
}
