package picsart.model.videoGameConsole;

import picsart.exceptions.videoGameConsoleExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

public class Console extends Electronics implements ConsoleInterface {

    private String processor = NOT_INDICATED;
    private String memory = NOT_INDICATED;
    private String storage = NOT_INDICATED;
    private String drive = NOT_INDICATED;
    private String aVoutput = NOT_INDICATED;
    private double weight = 1D;

    public Console(long id) {
        super(id);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        if (StringCheckService.checkString(processor)) {
            throw new ProcessorException();
        }
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        if (StringCheckService.checkString(memory)) {
            throw new MemoryException();
        }
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        if (StringCheckService.checkString(storage)) {
            throw new StorageException();
        }
        this.storage = storage;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        if (StringCheckService.checkString(drive)) {
            throw new DriveException();
        }
        this.drive = drive;
    }

    public String getAVoutput() {
        return aVoutput;
    }

    public void setAVoutput(String aVoutput) {
        if (StringCheckService.checkString(aVoutput)) {
            throw new AVOutputException();
        }
        this.aVoutput = aVoutput;
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

    @Override
    public void printInfo() {
        System.out.println("\n Console model: " + getModel() + " Storage: " + storage + " Price: " + getPrice());
    }

    @Override
    public String toString() {
        return super.toString() +
                "Processor: "+ processor + " \n" +
                "Memory: " + memory + " \n" +
                "Storage: " + storage + " \n" +
                "Drive: " + drive + " \n" +
                "AVoutput: " + aVoutput + " \n";
    }

    @Override
    public void playGame() {
        System.out.println("Playing game");
    }
}
