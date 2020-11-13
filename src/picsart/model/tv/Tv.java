package picsart.model.tv;

import picsart.model.electronics.Electronics;

public class Tv extends Electronics {

    private String screenType = NOT_INDICATED;
    private double screenSize = 25;
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
        if (screenType != null && screenType.equals("flat") || screenType.equals("curved")) {
            this.screenType = screenType;
            return;
        }
        System.err.println("Screen type must be or 'flat' or 'curved': ");
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        if (screenSize >= 25 && screenSize <= 80) {
            this.screenSize = screenSize;
            return;
        }
        System.err.println("Screen size must be bigger than 25 inch and smaller than 80 inch: ");
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        if (resolution != null && resolution.equals("8K") || resolution.equals("4K") || resolution.equals("1080p") || resolution.equals("720p")) {
            this.resolution = resolution;
            return;
        }
        System.err.println("Resolution must be '8K', '4K', '1080p', '720p': ");
    }

    public String getFeatures3dOrSmart() {
        return features3dOrSmart;
    }

    public void setFeatures3dOrSmart(String features3dOrSmart) {
        if (features3dOrSmart != null && (features3dOrSmart.equals("3D") || features3dOrSmart.equals("Smart TV"))) {
            this.features3dOrSmart = features3dOrSmart;
            return;
        }
        System.err.println("Features must be or '3D' or 'Smart TV': ");
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        if (refreshRate == 60 || refreshRate == 120 || refreshRate == 240) {
            this.refreshRate = refreshRate;
            return;
        }
        System.err.println("Refresh rate mut be '60Hz', '120Hz', '240Hz': ");
    }

    public String getTechnologies3d() {
        return technologies3d;
    }

    public void setTechnologies3d(String technologies3d) {
        if (technologies3d != null && (technologies3d.equals("active 3d") || technologies3d.equals("passive 3d"))) {
            this.technologies3d = technologies3d;
            return;
        }
        if (technologies3d != null && technologies3d.equals("not 3d")) {
            this.technologies3d = "Not 3d";
            return;
        }
        System.err.println("3D technologies must be or 'active 3d' or 'passive 3d': ");
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
}
