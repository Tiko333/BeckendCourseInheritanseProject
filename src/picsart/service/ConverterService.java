package picsart.service;

import picsart.model.camera.Camera;
import picsart.model.cellPhone.Phone;
import picsart.model.coffeeMaker.CoffeeMaker;
import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;
import picsart.model.conditioner.Conditioner;
import picsart.model.microwave.Microwave;
import picsart.model.refrigerator.Refrigerator;
import picsart.model.speaker.Speaker;
import picsart.model.tv.Tv;
import picsart.model.vacuumCleaner.VacuumCleaner;
import picsart.model.videoGameConsole.Console;
import picsart.model.washingMachine.WashingMachine;
import picsart.registration.Role;
import picsart.registration.UserModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConverterService {

    private ConverterService() {
    }

    public static List<UserModel> readRegistrationFile(String path) throws IOException {
        List<String> userLine = Files.readAllLines(Path.of(path));
        List<String> data = new ArrayList<>();
        for (String value : userLine) {
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

        List<UserModel> userModels = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                UserModel user = new UserModel();
                user.setFullName(data.get(index));
                user.setUserName(data.get(++index));
                user.setEmail(data.get(++index));
                user.setPassword(data.get(++index));
                user.setRole(data.get(++index).equals("ADMIN") ? Role.ADMIN : Role.USER);
                user.setLastLogin(data.get(++index));
                user.setCart(data.get(++index));

                index++;
                userModels.add(user);
            }
        }

        return userModels;
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
                console.setDate(data.get(++index));
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
                camera.setSensorStabilization(data.get(++index).equals("have"));
                camera.setPower(data.get(++index));
                camera.setPowerConsumption(data.get(++index));
                camera.setYear(Integer.parseInt(data.get(++index)));
                camera.setPrice(Double.parseDouble(data.get(++index)));
                camera.setDate(data.get(++index));
                index++;
                camerasList.add(camera);
            }
        }

        return camerasList;
    }

    public static List<Refrigerator> readRefrigeratorsFile(List<String> refrigerators) {
        List<String> data = new ArrayList<>();
        for (String value : refrigerators) {
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

        List<Refrigerator> refrigeratorsList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Refrigerator refrigerator = new Refrigerator(Long.parseLong(data.get(index)));
                refrigerator.setModel(data.get(++index));
                refrigerator.setType(data.get(++index));
                refrigerator.setEnergyConsumptionClass(data.get(++index));
                refrigerator.setDimensions(data.get(++index));
                refrigerator.setFreezerPosition(data.get(++index));
                refrigerator.setFreezerVolume(Integer.parseInt(data.get(++index)));
                refrigerator.setTotalVolume(Integer.parseInt(data.get(++index)));
                refrigerator.setRefrigeratorVolume(Integer.parseInt(data.get(++index)));
                refrigerator.setShelfMaterial(data.get(++index));
                refrigerator.setManagement(data.get(++index));
                refrigerator.setColor(data.get(++index));
                refrigerator.setFreshnessChamber(data.get(++index).equals("have"));
                refrigerator.setDeFrost(data.get(++index).equals("have"));
                refrigerator.setNoFrost(data.get(++index).equals("have"));
                refrigerator.setPower(data.get(++index));
                refrigerator.setPowerConsumption(data.get(++index));
                refrigerator.setYear(Integer.parseInt(data.get(++index)));
                refrigerator.setPrice(Double.parseDouble(data.get(++index)));
                refrigerator.setDate(data.get(++index));
                index++;
                refrigeratorsList.add(refrigerator);
            }
        }

        return refrigeratorsList;
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
                phone.setDate(data.get(++index));
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
                computer.setDate(data.get(++index));
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
                laptop.setTouchScreen(data.get(++index).equals("yes"));
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
                laptop.setDate(data.get(++index));
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
                laptop.setDate(data.get(++index));
                index++;
                tvsList.add(laptop);
            }
        }

        return tvsList;
    }

    public static List<Conditioner> readConditionerFile(List<String> conditioners) {
        List<String> data = new ArrayList<>();
        for (String conditioner : conditioners) {
            if (!conditioner.equals("")) {
                String[] s = conditioner.split(" ");
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

        List<Conditioner> tvsList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Conditioner conditioner = new Conditioner(Long.parseLong(data.get(index)));
                conditioner.setModel(data.get(++index));
                conditioner.setType(data.get(++index));
                conditioner.setOperationModes(data.get(++index));
                conditioner.setMaximumWorkingArea(data.get(++index));
                conditioner.setNoiseLevel(data.get(++index));
                conditioner.setSize(data.get(++index));
                conditioner.setColor(data.get(++index));
                conditioner.setPower(data.get(++index));
                conditioner.setPowerConsumption(data.get(++index));
                conditioner.setYear(Integer.parseInt(data.get(++index)));
                conditioner.setPrice(Double.parseDouble(data.get(++index)));
                conditioner.setDate(data.get(++index));
                index++;
                tvsList.add(conditioner);
            }
        }

        return tvsList;
    }

    public static List<WashingMachine> readWashingMachineFile(List<String> washingMachines) {
        List<String> data = new ArrayList<>();
        for (String washingMachine : washingMachines) {
            if (!washingMachine.equals("")) {
                String[] s = washingMachine.split(" ");
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

        List<WashingMachine> washingMachineList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                WashingMachine conditioner = new WashingMachine(Long.parseLong(data.get(index)));
                conditioner.setModel(data.get(++index));
                conditioner.setTypeOfInstallation(data.get(++index));
                conditioner.setDownloadType(data.get(++index));
                conditioner.setMaximumDownload(data.get(++index));
                conditioner.setPrograms(data.get(++index));
                conditioner.setDimensions(data.get(++index));
                conditioner.setDisplay(data.get(++index).equals("have"));
                conditioner.setWeight(Integer.parseInt(data.get(++index)));
                conditioner.setPower(data.get(++index));
                conditioner.setPowerConsumption(data.get(++index));
                conditioner.setYear(Integer.parseInt(data.get(++index)));
                conditioner.setPrice(Double.parseDouble(data.get(++index)));
                conditioner.setDate(data.get(++index));
                index++;
                washingMachineList.add(conditioner);
            }
        }

        return washingMachineList;
    }

    public static List<CoffeeMaker> readCoffeeMakersFile(List<String> coffeeMakers) {
        List<String> data = new ArrayList<>();
        for (String coffeeMaker : coffeeMakers) {
            if (!coffeeMaker.equals("")) {
                String[] s = coffeeMaker.split(" ");
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


        List<CoffeeMaker> coffeeMakerList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                CoffeeMaker conditioner = new CoffeeMaker(Long.parseLong(data.get(index)));
                conditioner.setModel(data.get(++index));
                conditioner.setCoffeeType(data.get(++index));
                conditioner.setCapacity(data.get(++index));
                conditioner.setMaterialOfCorpus(data.get(++index));
                conditioner.setColor(data.get(++index));
                conditioner.setWeight(Double.parseDouble(data.get(++index)));
                conditioner.setPower(data.get(++index));
                conditioner.setPowerConsumption(data.get(++index));
                conditioner.setYear(Integer.parseInt(data.get(++index)));
                conditioner.setPrice(Double.parseDouble(data.get(++index)));
                conditioner.setDate(data.get(++index));
                index++;
                coffeeMakerList.add(conditioner);
            }
        }

        return coffeeMakerList;
    }

    public static List<VacuumCleaner> readVacuumCleanersFile(List<String> vacuumCleaners) {
        List<String> data = new ArrayList<>();
        for (String vacuumCleaner : vacuumCleaners) {
            if (!vacuumCleaner.equals("")) {
                String[] s = vacuumCleaner.split(" ");
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


        List<VacuumCleaner> vacuumCleanerList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                VacuumCleaner vacuumCleaner = new VacuumCleaner(Long.parseLong(data.get(index)));
                vacuumCleaner.setModel(data.get(++index));
                vacuumCleaner.setType(data.get(++index));
                vacuumCleaner.setPipeType(data.get(++index));
                vacuumCleaner.setDustCollector(data.get(++index));
                vacuumCleaner.setTypeOfManagement(data.get(++index));
                vacuumCleaner.setColor(data.get(++index));
                vacuumCleaner.setFloorAndCarpetKnob(data.get(++index).equals("have"));
                vacuumCleaner.setSoftFurnitureKnob(data.get(++index).equals("have"));
                vacuumCleaner.setCornersKnob(data.get(++index).equals("have"));
                vacuumCleaner.setPower(data.get(++index));
                vacuumCleaner.setPowerConsumption(data.get(++index));
                vacuumCleaner.setYear(Integer.parseInt(data.get(++index)));
                vacuumCleaner.setPrice(Double.parseDouble(data.get(++index)));
                vacuumCleaner.setDate(data.get(++index));
                index++;
                vacuumCleanerList.add(vacuumCleaner);
            }
        }

        return vacuumCleanerList;
    }

    public static List<Microwave> readMicrowavesFile(List<String> microwaves) {
        List<String> data = new ArrayList<>();
        for (String microwave : microwaves) {
            if (!microwave.equals("")) {
                String[] s = microwave.split(" ");
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


        List<Microwave> microwaveList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Microwave microwave = new Microwave(Long.parseLong(data.get(index)));
                microwave.setModel(data.get(++index));
                microwave.setOvenCapacity(data.get(++index));
                microwave.setControl(data.get(++index));
                microwave.setSwitches(data.get(++index));
                microwave.setDimension(data.get(++index));
                microwave.setWeight(Double.parseDouble(data.get(++index)));
                microwave.setScreen(data.get(++index).equals("have"));
                microwave.setPower(data.get(++index));
                microwave.setPowerConsumption(data.get(++index));
                microwave.setYear(Integer.parseInt(data.get(++index)));
                microwave.setPrice(Double.parseDouble(data.get(++index)));
                microwave.setDate(data.get(++index));
                index++;
                microwaveList.add(microwave);
            }
        }

        return microwaveList;
    }

    public static List<Speaker> readSpeakersFile(List<String> speakers) {
        List<String> data = new ArrayList<>();
        for (String speaker : speakers) {
            if (!speaker.equals("")) {
                String[] s = speaker.split(" ");
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


        List<Speaker> microwaveList = new LinkedList<>();
        int index = 0;
        for (int i = 0; i < data.size(); i++) {
            if (index < data.size()) {
                Speaker microwave = new Speaker(Long.parseLong(data.get(index)));
                microwave.setModel(data.get(++index));
                microwave.setFrequency(data.get(++index));
                microwave.setInterfaceType(data.get(++index));
                microwave.setPower(data.get(++index));
                microwave.setPowerConsumption(data.get(++index));
                microwave.setYear(Integer.parseInt(data.get(++index)));
                microwave.setPrice(Double.parseDouble(data.get(++index)));
                microwave.setDate(data.get(++index));
                index++;
                microwaveList.add(microwave);
            }
        }

        return microwaveList;
    }
}
