package picsart.model.camera;

import picsart.exceptions.cameraExceptions.*;
import picsart.model.electronics.Electronics;
import picsart.service.StringCheckService;

import java.io.Serializable;
import java.util.Objects;

public class Camera extends Electronics implements CameraInterface , Serializable {

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

    @Override
    public void printInfo() {
        System.out.println(new StringBuilder()
                .append("\n Camera model: ").append(getModel()).append(" \n")
                .append(" Megapixels: ").append(megapixels).append(" \n")
                .append(" Price: ").append(getPrice()).append(" \n").toString());
    }

    @Override
    public String toString() {
        return super.toString() + new StringBuilder()
                        .append("Megapixels: ").append(megapixels).append(" \n")
                        .append("Pixel Dimensions: ").append(pixelDimensions).append(" \n")
                        .append("Pixel Size: ").append(pixelSize).append(" \n")
                        .append("Sensor size: ").append(sensorSize).append(" \n")
                        .append("Aspect ratio: ").append(aspectRatio).append(" \n")
                        .append("Image processor: ").append(imageProcessor).append(" \n")
                        .append("Sensor stabilization: ").append(sensorStabilization ? "Yes" : "No").append(" \n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return sensorStabilization == camera.sensorStabilization &&
                Objects.equals(megapixels, camera.megapixels) &&
                Objects.equals(pixelDimensions, camera.pixelDimensions) &&
                Objects.equals(pixelSize, camera.pixelSize) &&
                Objects.equals(sensorSize, camera.sensorSize) &&
                Objects.equals(aspectRatio, camera.aspectRatio) &&
                Objects.equals(imageProcessor, camera.imageProcessor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(megapixels, pixelDimensions, pixelSize, sensorSize, aspectRatio, imageProcessor, sensorStabilization);
    }
}
