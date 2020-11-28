package picsart.model.computer;

import picsart.exceptions.computerExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

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
        if (StringCheckService.checkString(processorModel)) {
            throw new ProcessorModelException();
        }
        this.processorModel = processorModel;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        if (StringCheckService.checkString(videoCard)) {
            throw new VideoCardException();
        }
        this.videoCard = videoCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        if (StringCheckService.checkString(operatingSystem)) {
            throw new OperatingSystemException();
        }
        this.operatingSystem = operatingSystem;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        if (storageCapacity < 1) {
            throw new StorageCapacityException(storageCapacity);
        }
        this.storageCapacity = storageCapacity;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        if (StringCheckService.checkString(storageType)) {
            throw new StorageTypeException();
        }
        this.storageType = storageType;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram < 1) {
            throw new RamException(ram);
        }
        this.ram = ram;
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
