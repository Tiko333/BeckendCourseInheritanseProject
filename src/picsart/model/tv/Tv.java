package picsart.model.tv;

import picsart.model.electronics.Electronics;

public class Tv extends Electronics implements TvInterface {

    private String screenType = NOT_INDICATED;
    private String  screenSize = NOT_INDICATED;
    private String resolution = NOT_INDICATED;
    private String features3dOrSmart = NOT_INDICATED;
    private int refreshRate = 60;
    private String technologies3d = NOT_INDICATED;

    public Tv(long id) {
        super(id);
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        if (screenType != null && !screenType.equals("")) {
            this.screenType = screenType;
            return;
        }
        System.err.println("Screen type must be not blank: ");
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        if (screenSize != null && !screenSize.isEmpty()) {
            this.screenSize = screenSize;
            return;
        }
        System.err.println("Screen size must be not blank: ");
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        if (resolution != null && !resolution.equals("")) {
            this.resolution = resolution;
            return;
        }
        System.err.println("Resolution must be not blank: ");
    }

    public String getFeatures3dOrSmart() {
        return features3dOrSmart;
    }

    public void setFeatures3dOrSmart(String features3dOrSmart) {
        if (features3dOrSmart != null && (features3dOrSmart.equals("3d") || features3dOrSmart.equals("smart"))) {
            this.features3dOrSmart = features3dOrSmart;
            return;
        }
        System.err.println("Features must be or '3d' or 'smart': ");
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        if (refreshRate == 60 || refreshRate == 120 || refreshRate == 240) {
            this.refreshRate = refreshRate;
            return;
        }
        System.err.println("Refresh rate must be '60Hz', '120Hz', '240Hz': ");
    }

    public String getTechnologies3d() {
        return technologies3d;
    }

    public void setTechnologies3d(String technologies3d) {
        if (technologies3d != null && !technologies3d.isEmpty()) {
            this.technologies3d = technologies3d;
            return;
        }
        System.err.println("3D technologies must be or 'active 3d' or 'passive 3d' or 'not 3d': ");
    }

    @Override
    public void printInfo() {
        System.out.println("\n TV model: " + getModel() + " Resolution: " + resolution + " Price: " + getPrice());
    }

    @Override
    public String toString() {
        return super.toString()
                + "Screen Type: " + screenType + " \n" +
                "Screen Size: " + screenSize + "inch \n" +
                "Resolution: " + resolution + " \n" +
                "Features: " + features3dOrSmart + " \n" +
                "Refresh rate: " + refreshRate + "Hz \n" +
                "3D technologies: " + technologies3d + " \n";
    }

    @Override
    public void nextChannel() {
        System.out.println("Channel is switched to next");
    }

    @Override
    public void previousChannel() {
        System.out.println("Channel is switched to previous");
    }

    @Override
    public String switchChannel(int channel) {
        return "Channel switched to " + channel;
    }

    @Override
    public void increaseVolume() {
        System.out.println("Volume increased");
    }

    @Override
    public void decreaseVolume() {
        System.out.println("Volume decreased");
    }

    @Override
    public void mute() {
        System.out.println("Volume is muted");
    }

    @Override
    public void searchChannels() {
        System.out.println("Searching channels");
    }
}
