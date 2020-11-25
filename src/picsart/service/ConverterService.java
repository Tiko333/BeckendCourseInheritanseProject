package picsart.service;

import picsart.model.camera.Camera;
import picsart.model.cellPhone.Phone;
import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;
import picsart.model.tv.Tv;
import picsart.model.videoGameConsole.Console;

public class ConverterService {

    private ConverterService() {
    }

    public static Console[] readConsolesFile(String[] consoles) {
        String[] data = new String[consoles.length];
        int count = 0;
        for (int i = 0; i < consoles.length; i++) {
            if (consoles[i].equals("")) {
                count++;
            }
            if (!consoles[i].equals("")) {
                String[] s = consoles[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Console[] consolesArray = new Console[count];
        int index = 0;
        for (int i = 0; i < consolesArray.length; i++) {
            Console console = new Console(Long.parseLong(data[index]));
            console.setModel(data[++index]);
            console.setProcessor(data[++index]);
            console.setMemory(data[++index]);
            console.setStorage(data[++index]);
            console.setDrive(data[++index]);
            console.setAVoutput(data[++index]);
            console.setWeight(Double.parseDouble(data[++index]));
            console.setPower(data[++index]);
            console.setPowerConsumption(data[++index]);
            console.setYear(Integer.parseInt(data[++index]));
            console.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            consolesArray[i] = console;
        }

        return consolesArray;
    }

    public static Camera[] readCamerasFile(String[] cameras) {
        String[] data = new String[cameras.length];
        int count = 0;
        for (int i = 0; i < cameras.length; i++) {
            if (cameras[i].equals("")) {
                count++;
            }
            if (!cameras[i].equals("")) {
                String[] s = cameras[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Camera[] camerasArray = new Camera[count];
        int index = 0;
        for (int i = 0; i < camerasArray.length; i++) {
            Camera camera = new Camera(Long.parseLong(data[index]));
            camera.setModel(data[++index]);
            camera.setMegapixels(data[++index]);
            camera.setPixelDimensions(data[++index]);
            camera.setPixelSize(data[++index]);
            camera.setSensorSize(data[++index]);
            camera.setAspectRatio(data[++index]);
            camera.setImageProcessor(data[++index]);
            camera.setSensorStabilization(data[++index].equals("have") ? true : false);
            camera.setPower(data[++index]);
            camera.setPowerConsumption(data[++index]);
            camera.setYear(Integer.parseInt(data[++index]));
            camera.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            camerasArray[i] = camera;
        }

        return camerasArray;
    }

    public static Phone[] readPhonesFile(String[] phones) {
        String[] data = new String[phones.length];
        int count = 0;
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].equals("")) {
                count++;
            }
            if (!phones[i].equals("")) {
                String[] s = phones[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Phone[] phonesArray = new Phone[count];
        int index = 0;
        for (int i = 0; i < phonesArray.length; i++) {
            Phone phone = new Phone(Long.parseLong(data[index]));
            phone.setModel(data[++index]);
            phone.setDisplayType(data[++index]);
            phone.setDisplaySize(data[++index]);
            phone.setDisplayResolution(data[++index]);
            phone.setDisplayProtection(data[++index]);
            phone.setPlatformOS(data[++index]);
            phone.setPlatformCPU(data[++index]);
            phone.setPlatformGPU(data[++index]);
            phone.setPlatformChipset(data[++index]);
            phone.setMemory(Integer.parseInt(data[++index]));
            phone.setRam(Integer.parseInt(data[++index]));
            phone.setMainCamera(data[++index]);
            phone.setFrontalCamera(data[++index]);
            phone.setBattery(data[++index]);
            phone.setPower(data[++index]);
            phone.setPowerConsumption(data[++index]);
            phone.setYear(Integer.parseInt(data[++index]));
            phone.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            phonesArray[i] = phone;
        }

        return phonesArray;
    }

    public static Computer[] readComputersFile(String[] computers) {
        String[] data = new String[computers.length];
        int count = 0;
        for (int i = 0; i < computers.length; i++) {
            if (computers[i].equals("")) {
                count++;
            }
            if (!computers[i].equals("")) {
                String[] s = computers[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Computer[] computerArray = new Computer[count];
        int index = 0;
        for (int i = 0; i < computerArray.length; i++) {
            Computer computer = new Computer(Long.parseLong(data[index]));
            computer.setModel(data[++index]);
            computer.setProcessorModel(data[++index]);
            computer.setVideoCard(data[++index]);
            computer.setOperatingSystem(data[++index]);
            computer.setStorageCapacity(Integer.parseInt(data[++index]));
            computer.setStorageType(data[++index]);
            computer.setRam(Integer.parseInt(data[++index]));
            computer.setPower(data[++index]);
            computer.setPowerConsumption(data[++index]);
            computer.setYear(Integer.parseInt(data[++index]));
            computer.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            computerArray[i] = computer;
        }

        return computerArray;
    }

    public static Laptop[] readLaptopsFile(String[] laptops) {
        String[] data = new String[laptops.length];
        int count = 0;
        for (int i = 0; i < laptops.length; i++) {
            if (laptops[i].equals("")) {
                count++;
            }
            if (!laptops[i].equals("")) {
                String[] s = laptops[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Laptop[] laptopArray = new Laptop[count];
        int index = 0;
        for (int i = 0; i < laptopArray.length; i++) {
            Laptop laptop = new Laptop(Long.parseLong(data[index]));
            laptop.setModel(data[++index]);
            laptop.setScreenSize(data[++index]);
            laptop.setScreenResolution(data[++index]);
            laptop.setColor(data[++index]);
            laptop.setTouchScreen(data[++index].equals("yes") ? true : false);
            laptop.setBuiltInMicrophone(data[++index]);
            laptop.setBuiltInWebCam(data[++index]);
            laptop.setBuiltInSpeaker(data[++index]);
            laptop.setBluetoothType(data[++index]);
            laptop.setWifiType(data[++index]);
            laptop.setWeight(Double.parseDouble(data[++index]));
            laptop.setProcessorModel(data[++index]);
            laptop.setVideoCard(data[++index]);
            laptop.setOperatingSystem(data[++index]);
            laptop.setStorageCapacity(Integer.parseInt(data[++index]));
            laptop.setStorageType(data[++index]);
            laptop.setRam(Integer.parseInt(data[++index]));
            laptop.setPower(data[++index]);
            laptop.setPowerConsumption(data[++index]);
            laptop.setYear(Integer.parseInt(data[++index]));
            laptop.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            laptopArray[i] = laptop;
        }

        return laptopArray;
    }

    public static Tv[] readTvsFile(String[] tvs) {
        String[] data = new String[tvs.length];
        int count = 0;
        for (int i = 0; i < tvs.length; i++) {
            if (tvs[i].equals("")) {
                count++;
            }
            if (!tvs[i].equals("")) {
                String[] s = tvs[i].split(" ");
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

                data[i] = stringData.toString();
            }
        }

        Tv[] tvsArray = new Tv[count];
        int index = 0;
        for (int i = 0; i < tvsArray.length; i++) {
            Tv laptop = new Tv(Long.parseLong(data[index]));
            laptop.setModel(data[++index]);
            laptop.setScreenType(data[++index]);
            laptop.setScreenSize(data[++index]);
            laptop.setResolution(data[++index]);
            laptop.setFeatures3dOrSmart(data[++index]);
            laptop.setRefreshRate(Integer.parseInt(data[++index]));
            laptop.setTechnologies3d(data[++index]);
            laptop.setPower(data[++index]);
            laptop.setPowerConsumption(data[++index]);
            laptop.setYear(Integer.parseInt(data[++index]));
            laptop.setPrice(Double.parseDouble(data[++index]));
            index += 2;
            tvsArray[i] = laptop;
        }

        return tvsArray;
    }
}
