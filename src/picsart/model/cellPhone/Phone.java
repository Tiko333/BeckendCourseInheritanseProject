package picsart.model.cellPhone;

import picsart.exceptions.phoneExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

public class Phone extends Electronics implements PhoneInterface {

    private String displayType = NOT_INDICATED;
    private String displaySize = NOT_INDICATED;
    private String displayResolution = NOT_INDICATED;
    private String displayProtection = NOT_INDICATED;
    private String platformOS = NOT_INDICATED;
    private String platformCPU = NOT_INDICATED;
    private String platformGPU = NOT_INDICATED;
    private String platformChipset = NOT_INDICATED;
    private int memory = 16;
    private int ram = 1;
    private String mainCamera = NOT_INDICATED;
    private String frontalCamera = NOT_INDICATED;
    private String battery = NOT_INDICATED;

    public Phone(long id) {
        super(id);
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        if (StringCheckService.checkString(displaySize)) {
            throw new DisplayTypeException();
        }
        this.displayType = displayType;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        if (StringCheckService.checkString(displaySize)) {
            throw new DisplaySizeException();
        }
        this.displaySize = displaySize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        if (StringCheckService.checkString(displayResolution)) {
            throw new DisplayResolutionException();
        }
        this.displayResolution = displayResolution;
    }

    public String getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(String displayProtection) {
        if (StringCheckService.checkString(displayProtection)) {
            throw new DisplayProtectionException();
        }
        this.displayProtection = displayProtection;
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        if (StringCheckService.checkString(platformOS)) {
            throw new PlatformOSException();
        }
        this.platformOS = platformOS;
    }

    public String getPlatformCPU() {
        return platformCPU;
    }

    public void setPlatformCPU(String platformCPU) {
        if (StringCheckService.checkString(platformCPU)) {
            throw new PlatformCPUException();
        }
        this.platformCPU = platformCPU;
    }

    public String getPlatformGPU() {
        return platformGPU;
    }

    public void setPlatformGPU(String platformGPU) {
        if (StringCheckService.checkString(platformGPU)) {
            throw new PlatformGPUException();
        }
        this.platformGPU = platformGPU;
    }

    public String getPlatformChipset() {
        return platformChipset;
    }

    public void setPlatformChipset(String platformChipset) {
        if (StringCheckService.checkString(platformChipset)) {
            throw new PlatformChipsetException();
        }
        this.platformChipset = platformChipset;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory <= 16) {
            throw new MemoryException(memory);
        }
        this.memory = memory;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram <= 1) {
            throw new RamException(ram);
        }
        this.ram = ram;
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        if (StringCheckService.checkString(mainCamera)) {
            throw new MainCameraException();
        }
        this.mainCamera = mainCamera;
    }

    public String getFrontalCamera() {
        return frontalCamera;
    }

    public void setFrontalCamera(String frontalCamera) {
        if (StringCheckService.checkString(frontalCamera)) {
            throw new FrontalCameraException();
        }
        this.frontalCamera = frontalCamera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        if (StringCheckService.checkString(battery)) {
            throw new BatteryException();
        }
        this.battery = battery;
    }

    @Override
    public void printInfo() {
        System.out.println("\n Phone model: " + getModel() + " OS: " + platformOS + " Price: " + getPrice());
    }

    @Override
    public String toString() {
        return super.toString() +
                "Display type: " + displayType + " \n" +
                "Display size: " + displaySize + " \n" +
                "Display resolution: " + displayResolution + " \n" +
                "Display protection: " + displayProtection + " \n" +
                "OS: " + platformOS + " \n" +
                "CPU: " + platformCPU + " \n" +
                "GPU: " + platformGPU + " \n" +
                "Chipset: " + platformChipset + " \n" +
                "Memory: " + memory + " \n" +
                "RAM: " + ram + " \n" +
                "Main Camera: " + mainCamera + " \n" +
                "Frontal camera: " + frontalCamera + " \n" +
                "Battery: " + battery + " \n";
    }

    @Override
    public void call(String number) {
        System.out.println("Calling: " + number);
    }

    @Override
    public void message(String message) {
        System.out.println("Sending message: " + message);
    }

    @Override
    public void sendEmail(String email) {
        System.out.println("Sending email: " + email);
    }
}
