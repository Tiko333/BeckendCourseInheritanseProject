package picsart.model.tv;

import picsart.model.electronics.ElectronicsInterface;

public interface TvInterface extends ElectronicsInterface {
    void nextChannel();
    void previousChannel();
    String switchChannel(int channel);
    void increaseVolume();
    void decreaseVolume();
    void mute();
    void searchChannels();
}
