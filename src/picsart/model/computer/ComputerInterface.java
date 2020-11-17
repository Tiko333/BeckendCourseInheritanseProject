package picsart.model.computer;

import picsart.model.electronics.ElectronicsInterface;

public interface ComputerInterface extends ElectronicsInterface {
    void playVideo();
    void playMusic();
    void openPicture();
    void openBrowser();
    void createFolder();
    void openFolder();
    void printDate();
}
