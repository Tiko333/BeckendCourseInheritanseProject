package picsart.model.computer;

import picsart.exceptions.laptopExceptions.*;
import picsart.service.StringCheckService;

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
    public String toString() {
        return super.toString() +
                "Screen size: " + screenSize + "inch \n" +
                "Screen Resolution: " + screenResolution + " \n" +
                "Color: " + color + " \n" +
                "Screen: " + (isTouchScreen ?  "touch screen" : "not touch screen") + " \n" +
                "Built-in microphone: " + builtInMicrophone + " \n" +
                "Built-in webcam: " + builtInWebCam + " \n" +
                "Built-in speaker: " + builtInSpeaker + " \n" +
                "Bluetooth: " + bluetoothType + " \n" +
                "Wifi: " + wifiType + " \n" +
                "Weight: " + weight + "kg \n";
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
}
