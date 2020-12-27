package picsart.model.tv;

import picsart.exceptions.tvExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.util.Objects;

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
        if (StringCheckService.checkString(screenType)) {
            throw new ScreenTypeException();
        }
        this.screenType = screenType;
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

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        if (StringCheckService.checkString(resolution)) {
            throw new ResolutionException();
        }
        this.resolution = resolution;
    }

    public String getFeatures3dOrSmart() {
        return features3dOrSmart;
    }

    public void setFeatures3dOrSmart(String features3dOrSmart) {
        if (features3dOrSmart != null && (features3dOrSmart.equals("3d") || features3dOrSmart.equals("smart"))) {
            this.features3dOrSmart = features3dOrSmart;
            return;
        }
        throw new Features3dOrSmartException();
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        if (refreshRate == 60 || refreshRate == 120 || refreshRate == 240) {
            this.refreshRate = refreshRate;
            return;
        }
        throw new RefreshRateException();
    }

    public String getTechnologies3d() {
        return technologies3d;
    }

    public void setTechnologies3d(String technologies3d) {
        if (StringCheckService.checkString(technologies3d)) {
            throw new Technologies3dException();
        }
        this.technologies3d = technologies3d;
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

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n TV model: ").append(getModel()).append(" \n")
                .append(" Resolution: ").append(resolution).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                .append("Screen Type: ").append(screenType).append(" \n")
                .append("Screen Size: ").append(screenSize).append("inch \n")
                .append("Resolution: ").append(resolution).append(" \n")
                .append("Features: ").append(features3dOrSmart).append(" \n")
                .append("Refresh rate: ").append(refreshRate).append("Hz \n")
                .append("3D technologies: ").append(technologies3d).append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tv tv = (Tv) o;
        return refreshRate == tv.refreshRate &&
                Objects.equals(screenType, tv.screenType) &&
                Objects.equals(screenSize, tv.screenSize) &&
                Objects.equals(resolution, tv.resolution) &&
                Objects.equals(features3dOrSmart, tv.features3dOrSmart) &&
                Objects.equals(technologies3d, tv.technologies3d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenType, screenSize, resolution, features3dOrSmart, refreshRate, technologies3d);
    }
}
