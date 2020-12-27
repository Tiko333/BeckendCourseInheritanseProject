package picsart.service;

import picsart.comparators.laptopComparators.CostComparator;
import picsart.comparators.laptopComparators.DateComparator;
import picsart.comparators.laptopComparators.YearComparator;
import picsart.model.computer.Computer;
import picsart.model.computer.Laptop;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class LaptopService {
    private static String path = FilePaths.LAPTOP.getValue();
    private static Set<Laptop> laptopSet;

    static {
        try {
            laptopSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LaptopService() {}

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
        laptopSet.add(laptop);
        return laptop;
    }

    public static List<Laptop> multipleCreate(int size) throws IOException {
        List<Laptop> laptops = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating laptop number: " + (i + 1));
            laptops.add(create());
        }

        return laptops;
    }

    public static void updateById(int id) throws IOException {
        Laptop laptop = findById(id);
        if (laptop == null) {
            return;
        }
        deleteById(id);
        laptopSet.remove(laptop);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter processor model:");
        String processorModel = scanner.nextLine();

        System.out.println("Enter video card:");
        String videoCard = scanner.nextLine();

        System.out.println("Enter operating system:");
        String operatingSystem = scanner.nextLine();

        System.out.println("Enter storage type:");
        String storageType = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter screen size:");
        String screenSize = scanner.nextLine();

        System.out.println("Enter screen resolution:");
        String screenResolution = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter touch screen 'yes' or 'no':");
        boolean isHaveTouchScreen = false;
        String isTouchScreen = scanner.nextLine();
        while (!isTouchScreen.equals("yes") && !isTouchScreen.equals("no")) {
            System.out.println("sensor stabilization have not to be blank insert 'yes' or 'no': ");
            isTouchScreen = scanner.nextLine();
        }
        if (isTouchScreen.equals("yes")) {
            isHaveTouchScreen = true;
        }

        System.out.println("Enter built in microphone:");
        String builtInMicrophone = scanner.nextLine();

        System.out.println("Enter built in webcam:");
        String builtInWebCam = scanner.nextLine();

        System.out.println("Enter built in speaker:");
        String builtInSpeaker = scanner.nextLine();

        System.out.println("Enter bluetooth Type:");
        String bluetoothType = scanner.nextLine();

        System.out.println("Enter wifi type:");
        String wifiType = scanner.nextLine();

        System.out.println("Enter weight 0 to skip:");
        double weight = scanner.nextDouble();

        System.out.println("Enter storage capacity 0 to skip:");
        int storageCapacity = scanner.nextInt();

        System.out.println("Enter ram 0 to skip:");
        int ram = scanner.nextInt();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!processorModel.equals("")) {
            laptop.setProcessorModel(processorModel);
        }
        if (!videoCard.equals("")) {
            laptop.setVideoCard(videoCard);
        }
        if (!operatingSystem.equals("")) {
            laptop.setOperatingSystem(operatingSystem);
        }
        if (!storageType.equals("")) {
            laptop.setStorageType(storageType);
        }
        if (!model.equals("")) {
            laptop.setModel(model);
        }
        if (ram > 1) {
            laptop.setRam(ram);
        }
        if (!power.equals("")) {
            laptop.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            laptop.setPowerConsumption(powerConsumption);
        }
        if (!model.equals("")) {
            laptop.setModel(model);
        }
        if (storageCapacity > 1) {
            laptop.setStorageCapacity(storageCapacity);
        }
        if (price > 0) {
            laptop.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            laptop.setYear(year);
        }
        if (!screenSize.equals("")) {
            laptop.setScreenSize(screenSize);
        }
        if (!screenResolution.equals("")) {
            laptop.setScreenResolution(screenResolution);
        }
        if (!color.equals("")) {
            laptop.setColor(color);
        }
        laptop.setTouchScreen(isHaveTouchScreen);
        if (!builtInMicrophone.equals("")) {
            laptop.setBuiltInMicrophone(builtInMicrophone);
        }
        if (!model.equals("")) {
            laptop.setModel(model);
        }
        if (!builtInWebCam.equals("")) {
            laptop.setBuiltInWebCam(builtInWebCam);
        }
        if (!builtInSpeaker.equals("")) {
            laptop.setBuiltInSpeaker(builtInSpeaker);
        }
        if (!bluetoothType.equals("")) {
            laptop.setBluetoothType(bluetoothType);
        }
        if (!wifiType.equals("")) {
            laptop.setWifiType(wifiType);
        }
        if (weight > 1) {
            laptop.setWeight(weight);
        }

        writeIntoFile(laptop);
        laptopSet.add(laptop);
    }

    public static boolean checkId(int id) {
        Iterator<Laptop> iterator = laptopSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Laptop next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Laptop by id " + id + " does not exist:");
            return false;
        }
        List<String> strings = Files.readAllLines(Path.of(path));
        int begin = 0;
        int end = 0;
        int interval = 0;
        for (String string : strings) {
            interval++;
            if (string.equals("")) {
                break;
            }
        }

        for (int i = 0; i < strings.size(); i += interval) {
            String[] split = strings.get(i).split(":");
            if (split[0].equals("ID") && Integer.parseInt(split[1].substring(1)) == id) {
                begin = i;
                end = begin + (interval - 1);
                break;
            }
        }

        Iterator<String> iterator = strings.iterator();
        int cursor = 0;
        while (cursor != begin) {
            iterator.next();
            cursor++;
        }

        int counter = begin;
        while (counter <= end) {
            if (counter == 0) {
                iterator.next();
            }
            if (counter >= begin) {
                iterator.remove();
            }
            iterator.next();
            counter++;
        }

        Iterator<Laptop> laptopSetIterator = laptopSet.iterator();
        while (laptopSetIterator.hasNext()) {
            Computer next = laptopSetIterator.next();
            if (next.getId() == id) {
                laptopSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Laptop> laptops = ConverterService.readLaptopsFile(strings);
        for (Laptop laptop : laptops) {
            writeIntoFile(laptop);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        laptopSet.clear();
    }

    public static Laptop findById(long id) throws IOException {
        for (Laptop laptop : readFromFile()) {
            if (laptop.getId() == id) {
                return laptop;
            }
        }

        System.out.println("Laptop by ID: " + id + " does not exist:");
        return null;
    }

    public static List<Laptop> findByModel(List<Laptop> laptops, String model) throws IOException {
        List<Laptop> laptopList;
        if (laptops == null) {
            laptopList = readFromFile();
        } else {
            laptopList = laptops;
        }
        List<Laptop> byModel = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            if (laptop.getModel().equals(model)) {
                byModel.add(laptop);
            }
        }

        return byModel;
    }

    public static List<Laptop> findByPrice(List<Laptop> laptops, double from, double to) throws IOException {
        List<Laptop> laptopList;
        if (laptops == null) {
            laptopList = readFromFile();
        } else {
            laptopList = laptops;
        }
        int nullCounter = 0;
        for (Laptop laptop : laptopList) {
            if (laptop.getPrice() < from || laptop.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == laptopList.size()) {
            System.out.println("Laptops by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Laptop> byPriceRange = new LinkedList<>();
        for (Laptop laptop : laptopList) {
            double price = laptop.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(laptop);
            }
        }

        return byPriceRange;
    }

    public static List<Laptop> findByYear(List<Laptop> laptops, int year) throws IOException {
        List<Laptop> laptopList;
        if (laptops == null) {
            laptopList = readFromFile();
        } else {
            laptopList = laptops;
        }
        List<Laptop> byYear = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            if (laptop.getYear() == year) {
                byYear.add(laptop);
            }
        }

        return byYear;
    }

    public static List<Laptop> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Laptop> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Laptop> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Laptop> findByAddingDate(List<Laptop> laptops, String date) throws IOException {
        List<Laptop> laptopList;
        if (laptops == null) {
            laptopList = readFromFile();
        } else {
            laptopList = laptops;
        }
        List<Laptop> byAddingDate = new ArrayList<>();
        for (Laptop laptop : laptopList) {
            String cameraDate = laptop.getDate().substring(0, laptop.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(laptop);
            }
        }

        return byAddingDate;
    }

    public static Laptop newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Laptop older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Laptop biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Laptop smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Laptop newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Laptop olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Laptop> ascendingOrderByPrice() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new CostComparator());
        return laptops;
    }

    public static List<Laptop> descendingOrderByPrice() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new CostComparator().reversed());
        return laptops;
    }

    public static List<Laptop> ascendingOrderByYear() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new YearComparator());
        return laptops;
    }

    public static List<Laptop> descendingOrderByYear() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new YearComparator().reversed());
        return laptops;
    }

    public static List<Laptop> ascendingOrderByAddingDate() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new DateComparator());
        return laptops;
    }

    public static List<Laptop> descendingOrderByAddingDate() throws IOException {
        List<Laptop> laptops = readFromFile();
        laptops.sort(new DateComparator(true));
        return laptops;
    }

    public static List<Laptop> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
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
                .append("\nPrice: " + laptop.getPrice())
                .append("\nDate: " + laptop.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Laptop> laptops) throws IOException {
        if (laptops == null) {
            laptops = readFromFile();
            for (Laptop laptop : laptops) {
                System.out.println(laptop.toString());
            }
            return;
        }
        if (!laptops.isEmpty()) {
            for (Laptop laptop : laptops) {
                print(laptop);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Laptop laptop) {
        System.out.println(laptop.toString());
    }
}
