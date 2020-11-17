package picsart.model.cellPhone;

import picsart.model.electronics.Electronics;

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
        if (displayType != null && !displayType.isEmpty()) {
            this.displayType = displayType;
            return;
        }
        System.err.println("Enter phone's display type: ");
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        if (displayType != null && !displaySize.isEmpty()) {
            this.displaySize = displaySize;
            return;
        }
        System.err.println("Enter phone's display size: ");
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        if (displayResolution != null && !displayResolution.isEmpty()) {
            this.displayResolution = displayResolution;
            return;
        }
        System.err.println("Enter phone's display resolution: ");
    }

    public String getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(String displayProtection) {
        if (displayProtection != null && !displayProtection.isEmpty()) {
            this.displayProtection = displayProtection;
            return;
        }
        System.err.println("Enter phone's display protection: ");
    }

    public String getPlatformOS() {
        return platformOS;
    }

    public void setPlatformOS(String platformOS) {
        if (platformOS != null && !platformOS.isEmpty()) {
            this.platformOS = platformOS;
            return;
        }
        System.err.println("Enter phone's platform OS: ");
    }

    public String getPlatformCPU() {
        return platformCPU;
    }

    public void setPlatformCPU(String platformCPU) {
        if (platformCPU != null && !platformCPU.isEmpty()) {
            this.platformCPU = platformCPU;
            return;
        }
        System.err.println("Enter phone's platform CPU: ");
    }

    public String getPlatformGPU() {
        return platformGPU;
    }

    public void setPlatformGPU(String platformGPU) {
        if (platformGPU != null && !platformGPU.isEmpty()) {
            this.platformGPU = platformGPU;
            return;
        }
        System.err.println("Enter phone's platform GPU: ");
    }

    public String getPlatformChipset() {
        return platformChipset;
    }

    public void setPlatformChipset(String platformChipset) {
        if (platformChipset != null && !platformChipset.isEmpty()) {
            this.platformChipset = platformChipset;
            return;
        }
        System.err.println("Enter phone's platform Chipset: ");
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        if (memory >= 16 && memory <= 256) {
            this.memory = memory;
            return;
        }
        System.err.println("Memory must be bigger than '16' and smaller than '256' GB:");
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram >= 1 && ram <= 12) {
            this.ram = ram;
            return;
        }
        System.err.println("Ram must be '1' to '12' GB:");
    }

    public String getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(String mainCamera) {
        if (mainCamera != null && !mainCamera.isEmpty()) {
            this.mainCamera = mainCamera;
            return;
        }
        System.err.println("Enter phone's main camera: ");
    }

    public String getFrontalCamera() {
        return frontalCamera;
    }

    public void setFrontalCamera(String frontalCamera) {
        if (frontalCamera != null && !frontalCamera.isEmpty()) {
            this.frontalCamera = frontalCamera;
            return;
        }
        System.err.println("Enter phone's frontal camera: ");
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        if (battery != null && !battery.isEmpty()) {
            this.battery = battery;
            return;
        }
        System.err.println("Enter phone's battery: ");
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
