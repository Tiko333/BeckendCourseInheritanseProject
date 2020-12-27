package picsart.model.computer;

import picsart.exceptions.laptopExceptions.*;
import picsart.service.StringCheckService;

import java.util.Objects;

public class Laptop extends Computer implements LaptopInterface {

    private String screenSize = NOT_INDICATED;
    private String screenResolution = NOT_INDICATED;
    private String color = NOT_INDICATED;
    private boolean isTouchScreen = false;
    private String builtInMicrophone = NOT_INDICATED;
    private String builtInWebCam = NOT_INDICATED;
    private String builtInSpeaker = NOT_INDICATED;
    private String bluetoothType = NOT_INDICATED;
    private String wifiType = NOT_INDICATED;
    private double weight = 1;

    public Laptop(long id) {
        super(id);
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        if (StringCheckService.checkString(screenSize)) {
            throw new ScreenSizeException();
        }
        this.screenSize = screenSize;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        if (StringCheckService.checkString(screenResolution)) {
            throw new ScreenResolutionException();
        }
        this.screenResolution = screenResolution;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (StringCheckService.checkString(color)) {
            throw new ColorException();
        }
        this.color = color;
    }

    public boolean isTouchScreen() {
        return isTouchScreen;
    }

    public void setTouchScreen(boolean touchScreen) {
        isTouchScreen = touchScreen;
    }

    public String getBuiltInMicrophone() {
        return builtInMicrophone;
    }

    public void setBuiltInMicrophone(String builtInMicrophone) {
        if (StringCheckService.checkString(builtInMicrophone)) {
            throw new BuiltInMicrophoneException();
        }
        this.builtInMicrophone = builtInMicrophone;
    }

    public String getBuiltInWebCam() {
        return builtInWebCam;
    }

    public void setBuiltInWebCam(String builtInWebCam) {
        if (StringCheckService.checkString(builtInWebCam)) {
            throw new BuiltInWebcamException();
        }
        this.builtInWebCam = builtInWebCam;
    }

    public String getBuiltInSpeaker() {
        return builtInSpeaker;
    }

    public void setBuiltInSpeaker(String builtInSpeaker) {
        if (StringCheckService.checkString(builtInSpeaker)) {
            throw new BuiltInSpeakerException();
        }
        this.builtInSpeaker = builtInSpeaker;
    }

    public String getBluetoothType() {
        return bluetoothType;
    }

    public void setBluetoothType(String bluetoothType) {
        if (StringCheckService.checkString(bluetoothType)) {
            throw new BluetoothTypeException();
        }
        this.bluetoothType = bluetoothType;
    }

    public String getWifiType() {
        return wifiType;
    }

    public void setWifiType(String wifiType) {
        if (StringCheckService.checkString(wifiType)) {
            throw new WifiTypeException();
        }
        this.wifiType = wifiType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new WeightException(weight);
        }
        this.weight = weight;
    }

    @Override
    public void openLaptop() {
        System.out.println("Laptop opened");
    }

    @Override
    public void closeLaptop() {
        System.out.println("Laptop closed");
    }

    @Override
    public void turnOnWebCamera() {
        System.out.println("Web camera turned on");
    }

    @Override
    public void setCharging() {
        System.out.println("Charging is set");
    }

    @Override
    public void printInfo() {
        super.printInfo();
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Screen size: ").append(screenSize).append("inch \n")
                .append("Screen Resolution: ").append(screenResolution).append(" \n")
                .append("Color: ").append(color).append(" \n")
                .append("Screen: ").append(isTouchScreen ?  "touch screen" : "not touch screen").append(" \n")
                .append("Built-in microphone: ").append(builtInMicrophone).append(" \n")
                .append("Built-in webcam: ").append(builtInWebCam).append(" \n")
                .append("Built-in speaker: ").append(builtInSpeaker).append(" \n")
                .append("Bluetooth: ").append(bluetoothType).append(" \n")
                .append("Wifi: ").append(wifiType).append(" \n")
                .append("Weight: ").append(weight).append("kg \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Laptop laptop = (Laptop) o;
        return isTouchScreen == laptop.isTouchScreen &&
                Double.compare(laptop.weight, weight) == 0 &&
                Objects.equals(screenSize, laptop.screenSize) &&
                Objects.equals(screenResolution, laptop.screenResolution) &&
                Objects.equals(color, laptop.color) &&
                Objects.equals(builtInMicrophone, laptop.builtInMicrophone) &&
                Objects.equals(builtInWebCam, laptop.builtInWebCam) &&
                Objects.equals(builtInSpeaker, laptop.builtInSpeaker) &&
                Objects.equals(bluetoothType, laptop.bluetoothType) &&
                Objects.equals(wifiType, laptop.wifiType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenSize, screenResolution, color, isTouchScreen, builtInMicrophone, builtInWebCam, builtInSpeaker, bluetoothType, wifiType, weight);
    }
}
