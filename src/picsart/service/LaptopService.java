package picsart.service;

import picsart.comparators.laptopComparators.CostComparator;
import picsart.comparators.laptopComparators.YearComparator;
import picsart.model.computer.Laptop;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LaptopService {
    private static final String FILE_PATH = "src/picsart/files/laptops.txt";

    public static Laptop create() throws IOException {
        System.out.println("Create laptop:\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter screen size:");
        String screenSize = scanner.nextLine();
        while (screenSize.equals("")) {
            System.out.println("Screen size have not to be blank: ");
            screenSize = scanner.nextLine();
        }
        System.out.println("Enter screen resolution:");
        String screenResolution = scanner.nextLine();
        while (screenResolution.equals("")) {
            System.out.println("Screen resolution have not to be blank: ");
            screenResolution = scanner.nextLine();
        }
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        while (color.equals("")) {
            System.out.println("color have not to be blank: ");
            color = scanner.nextLine();
        }
        System.out.println("Enter built in microphone:");
        String builtInMicrophone = scanner.nextLine();
        while (builtInMicrophone.equals("")) {
            System.out.println("Built in microphone have not to be blank: ");
            builtInMicrophone = scanner.nextLine();
        }
        System.out.println("Enter built in webcam:");
        String builtInWebCam = scanner.nextLine();
        while (builtInWebCam.equals("")) {
            System.out.println("Built in webcam have not to be blank: ");
            builtInWebCam = scanner.nextLine();
        }
        System.out.println("Enter built in speaker:");
        String builtInSpeaker = scanner.nextLine();
        while (builtInSpeaker.equals("")) {
            System.out.println("Built in speaker have not to be blank: ");
            builtInSpeaker = scanner.nextLine();
        }
        System.out.println("Enter bluetooth type:");
        String bluetoothType = scanner.nextLine();
        while (bluetoothType.equals("")) {
            System.out.println("Bluetooth type have not to be blank: ");
            bluetoothType = scanner.nextLine();
        }
        System.out.println("Enter wifi type:");
        String wifiType = scanner.nextLine();
        while (wifiType.equals("")) {
            System.out.println("Wifi type have not to be blank: ");
            wifiType = scanner.nextLine();
        }
        System.out.println("Enter is touch screen 'yes' or 'no':");
        boolean isTouchScreen = false;
        String touchScreen = scanner.nextLine();
        while (!touchScreen.equals("yes") && !touchScreen.equals("no")) {
            System.out.println("Touch screen have not to be blank insert 'yes' or 'no': ");
            touchScreen = scanner.nextLine();
        }
        if (touchScreen.equals("yes")) {
            isTouchScreen = true;
        }
        System.out.println("Enter processor model:");
        String processorModel = scanner.nextLine();
        while (processorModel.equals("")) {
            System.out.println("Name of the processor model have not to be blank: ");
            processorModel = scanner.nextLine();
        }
        System.out.println("Enter operating system:");
        String operatingSystem = scanner.nextLine();
        while (operatingSystem.equals("")) {
            System.out.println("Platform OS have not to be blank: ");
            operatingSystem = scanner.nextLine();
        }
        System.out.println("Enter video card:");
        String videoCard = scanner.nextLine();
        while (videoCard.equals("")) {
            System.out.println("Platform GPU have not to be blank: ");
            videoCard = scanner.nextLine();
        }
        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();
        while (powerConsumption.equals("")) {
            System.out.println("Power consumption have not to be blank: ");
            powerConsumption = scanner.nextLine();
        }
        System.out.println("Enter power:");
        String power = scanner.nextLine();
        while (power.equals("")) {
            System.out.println("Power have not to be blank: ");
            power = scanner.nextLine();
        }
        System.out.println("Enter storage type:");
        String storageType = scanner.nextLine();
        while (storageType.equals("")) {
            System.out.println("Storage type have not to be blank: ");
            storageType = scanner.nextLine();
        }
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        while (price <= 0) {
            System.out.println("Price must be bigger than 0: ");
            price = scanner.nextDouble();
        }
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        while (weight <= 0) {
            System.out.println("weight must be bigger than 0: ");
            weight = scanner.nextDouble();
        }
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        while (year < 2000 || year > 2020) {
            System.out.println("Year must be bigger than 2000 and smaller than 2020: ");
            year = scanner.nextInt();
        }
        System.out.println("Enter storage capacity:");
        int storageCapacity = scanner.nextInt();
        while (storageCapacity <= 0) {
            System.out.println("Storage capacity must be bigger than 0: ");
            storageCapacity = scanner.nextInt();
        }
        System.out.println("Enter ram:");
        int ram = scanner.nextInt();
        while (ram < 1) {
            System.out.println("Ram must be bigger than 1: ");
            ram = scanner.nextInt();
        }

        Laptop laptop = new Laptop(IDGenerator.generateID(9));
        laptop.setWifiType(wifiType);
        laptop.setTouchScreen(isTouchScreen);
        laptop.setScreenSize(screenSize);
        laptop.setScreenResolution(screenResolution);
        laptop.setBuiltInWebCam(builtInWebCam);
        laptop.setBuiltInSpeaker(builtInSpeaker);
        laptop.setBuiltInWebCam(builtInWebCam);
        laptop.setBuiltInMicrophone(builtInMicrophone);
        laptop.setBluetoothType(bluetoothType);
        laptop.setOperatingSystem(operatingSystem);
        laptop.setProcessorModel(processorModel);
        laptop.setRam(ram);
        laptop.setStorageCapacity(storageCapacity);
        laptop.setStorageType(storageType);
        laptop.setVideoCard(videoCard);
        laptop.setModel(model);
        laptop.setPower(power);
        laptop.setPowerConsumption(powerConsumption);
        laptop.setPrice(price);
        laptop.setYear(year);

        writeIntoFile(laptop);
        return laptop;
    }

    public static List<Laptop> createLaptops(int size) throws IOException {
        List<Laptop> laptops = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating laptop number: " + (i + 1));
            laptops.add(create());
        }

        return laptops;
    }

    public static Laptop findById(long id) throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        for (Laptop laptop : laptops) {
            if (laptop.getId() == id) {
                System.out.println(laptop.toString());
                return laptop;
            }
        }

        System.out.println("Laptop by ID: " + id + " does not exist:");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        boolean isFound = false;
        for (int i = 0; i < laptops.size(); i++) {
            Laptop laptop = laptops.get(i);
            if (laptop.getModel().equals(model)) {
                System.out.println(laptop.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == laptops.size() - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no laptop by model: " + model);
        }
    }

    public static List<Laptop> findByPrice(double from, double to) throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        int nullCounter = 0;
        for (Laptop laptop : laptops) {
            if (laptop.getPrice() < from || laptop.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == laptops.size()) {
            System.out.println("Laptops by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Laptop> selectedLaptopsByPriceRange = new LinkedList<>();
        for (Laptop laptop : laptops) {
            double price = laptop.getPrice();
            if (price >= from && price <= to) {
                selectedLaptopsByPriceRange.add(laptop);
            }
        }

        printAll(selectedLaptopsByPriceRange);
        return selectedLaptopsByPriceRange;
    }

    public static Laptop newerLaptop() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        Laptop max = Collections.max(laptops, new YearComparator());
        printLaptop(max);
        return max;
    }

    public static Laptop olderLaptop() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        Laptop min = Collections.min(laptops, new YearComparator());
        printLaptop(min);
        return min;
    }

    public static Laptop biggerCost() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        Laptop max = Collections.max(laptops, new CostComparator());
        printLaptop(max);
        return max;
    }

    public static Laptop smallerCost() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        Laptop min = Collections.min(laptops, new CostComparator());
        printLaptop(min);
        return min;
    }

    public static List<Laptop> ascendingOrderByPrice() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        laptops.sort(new CostComparator());
        printAll(laptops);
        return laptops;
    }

    public static List<Laptop> descendingOrderByPrice() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        laptops.sort(new CostComparator().reversed());
        printAll(laptops);
        return laptops;
    }

    public static List<Laptop> ascendingOrderByYear() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        laptops.sort(new YearComparator());
        printAll(laptops);
        return laptops;
    }

    public static List<Laptop> descendingOrderByYear() throws IOException {
        List<Laptop> laptops = readLaptopsFromFile();
        laptops.sort(new YearComparator().reversed());
        printAll(laptops);
        return laptops;
    }

    public static List<Laptop> readLaptopsFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(FILE_PATH));

        return ConverterService.readLaptopsFile(strings);
    }

    private static void writeIntoFile(Laptop laptop) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + laptop.getId())
                .append("\nMotherBoard-model: " + laptop.getModel())
                .append("\nScreen-size: " + laptop.getScreenSize())
                .append("\nScreen-resolution: " + laptop.getScreenResolution())
                .append("\nColor: " + laptop.getColor())
                .append("\nTouchScreen: " + (laptop.isTouchScreen() ? "yes" : " no"))
                .append("\nBuiltInMicrophone: " + laptop.getBuiltInMicrophone())
                .append("\nBuiltInWebCam: " + laptop.getBuiltInWebCam())
                .append("\nBuiltInSpeaker: " + laptop.getBuiltInSpeaker())
                .append("\nBluetooth-type: " + laptop.getBluetoothType())
                .append("\nWifi-type: " + laptop.getWifiType())
                .append("\nWeight: " + laptop.getWeight())
                .append("\nCPU-model: " + laptop.getProcessorModel())
                .append("\nGPU-model: " + laptop.getVideoCard())
                .append("\nOperating-system: " + laptop.getOperatingSystem())
                .append("\nStorage-capacity: " + laptop.getStorageCapacity())
                .append("\nStorage-type: " + laptop.getStorageType())
                .append("\nRam: " + laptop.getRam())
                .append("\nPower: " + laptop.getPower())
                .append("\nPower-consumption: " + laptop.getPowerConsumption())
                .append("\nYear: " + laptop.getYear())
                .append("\nPrice: " + laptop.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Laptop> laptops) throws IOException {
        if (laptops == null) {
            laptops = readLaptopsFromFile();
            for (Laptop laptop : laptops) {
                System.out.println(laptop.toString());
            }
            return;
        }
        for (Laptop laptop : laptops) {
            System.out.println(laptop.toString());
        }
    }

    public static void printLaptop(Laptop laptop) {
        System.out.println(laptop.toString());
    }
}
