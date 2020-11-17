package picsart.model.computer;

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
        if (screenSize != null && !screenSize.isEmpty()) {
            this.screenSize = screenSize;
            return;
        }
        System.err.println("Enter screen size: ");
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        if (screenResolution != null && !screenResolution.isEmpty()) {
            this.screenResolution = screenResolution;
            return;
        }
        System.err.println("Enter screen resolution: ");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty()) {
            this.color = color;
            return;
        }
        System.err.println("Enter color: ");
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
        if (builtInMicrophone != null && !builtInMicrophone.isEmpty()) {
            this.builtInMicrophone = builtInMicrophone;
            return;
        }
        System.err.println("Enter built-in microphone: ");
    }

    public String getBuiltInWebCam() {
        return builtInWebCam;
    }

    public void setBuiltInWebCam(String builtInWebCam) {
        if (builtInWebCam != null && !builtInWebCam.isEmpty()) {
            this.builtInWebCam = builtInWebCam;
            return;
        }
        System.err.println("Enter built-in webcam: ");
    }

    public String getBuiltInSpeaker() {
        return builtInSpeaker;
    }

    public void setBuiltInSpeaker(String builtInSpeaker) {
        if (builtInSpeaker != null && !builtInSpeaker.isEmpty()) {
            this.builtInSpeaker = builtInSpeaker;
            return;
        }
        System.err.println("Enter built-in speaker: ");
    }

    public String getBluetoothType() {
        return bluetoothType;
    }

    public void setBluetoothType(String bluetoothType) {
        if (bluetoothType != null && !bluetoothType.isEmpty()) {
            this.bluetoothType = bluetoothType;
            return;
        }
        System.err.println("Enter bluetooth type: ");
    }

    public String getWifiType() {
        return wifiType;
    }

    public void setWifiType(String wifiType) {
        if (wifiType != null && !wifiType.isEmpty()) {
            this.wifiType = wifiType;
            return;
        }
        System.err.println("Enter wifi type: ");
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
            return;
        }
        System.err.println("Weight must be bigger than 0: ");
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
