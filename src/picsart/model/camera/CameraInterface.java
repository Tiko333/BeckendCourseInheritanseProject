package picsart.model.camera;

import picsart.model.electronics.ElectronicsInterface;

public interface CameraInterface extends ElectronicsInterface {
    void takePhoto();
    void takeVideo();
    void zoomIn();
    void zoomOut();
    void openGallery();
}
