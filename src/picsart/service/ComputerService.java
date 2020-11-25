package picsart.service;

import picsart.model.cellPhone.Phone;
import picsart.model.computer.Computer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
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

    public static Computer[] createComputers(int size) throws IOException {
        Computer[] computers = new Computer[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Creating computer number: " + (i + 1));
            computers[i] = create();
        }

        return computers;
    }

    public static Computer findById(long id) throws IOException {
        Computer[] computers = readComputersFromFile();
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
        Computer[] computers = readComputersFromFile();
        boolean isFound = false;
        for (int i = 0; i < computers.length; i++) {
            Computer computer = computers[i];
            if (computer.getModel().equals(model)) {
                System.out.println(computer.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == computers.length - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no computer by model: " + model);
        }
    }

    public static Computer[] findByPrice(double from, double to) throws IOException {
        Computer[] computers = readComputersFromFile();
        int nullCounter = 0;
        for (Computer computer : computers) {
            if (computer.getPrice() < from || computer.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == computers.length) {
            System.out.println("Computers by range " + from + "$ to " + to + "$ has noy found:");
            return new Computer[0];
        }
        int index = 0;
        Computer[] selectedComputersByPriceRange = new Computer[computers.length - nullCounter];
        for (Computer computer : computers) {
            double price = computer.getPrice();
            if (price >= from && price <= to) {
                selectedComputersByPriceRange[index++] = computer;
            }
        }

        printAll(selectedComputersByPriceRange);
        return selectedComputersByPriceRange;
    }

    public static Computer newerComputer() throws IOException {
        Computer[] computers = readComputersFromFile();
        Computer newerComputer = computers[0];
        for (Computer computer : computers) {
            if (computer.getYear() >= newerComputer.getYear()) {
                newerComputer = computer;
            }
        }

        printComputer(newerComputer);
        return newerComputer;
    }

    public static Computer olderComputer() throws IOException {
        Computer[] computers = readComputersFromFile();
        Computer olderComputer = computers[0];
        for (Computer computer : computers) {
            if (computer.getYear() < olderComputer.getYear()) {
                olderComputer = computer;
            }
        }

        printComputer(olderComputer);
        return olderComputer;
    }

    public static Computer biggerCost() throws IOException {
        Computer[] computers = readComputersFromFile();
        Computer biggerCostComputer = computers[0];
        for (Computer computer : computers) {
            if (computer.getPrice() > biggerCostComputer.getPrice()) {
                biggerCostComputer = computer;
            }
        }

        printComputer(biggerCostComputer);
        return biggerCostComputer;
    }

    public static Computer smallerCost() throws IOException {
        Computer[] computers = readComputersFromFile();
        Computer smallerCostComputer = computers[0];
        for (Computer computer : computers) {
            if (computer.getPrice() < smallerCostComputer.getPrice()) {
                smallerCostComputer = computer;
            }
        }

        printComputer(smallerCostComputer);
        return smallerCostComputer;
    }

    public static Computer[] ascendingOrderByPrice() throws IOException {
        Computer[] computers = readComputersFromFile();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 1; j < computers.length - i; j++) {
                if (computers[j - 1].getPrice() > computers[j].getPrice()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j - 1];
                    computers[j - 1] = temp;
                }
            }
        }

        printAll(computers);
        return computers;
    }

    public static Computer[] descendingOrderByPrice() throws IOException {
        Computer[] computers = readComputersFromFile();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 1; j < computers.length - i; j++) {
                if (computers[j - 1].getPrice() < computers[j].getPrice()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j - 1];
                    computers[j - 1] = temp;
                }
            }
        }

        printAll(computers);
        return computers;
    }

    public static Computer[] ascendingOrderByYear() throws IOException {
        Computer[] computers = readComputersFromFile();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 1; j < computers.length - i; j++) {
                if (computers[j - 1].getYear() > computers[j].getYear()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j - 1];
                    computers[j - 1] = temp;
                }
            }
        }

        printAll(computers);
        return computers;
    }

    public static Computer[] descendingOrderByYear() throws IOException {
        Computer[] computers = readComputersFromFile();
        for (int i = 0; i < computers.length; i++) {
            for (int j = 1; j < computers.length - i; j++) {
                if (computers[j - 1].getYear() < computers[j].getYear()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j - 1];
                    computers[j - 1] = temp;
                }
            }
        }

        printAll(computers);
        return computers;
    }

    private static Computer[] readComputersFromFile() throws IOException {
        String[] strings = Files.readAllLines(Path.of(FILE_PATH)).toArray(new String[0]);

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

    public static void printAll(Computer[] computers) throws IOException {
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
