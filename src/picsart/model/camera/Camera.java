package picsart.model.camera;

import picsart.exceptions.cameraExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

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
        if (StringCheckService.checkString(megapixels)) {
            throw new MegapixelsException();
        }
        this.megapixels = megapixels;
    }

    public String getPixelDimensions() {
        return pixelDimensions;
    }

    public void setPixelDimensions(String pixelDimensions) {
        if (StringCheckService.checkString(pixelDimensions)) {
            throw new PixelDimensionsException();
        }
        this.pixelDimensions = pixelDimensions;
    }

    public String getPixelSize() {
        return pixelSize;
    }

    public void setPixelSize(String pixelSize) {
        if (StringCheckService.checkString(pixelSize)) {
            throw new PixelSizeException();
        }
        this.pixelSize = pixelSize;
    }

    public String getSensorSize() {
        return sensorSize;
    }

    public void setSensorSize(String sensorSize) {
        if (StringCheckService.checkString(sensorSize)) {
            throw new SensorSizeException();
        }
        this.sensorSize = sensorSize;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(String aspectRatio) {
        if (StringCheckService.checkString(aspectRatio)) {
            throw new AspectRatioException();
        }
        this.aspectRatio = aspectRatio;
    }

    public String getImageProcessor() {
        return imageProcessor;
    }

    public void setImageProcessor(String imageProcessor) {
        if (StringCheckService.checkString(imageProcessor)) {
            throw new ImageProcessorException();
        }
        this.imageProcessor = imageProcessor;
    }

    public boolean isSensorStabilization() {
        return sensorStabilization;
    }

    public void setSensorStabilization(boolean sensorStabilization) {
        this.sensorStabilization = sensorStabilization;
    }

    @Override
    public void printInfo() {
        System.out.println("\n Camera model: " + getModel() + " Megapixels: " + megapixels + " Price: " + getPrice());
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
