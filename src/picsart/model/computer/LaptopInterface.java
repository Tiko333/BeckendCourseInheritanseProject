package picsart.model.computer;

import picsart.model.electronics.ElectronicsInterface;

public interface LaptopInterface extends ElectronicsInterface, ComputerInterface {
    void openLaptop();
    void closeLaptop();
    void turnOnWebCamera();
    void setCharging();
}
