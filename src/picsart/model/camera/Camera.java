package picsart.model.camera;

import picsart.model.electronics.Electronics;

public class Camera extends Electronics implements CameraInterface {

    private String megapixels = NOT_INDICATED;
    private String pixelDimensions = NOT_INDICATED;
    private String pixelSize = NOT_INDICATED;
    private String sensorSize = NOT_INDICATED;
    private String aspectRatio = NOT_INDICATED;
    private String imageProcessor = NOT_INDICATED;
    private boolean sensorStabilization = false;


    public Camera(long id) {
        super(id);
    }

    public String getMegapixels() {
        return megapixels;
    }

    public void setMegapixels(String megapixels) {
        if (megapixels != null && !megapixels.isEmpty()) {
            this.megapixels = megapixels;
            return;
        }
        System.err.println("Enter camera's megapixels: ");
    }

    public String getPixelDimensions() {
        return pixelDimensions;
    }

    public void setPixelDimensions(String pixelDimensions) {
        if (pixelDimensions != null && !pixelDimensions.isEmpty()) {
            this.pixelDimensions = pixelDimensions;
            return;
        }
        System.err.println("Enter camera's pixel dimensions: ");
    }

    public String getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(String pixelSize) {
        if (pixelSize != null && !pixelSize.isEmpty()) {
            this.pixelSize = pixelSize;
            return;
        }
        System.err.println("Enter camera's pixel size: ");
    }

    public String getSensorSize() {
        return sensorSize;
    }

    public void setSensorSize(String sensorSize) {
        if (sensorSize != null && !sensorSize.isEmpty()) {
            this.sensorSize = sensorSize;
            return;
        }
        System.err.println("Enter camera's sensor size: ");
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        if (aspectRatio != null && !aspectRatio.isEmpty()) {
            this.aspectRatio = aspectRatio;
            return;
        }
        System.err.println("Enter camera's aspect ratio: ");
    }

    public String getImageProcessor() {
        return imageProcessor;
    }

    public void setImageProcessor(String imageProcessor) {
        if (imageProcessor != null && !imageProcessor.isEmpty()) {
            this.imageProcessor = imageProcessor;
            return;
        }
        System.err.println("Enter camera's image processor: ");
    }

    public boolean isSensorStabilization() {
        return sensorStabilization;
    }

    public void setSensorStabilization(boolean sensorStabilization) {
        this.sensorStabilization = sensorStabilization;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Megapixels: " + megapixels + " \n" +
                "Pixel Dimensions: " + pixelDimensions + " \n" +
                "Pixel Size: " + pixelSize + " \n" +
                "Sensor size: " + sensorSize + " \n" +
                "Aspect ratio: " + aspectRatio + " \n" +
                "Image processor: " + imageProcessor + " \n" +
                "Sensor stabilization: " + (sensorStabilization ? "Yes" : "No") + " \n";
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking photo");
    }

    @Override
    public void takeVideo() {
        System.out.println("Taking video");
    }

    @Override
    public void zoomIn() {
        System.out.println("Zooming in");
    }

    @Override
    public void zoomOut() {
        System.out.println("Zooming out");
    }

    @Override
    public void openGallery() {
        System.out.println("Opening gallery");
    }
}
