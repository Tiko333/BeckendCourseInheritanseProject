package picsart.service;

import picsart.model.camera.Camera;
import picsart.model.cellPhone.Phone;
import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;
import picsart.model.tv.Tv;
import picsart.model.videoGameConsole.Console;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConverterService {

    private ConverterService() {
    }

    public static List<Console> readConsolesFile(List<String> consoles) {
        List<String> data = new ArrayList<>();
        for (String value : consoles) {
            if (!value.equals("")) {
                String[] s = value.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }

                data.add(stringData.toString());
            }
        }

        List<Console> consolesArray = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Console console = new Console(Long.parseLong(data.get(index)));
                console.setModel(data.get(++index));
                console.setProcessor(data.get(++index));
                console.setMemory(data.get(++index));
                console.setStorage(data.get(++index));
                console.setDrive(data.get(++index));
                console.setAVoutput(data.get(++index));
                console.setWeight(Double.parseDouble(data.get(++index)));
                console.setPower(data.get(++index));
                console.setPowerConsumption(data.get(++index));
                console.setYear(Integer.parseInt(data.get(++index)));
                console.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                consolesArray.add(console);
            }
        }

        return consolesArray;
    }

    public static List<Camera> readCamerasFile(List<String> cameras) {
        List<String> data = new ArrayList<>();
        for (String value : cameras) {
            if (!value.equals("")) {
                String[] s = value.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }

                data.add(stringData.toString());
            }
        }

        List<Camera> camerasList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Camera camera = new Camera(Long.parseLong(data.get(index)));
                camera.setModel(data.get(++index));
                camera.setMegapixels(data.get(++index));
                camera.setPixelDimensions(data.get(++index));
                camera.setPixelSize(data.get(++index));
                camera.setSensorSize(data.get(++index));
                camera.setAspectRatio(data.get(++index));
                camera.setImageProcessor(data.get(++index));
                camera.setSensorStabilization(data.get(++index).equals("have") ? true : false);
                camera.setPower(data.get(++index));
                camera.setPowerConsumption(data.get(++index));
                camera.setYear(Integer.parseInt(data.get(++index)));
                camera.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                camerasList.add(camera);
            }
        }

        return camerasList;
    }

    public static List<Phone> readPhonesFile(List<String> phones) {
        List<String> data = new ArrayList<>();
        for (String value : phones) {
            if (!value.equals("")) {
                String[] s = value.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }

                data.add(stringData.toString());
            }
        }

        List<Phone> phonesList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Phone phone = new Phone(Long.parseLong(data.get(index)));
                phone.setModel(data.get(++index));
                phone.setDisplayType(data.get(++index));
                phone.setDisplaySize(data.get(++index));
                phone.setDisplayResolution(data.get(++index));
                phone.setDisplayProtection(data.get(++index));
                phone.setPlatformOS(data.get(++index));
                phone.setPlatformCPU(data.get(++index));
                phone.setPlatformGPU(data.get(++index));
                phone.setPlatformChipset(data.get(++index));
                phone.setMemory(Integer.parseInt(data.get(++index)));
                phone.setRam(Integer.parseInt(data.get(++index)));
                phone.setMainCamera(data.get(++index));
                phone.setFrontalCamera(data.get(++index));
                phone.setBattery(data.get(++index));
                phone.setPower(data.get(++index));
                phone.setPowerConsumption(data.get(++index));
                phone.setYear(Integer.parseInt(data.get(++index)));
                phone.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                phonesList.add(phone);
            }
        }

        return phonesList;
    }

    public static List<Computer> readComputersFile(List<String> computers) {
        List<String> data = new ArrayList<>();
        for (String value : computers) {
            if (!value.equals("")) {
                String[] s = value.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }

                data.add(stringData.toString());
            }
        }

        List<Computer> computerList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Computer computer = new Computer(Long.parseLong(data.get(index)));
                computer.setModel(data.get(++index));
                computer.setProcessorModel(data.get(++index));
                computer.setVideoCard(data.get(++index));
                computer.setOperatingSystem(data.get(++index));
                computer.setStorageCapacity(Integer.parseInt(data.get(++index)));
                computer.setStorageType(data.get(++index));
                computer.setRam(Integer.parseInt(data.get(++index)));
                computer.setPower(data.get(++index));
                computer.setPowerConsumption(data.get(++index));
                computer.setYear(Integer.parseInt(data.get(++index)));
                computer.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                computerList.add(computer);
            }
        }

        return computerList;
    }

    public static List<Laptop> readLaptopsFile(List<String> laptops) {
        List<String> data = new ArrayList<>();
        for (String value : laptops) {
            if (!value.equals("")) {
                String[] s = value.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }
                data.add(stringData.toString());
            }
        }

        List<Laptop> laptopList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Laptop laptop = new Laptop(Long.parseLong(data.get(index)));
                laptop.setModel(data.get(++index));
                laptop.setScreenSize(data.get(++index));
                laptop.setScreenResolution(data.get(++index));
                laptop.setColor(data.get(++index));
                laptop.setTouchScreen(data.get(++index).equals("yes") ? true : false);
                laptop.setBuiltInMicrophone(data.get(++index));
                laptop.setBuiltInWebCam(data.get(++index));
                laptop.setBuiltInSpeaker(data.get(++index));
                laptop.setBluetoothType(data.get(++index));
                laptop.setWifiType(data.get(++index));
                laptop.setWeight(Double.parseDouble(data.get(++index)));
                laptop.setProcessorModel(data.get(++index));
                laptop.setVideoCard(data.get(++index));
                laptop.setOperatingSystem(data.get(++index));
                laptop.setStorageCapacity(Integer.parseInt(data.get(++index)));
                laptop.setStorageType(data.get(++index));
                laptop.setRam(Integer.parseInt(data.get(++index)));
                laptop.setPower(data.get(++index));
                laptop.setPowerConsumption(data.get(++index));
                laptop.setYear(Integer.parseInt(data.get(++index)));
                laptop.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                laptopList.add(laptop);
            }
        }

        return laptopList;
    }

    public static List<Tv> readTvsFile(List<String> tvs) {
        List<String> data = new ArrayList<>();
        for (String tv : tvs) {
            if (!tv.equals("")) {
                String[] s = tv.split(" ");
                StringBuilder stringData = new StringBuilder();
                for (int j = 1; j < s.length; j++) {
                    if (s.length == 2) {
                        stringData.append(s[j]);
                    }
                    if (j < s.length - 1) {
                        stringData.append(s[j]).append(" ");
                    }
                    if (j == s.length - 1 && s.length > 2) {
                        stringData.append(s[j]);
                    }
                }

                data.add(stringData.toString());
            }
        }

        List<Tv> tvsList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Tv laptop = new Tv(Long.parseLong(data.get(index)));
                laptop.setModel(data.get(++index));
                laptop.setScreenType(data.get(++index));
                laptop.setScreenSize(data.get(++index));
                laptop.setResolution(data.get(++index));
                laptop.setFeatures3dOrSmart(data.get(++index));
                laptop.setRefreshRate(Integer.parseInt(data.get(++index)));
                laptop.setTechnologies3d(data.get(++index));
                laptop.setPower(data.get(++index));
                laptop.setPowerConsumption(data.get(++index));
                laptop.setYear(Integer.parseInt(data.get(++index)));
                laptop.setPrice(Double.parseDouble(data.get(++index)));
                index++;
                tvsList.add(laptop);
            }
        }

        return tvsList;
    }
}
