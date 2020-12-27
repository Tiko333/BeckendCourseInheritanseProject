package picsart.model.refrigerator;

import picsart.model.electronics.ElectronicsInterface;

public interface RefrigeratorInterface extends ElectronicsInterface {
    void openDoor();
    void closeDoor();
    int increaseTemperature();
    int decreaseTemperature();
    void printType();
}
