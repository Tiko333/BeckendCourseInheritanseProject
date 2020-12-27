package picsart.model.cellPhone;

import picsart.exceptions.phoneExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

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
        if (memory < 16) {
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

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Phone model: ").append(getModel()).append(" \n")
                .append(" OS: ").append(platformOS).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {

        return super.toString() + new StringBuilder()
                .append("Display type: ").append(displayType).append(" \n")
                .append("Display size:").append(displaySize).append(" \n")
                .append("Display resolution:").append(displayResolution).append(" \n")
                .append("Display protection:").append(displayProtection).append(" \n")
                .append("OS: ").append(platformOS).append(" \n")
                .append("CPU: ").append(platformCPU).append(" \n")
                .append("GPU: ").append(platformGPU).append(" \n")
                .append("Chipset: ").append(platformChipset).append(" \n")
                .append("Memory: ").append(memory).append(" \n")
                .append("RAM: ").append(ram).append(" \n")
                .append("Main Camera: ").append(mainCamera).append(" \n")
                .append("Frontal camera: ").append(frontalCamera).append(" \n")
                .append("Battery: ").append(battery).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return memory == phone.memory &&
                ram == phone.ram &&
                Objects.equals(displayType, phone.displayType) &&
                Objects.equals(displaySize, phone.displaySize) &&
                Objects.equals(displayResolution, phone.displayResolution) &&
                Objects.equals(displayProtection, phone.displayProtection) &&
                Objects.equals(platformOS, phone.platformOS) &&
                Objects.equals(platformCPU, phone.platformCPU) &&
                Objects.equals(platformGPU, phone.platformGPU) &&
                Objects.equals(platformChipset, phone.platformChipset) &&
                Objects.equals(mainCamera, phone.mainCamera) &&
                Objects.equals(frontalCamera, phone.frontalCamera) &&
                Objects.equals(battery, phone.battery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayType, displaySize, displayResolution, displayProtection, platformOS, platformCPU, platformGPU, platformChipset, memory, ram, mainCamera, frontalCamera, battery);
    }
}
