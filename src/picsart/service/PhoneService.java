package picsart.service;

import picsart.comparators.phoneComparators.CostComparator;
import picsart.comparators.phoneComparators.YearComparator;
import picsart.model.cellPhone.Phone;
import picsart.model.computer.Computer;

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

public class PhoneService {
    private static final String FILE_PATH = "src/picsart/files/phones.txt";

    public static Phone create() throws IOException {
        System.out.println("Create phone:\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter display type:");
        String displayType = scanner.nextLine();
        while (displayType.equals("")) {
            System.out.println("Display type have not to be blank: ");
            displayType = scanner.nextLine();
        }
        System.out.println("Enter display size:");
        String displaySize = scanner.nextLine();
        while (displaySize.equals("")) {
            System.out.println("Display size have not to be blank: ");
            displaySize = scanner.nextLine();
        }
        System.out.println("Enter display resolution:");
        String displayResolution = scanner.nextLine();
        while (displayResolution.equals("")) {
            System.out.println("Display resolution have not to be blank: ");
            displayResolution = scanner.nextLine();
        }
        System.out.println("Enter display protection:");
        String displayProtection = scanner.nextLine();
        while (displayProtection.equals("")) {
            System.out.println("Display protection have not to be blank: ");
            displayProtection = scanner.nextLine();
        }
        System.out.println("Enter platform chipset:");
        String platformChipset = scanner.nextLine();
        while (platformChipset.equals("")) {
            System.out.println("Platform chipset have not to be blank: ");
            platformChipset = scanner.nextLine();
        }
        System.out.println("Enter main camera:");
        String mainCamera = scanner.nextLine();
        while (mainCamera.equals("")) {
            System.out.println("Main camera have not to be blank: ");
            mainCamera = scanner.nextLine();
        }
        System.out.println("Enter frontal camera:");
        String frontalCamera = scanner.nextLine();
        while (frontalCamera.equals("")) {
            System.out.println("Frontal camera have not to be blank: ");
            frontalCamera = scanner.nextLine();
        }
        System.out.println("Enter battery:");
        String battery = scanner.nextLine();
        while (battery.equals("")) {
            System.out.println("Battery have not to be blank: ");
            battery = scanner.nextLine();
        }
        System.out.println("Enter platform CPU:");
        String platformCPU = scanner.nextLine();
        while (platformCPU.equals("")) {
            System.out.println("Name of the platform CPU have not to be blank: ");
            platformCPU = scanner.nextLine();
        }
        System.out.println("Enter platform OS:");
        String platformOS = scanner.nextLine();
        while (platformOS.equals("")) {
            System.out.println("Platform OS have not to be blank: ");
            platformOS = scanner.nextLine();
        }

        System.out.println("Enter platform GPU:");
        String platformGPU = scanner.nextLine();
        while (platformGPU.equals("")) {
            System.out.println("Platform GPU have not to be blank: ");
            platformGPU = scanner.nextLine();
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
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        while (price <= 0) {
            System.out.println("Price must be bigger than 0: ");
            price = scanner.nextDouble();
        }
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        while (year < 2000 || year > 2020) {
            System.out.println("Year must be bigger than 2000 and smaller than 2020: ");
            year = scanner.nextInt();
        }
        System.out.println("Enter memory:");
        int memory = scanner.nextInt();
        while (memory <= 0) {
            System.out.println("Memory must be bigger than 0: ");
            memory = scanner.nextInt();
        }
        System.out.println("Enter ram:");
        int ram = scanner.nextInt();
        while (ram < 1) {
            System.out.println("Ram must be bigger than 1: ");
            ram = scanner.nextInt();
        }

        Phone phone = new Phone(IDGenerator.generateID(9));
        phone.setBattery(battery);
        phone.setFrontalCamera(frontalCamera);
        phone.setMainCamera(mainCamera);
        phone.setMemory(memory);
        phone.setPlatformChipset(platformChipset);
        phone.setPlatformGPU(platformGPU);
        phone.setPlatformCPU(platformCPU);
        phone.setPlatformOS(platformOS);
        phone.setDisplayProtection(displayProtection);
        phone.setDisplayResolution(displayResolution);
        phone.setDisplaySize(displaySize);
        phone.setDisplayType(displayType);
        phone.setRam(ram);
        phone.setModel(model);
        phone.setPower(power);
        phone.setPowerConsumption(powerConsumption);
        phone.setPrice(price);
        phone.setYear(year);

        writeIntoFile(phone);
        return phone;
    }

    public static List<Phone> createPhones(int size) throws IOException {
        List<Phone> phones = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating phone number: " + (i + 1));
            phones.add(create());
        }

        return phones;
    }

    public static Phone findById(long id) throws IOException {
        List<Phone> phones = readPhonesFile();
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                System.out.println(phone.toString());
                return phone;
            }
        }

        System.out.println("Phone by ID: " + id + " does not exist:");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        List<Phone> phones = readPhonesFile();
        boolean isFound = false;
        for (int i = 0; i < phones.size(); i++) {
            Phone computer = phones.get(i);
            if (computer.getModel().equals(model)) {
                System.out.println(computer.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == phones.size() - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no phone by model: " + model);
        }
    }

    public static List<Phone> findByPrice(double from, double to) throws IOException {
        List<Phone> phones = readPhonesFile();
        int nullCounter = 0;
        for (Phone phone : phones) {
            if (phone.getPrice() < from || phone.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == phones.size()) {
            System.out.println("Phones by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Phone> selectedPhonesByPriceRange = new LinkedList<>();
        for (Phone phone : phones) {
            double price = phone.getPrice();
            if (price >= from && price <= to) {
                selectedPhonesByPriceRange.add(phone);
            }
        }

        printAll(selectedPhonesByPriceRange);
        return selectedPhonesByPriceRange;
    }

    public static Phone newerPhone() throws IOException {
        List<Phone> phones = readPhonesFile();
        Phone max = Collections.max(phones, new YearComparator());
        printComputer(max);
        return max;
    }

    public static Phone olderPhone() throws IOException {
        List<Phone> phones = readPhonesFile();
        Phone min = Collections.min(phones, new YearComparator());
        printComputer(min);
        return min;
    }

    public static Phone biggerCost() throws IOException {
        List<Phone> phones = readPhonesFile();
        Phone max = Collections.max(phones, new CostComparator());
        printComputer(max);
        return max;
    }

    public static Phone smallerCost() throws IOException {
        List<Phone> phones = readPhonesFile();
        Phone min = Collections.min(phones, new CostComparator());
        printComputer(min);
        return min;
    }

    public static List<Phone> ascendingOrderByPrice() throws IOException {
        List<Phone> phones = readPhonesFile();
        phones.sort(new CostComparator());
        printAll(phones);
        return phones;
    }

    public static List<Phone> descendingOrderByPrice() throws IOException {
        List<Phone> phones = readPhonesFile();
        phones.sort(new CostComparator().reversed());
        printAll(phones);
        return phones;
    }

    public static List<Phone> ascendingOrderByYear() throws IOException {
        List<Phone> phones = readPhonesFile();
        phones.sort(new YearComparator());
        printAll(phones);
        return phones;
    }

    public static List<Phone> descendingOrderByYear() throws IOException {
        List<Phone> phones = readPhonesFile();
        phones.sort(new YearComparator().reversed());
        printAll(phones);
        return phones;
    }

    public static List<Phone> readPhonesFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(FILE_PATH));

        return ConverterService.readPhonesFile(strings);
    }

    private static void writeIntoFile(Phone phone) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + phone.getId())
                .append("\nPhone-model: " + phone.getModel())
                .append("\nDisplay-type: " + phone.getDisplayType())
                .append("\nDisplay-size: " + phone.getDisplaySize())
                .append("\nDisplay-resolution: " + phone.getDisplayResolution())
                .append("\nDisplay-protection: " + phone.getDisplayProtection())
                .append("\nPlatform-OS: " + phone.getPlatformOS())
                .append("\nPlatform-CPU: " + phone.getPlatformCPU())
                .append("\nPlatform-GPU: " + phone.getPlatformGPU())
                .append("\nPlatform-chipset: " + phone.getPlatformChipset())
                .append("\nMemory: " + phone.getMemory())
                .append("\nRam: " + phone.getRam())
                .append("\nMain-camera: " + phone.getMainCamera())
                .append("\nFrontal-camera: " + phone.getFrontalCamera())
                .append("\nBattery: " + phone.getBattery())
                .append("\nPower: " + phone.getPower())
                .append("\nPower-consumption: " + phone.getPowerConsumption())
                .append("\nYear: " + phone.getYear())
                .append("\nPrice: " + phone.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Phone> phones) throws IOException {
        if (phones == null) {
            phones = readPhonesFile();
            for (Phone phone : phones) {
                System.out.println(phone.toString());
            }
            return;
        }
        for (Phone phone : phones) {
            System.out.println(phone.toString());
        }
    }

    public static void printComputer(Phone phone) {
        System.out.println(phone.toString());
    }

}
