package picsart.model.videoGameConsole;

import picsart.exceptions.videoGameConsoleExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

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
    public void playGame() {
        System.out.println("Playing game");
    }

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Console model: ").append(getModel()).append(" \n")
                .append(" Storage: ").append(storage).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Processor: ").append(processor).append(" \n")
                .append("Memory: ").append(memory).append(" \n")
                .append("Storage: ").append(storage).append(" \n")
                .append("Drive: ").append(drive).append(" \n")
                .append("AVoutput: ").append(aVoutput).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Double.compare(console.weight, weight) == 0 &&
                Objects.equals(processor, console.processor) &&
                Objects.equals(memory, console.memory) &&
                Objects.equals(storage, console.storage) &&
                Objects.equals(drive, console.drive) &&
                Objects.equals(aVoutput, console.aVoutput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processor, memory, storage, drive, aVoutput, weight);
    }
}
