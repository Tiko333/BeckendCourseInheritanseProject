package picsart.service;

import picsart.comparators.computerComparators.CostComparator;
import picsart.comparators.computerComparators.YearComparator;
import picsart.model.computer.Computer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ComputerService {
    private static final String FILE_PATH = "src/picsart/files/computers.txt";

    public static Computer create() throws IOException {
        System.out.println("Create computer:\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
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

        Computer computer = new Computer(IDGenerator.generateID(9));
        computer.setOperatingSystem(operatingSystem);
        computer.setProcessorModel(processorModel);
        computer.setRam(ram);
        computer.setStorageCapacity(storageCapacity);
        computer.setStorageType(storageType);
        computer.setVideoCard(videoCard);
        computer.setModel(model);
        computer.setPower(power);
        computer.setPowerConsumption(powerConsumption);
        computer.setPrice(price);
        computer.setYear(year);

        writeIntoFile(computer);
        return computer;
    }

    public static List<Computer> createComputers(int size) throws IOException {
        List<Computer> computers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating computer number: " + (i + 1));
            computers.add(create());
        }

        return computers;
    }

    public static Computer findById(long id) throws IOException {
        List<Computer> computers = readComputersFromFile();
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                System.out.println(computer.toString());
                return computer;
            }
        }

        System.out.println("Computer by ID: " + id + " does not exist:");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        List<Computer> computers = readComputersFromFile();
        boolean isFound = false;
        for (int i = 0; i < computers.size(); i++) {
            Computer computer = computers.get(i);
            if (computer.getModel().equals(model)) {
                System.out.println(computer.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == computers.size() - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no computer by model: " + model);
        }
    }

    public static List<Computer> findByPrice(double from, double to) throws IOException {
        List<Computer> computers = readComputersFromFile();
        int nullCounter = 0;
        for (Computer computer : computers) {
            if (computer.getPrice() < from || computer.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == computers.size()) {
            System.out.println("Computers by range " + from + "$ to " + to + "$ has noy found:");
            return new ArrayList<>();
        }

        List<Computer> selectedComputersByPriceRange = new ArrayList<>();
        for (Computer computer : computers) {
            double price = computer.getPrice();
            if (price >= from && price <= to) {
                selectedComputersByPriceRange.add(computer);
            }
        }

        printAll(selectedComputersByPriceRange);
        return selectedComputersByPriceRange;
    }

    public static Computer newerComputer() throws IOException {
        List<Computer> computers = readComputersFromFile();
        Computer max = Collections.max(computers, new YearComparator());
        printComputer(max);
        return max;
    }

    public static Computer olderComputer() throws IOException {
        List<Computer> computers = readComputersFromFile();
        Computer min = Collections.min(computers, new YearComparator());
        printComputer(min);
        return min;
    }

    public static Computer biggerCost() throws IOException {
        List<Computer> computers = readComputersFromFile();
        Computer max = Collections.max(computers, new CostComparator());
        printComputer(max);
        return max;
    }

    public static Computer smallerCost() throws IOException {
        List<Computer> computers = readComputersFromFile();
        Computer min = Collections.min(computers, new CostComparator());
        printComputer(min);
        return min;
    }

    public static List<Computer> ascendingOrderByPrice() throws IOException {
        List<Computer> computers = readComputersFromFile();
        computers.sort(new CostComparator());
        printAll(computers);
        return computers;
    }

    public static List<Computer> descendingOrderByPrice() throws IOException {
        List<Computer> computers = readComputersFromFile();
        computers.sort(new CostComparator().reversed());
        printAll(computers);
        return computers;
    }

    public static List<Computer> ascendingOrderByYear() throws IOException {
        List<Computer> computers = readComputersFromFile();
        computers.sort(new YearComparator());
        printAll(computers);
        return computers;
    }

    public static List<Computer> descendingOrderByYear() throws IOException {
        List<Computer> computers = readComputersFromFile();
        computers.sort(new YearComparator().reversed());
        printAll(computers);
        return computers;
    }

    private static List<Computer> readComputersFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(FILE_PATH));

        return ConverterService.readComputersFile(strings);
    }

    private static void writeIntoFile(Computer computer) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + computer.getId())
                .append("\nMotherBoard-model: " + computer.getModel())
                .append("\nCPU-model: " + computer.getProcessorModel())
                .append("\nGPU-model: " + computer.getVideoCard())
                .append("\nOperating-system: " + computer.getOperatingSystem())
                .append("\nStorage-capacity: " + computer.getStorageCapacity())
                .append("\nStorage-type: " + computer.getStorageType())
                .append("\nRam: " + computer.getRam())
                .append("\nPower: " + computer.getPower())
                .append("\nPower-consumption: " + computer.getPowerConsumption())
                .append("\nYear: " + computer.getYear())
                .append("\nPrice: " + computer.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Computer> computers) throws IOException {
        if (computers == null) {
            computers = readComputersFromFile();
            for (Computer computer : computers) {
                System.out.println(computer.toString());
            }
            return;
        }
        for (Computer computer : computers) {
            System.out.println(computer.toString());
        }
    }

    public static void printComputer(Computer computer) {
        System.out.println(computer.toString());
    }
}
