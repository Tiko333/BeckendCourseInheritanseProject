package picsart.model.cellPhone;

import picsart.model.electronics.ElectronicsInterface;

public interface PhoneInterface extends ElectronicsInterface {
    void call(String number);
    void message(String message);
    void sendEmail(String email);
}
