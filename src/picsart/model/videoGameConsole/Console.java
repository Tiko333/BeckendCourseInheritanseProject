package picsart.model.videoGameConsole;

import picsart.model.electronics.Electronics;

public class Console extends Electronics {

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
        if (processor != null && !processor.isEmpty()) {
            this.processor = processor;
            return;
        }
        System.err.println("Enter console's processor: ");
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        if (memory != null && !memory.isEmpty()) {
            this.memory = memory;
            return;
        }
        System.err.println("Enter console's memory: ");
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        if (storage != null && !storage.isEmpty()) {
            this.storage = storage;
            return;
        }
        System.err.println("Enter console's storage: ");
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        if (drive != null && !drive.isEmpty()) {
            this.drive = drive;
            return;
        }
        System.err.println("Enter console's BD DVD drive: ");
    }

    public String getAVoutput() {
        return aVoutput;
    }

    public void setAVoutput(String aVoutput) {
        if (aVoutput != null && !aVoutput.isEmpty()) {
            this.aVoutput = aVoutput;
            return;
        }
        System.err.println("Enter console's AVoutput: ");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 1) {
            this.weight = weight;
            return;
        }
        System.err.println("Weight must be bigger than 1");
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
}
