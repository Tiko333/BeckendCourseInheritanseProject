package picsart.main;

import picsart.model.computer.Laptop;
import picsart.model.tv.Tv;

public class Main {
    public static void main(String[] args) {
        Tv samsung = new Tv(546513214);
        samsung.setModel("65 QLED Q9F 4K Smart TV");
        samsung.setPrice(3079);
        samsung.setYear(2018);
        samsung.setFeatures3dOrSmart("Smart TV");
        samsung.setRefreshRate(60);
        samsung.setResolution("4K");
        samsung.setScreenSize(65);
        samsung.setScreenType("flat");
        samsung.setTechnologies3d("not 3d");
        samsung.setPower("AC100-240V 50/60Hz");
        samsung.setPowerConsumption("350W");
        System.out.println(samsung);

        Laptop hp = new Laptop(451321897);
        hp.setModel("NoteBook");
        hp.setOperatingSystem("Windows 10");
        hp.setPrice(1000);
        hp.setProcessorModel("Intel Core i5 8250U");
        hp.setRam(8);
        hp.setStorageCapacity(256);
        hp.setStorageType("ssd");
        hp.setVideoCard("Intel HD Graphics 620");
        hp.setYear(2020);
        hp.setBluetoothType("Yes");
        hp.setBuiltInMicrophone("Yes");
        hp.setBuiltInSpeaker("2 Speakers");
        hp.setBuiltInWebCam("Yes");
        hp.setColor("Black");
        hp.setScreenResolution("1080");
        hp.setScreenSize("15.60");
        hp.setTouchScreen(false);
        hp.setWifiType("Wi‑Fi 4");
        hp.setWeight(1.95);
        hp.setPower("19 V");
        hp.setPowerConsumption("45W");
        System.out.println(hp);
    }
}
