package picsart.service;

import picsart.comparators.computerComparators.CostComparator;
import picsart.comparators.computerComparators.DateComparator;
import picsart.comparators.computerComparators.YearComparator;
import picsart.model.cellPhone.Phone;
import picsart.model.computer.Computer;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ComputerService {
    private static String path = FilePaths.COMPUTER.getValue();
    private static Set<Computer> computerSet;

    static {
        try {
            computerSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ComputerService() {}

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
        computerSet.add(computer);
        return computer;
    }

    public static List<Computer> multipleCreate(int size) throws IOException {
        List<Computer> computers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating computer number: " + (i + 1));
            computers.add(create());
        }

        return computers;
    }


    public static void updateById(int id) throws IOException {
        Computer computer = findById(id);
        if (computer==null) {
            return;
        }
        deleteById(id);
        computerSet.remove(computer);

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

        System.out.println("Enter storage capacity 0 to skip:");
        int storageCapacity = scanner.nextInt();

        System.out.println("Enter ram 0 to skip:");
        int ram = scanner.nextInt();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!processorModel.equals("")) {
            computer.setProcessorModel(processorModel);
        }
        if (!videoCard.equals("")) {
            computer.setVideoCard(videoCard);
        }
        if (!operatingSystem.equals("")) {
            computer.setOperatingSystem(operatingSystem);
        }
        if (!storageType.equals("")) {
            computer.setStorageType(storageType);
        }
        if (!model.equals("")) {
            computer.setModel(model);
        }
        if (ram > 1) {
            computer.setRam(ram);
        }
        if (!power.equals("")) {
            computer.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            computer.setPowerConsumption(powerConsumption);
        }
        if (!model.equals("")) {
            computer.setModel(model);
        }
        if (storageCapacity > 1) {
            computer.setStorageCapacity(storageCapacity);
        }
        if (price > 0) {
            computer.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            computer.setYear(year);
        }

        writeIntoFile(computer);
        computerSet.add(computer);
    }

    public static boolean checkId(int id) {
        Iterator<Computer> iterator = computerSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Computer next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Computer by id " + id + " does not exist:");
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

        Iterator<Computer> computerSetIterator = computerSet.iterator();
        while (computerSetIterator.hasNext()) {
            Computer next = computerSetIterator.next();
            if (next.getId() == id) {
                computerSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Computer> cameras = ConverterService.readComputersFile(strings);
        for (Computer computer : cameras) {
            writeIntoFile(computer);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        computerSet.clear();
    }


    public static Computer findById(long id) throws IOException {
        for (Computer computer : readFromFile()) {
            if (computer.getId() == id) {
                return computer;
            }
        }

        System.out.println("Computer by ID: " + id + " does not exist:");
        return null;
    }

    public static List<Computer> findByModel(List<Computer> computers, String model) throws IOException {
        List<Computer> computerList;
        if (computers == null) {
            computerList = readFromFile();
        } else {
            computerList = computers;
        }
        List<Computer> byModel = new ArrayList<>();
        for (Computer computer : computerList) {
            if (computer.getModel().equals(model)) {
                byModel.add(computer);
            }
        }

        return byModel;
    }

    public static List<Computer> findByPrice(List<Computer> computers, double from, double to) throws IOException {
        List<Computer> computerList;
        if (computers == null) {
            computerList = readFromFile();
        } else {
            computerList = computers;
        }
        int nullCounter = 0;
        for (Computer computer : computerList) {
            if (computer.getPrice() < from || computer.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == computerList.size()) {
            System.out.println("Computers by range " + from + "$ to " + to + "$ has noy found:");
            return new ArrayList<>();
        }

        List<Computer> byPriceRange = new ArrayList<>();
        for (Computer computer : computerList) {
            double price = computer.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(computer);
            }
        }

        return byPriceRange;
    }

    public static List<Computer> findByYear(List<Computer> computers, int year) throws IOException {
        List<Computer> computerList;
        if (computers == null) {
            computerList = readFromFile();
        } else {
            computerList = computers;
        }
        List<Computer> byYear = new ArrayList<>();
        for (Computer computer : computerList) {
            if (computer.getYear() == year) {
                byYear.add(computer);
            }
        }

        return byYear;
    }

    public static List<Computer> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Computer> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Computer> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Computer> findByAddingDate(List<Computer> computers, String date) throws IOException {
        List<Computer> computerList;
        if (computers == null) {
            computerList = readFromFile();
        } else {
            computerList = computers;
        }
        List<Computer> byAddingDate = new ArrayList<>();
        for (Computer computer : computerList) {
            String cameraDate = computer.getDate().substring(0, computer.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(computer);
            }
        }

        return byAddingDate;
    }

    public static Computer newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Computer older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Computer biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Computer smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Computer newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Computer olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Computer> ascendingOrderByPrice() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new CostComparator());
        return computers;
    }

    public static List<Computer> descendingOrderByPrice() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new CostComparator().reversed());
        return computers;
    }

    public static List<Computer> ascendingOrderByYear() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new YearComparator());
        return computers;
    }

    public static List<Computer> descendingOrderByYear() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new YearComparator().reversed());
        return computers;
    }

    public static List<Computer> ascendingOrderByAddingDate() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new DateComparator());
        return computers;
    }

    public static List<Computer> descendingOrderByAddingDate() throws IOException {
        List<Computer> computers = readFromFile();
        computers.sort(new DateComparator(true));
        return computers;
    }

    private static List<Computer> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
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
                .append("\nPrice: " + computer.getPrice())
                .append("\nDate: " + computer.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Computer> computers) throws IOException {
        if (computers == null) {
            computers = readFromFile();
            for (Computer computer : computers) {
                System.out.println(computer.toString());
            }
            return;
        }
        if (!computers.isEmpty()) {
            for (Computer computer : computers) {
                print(computer);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Computer computer) {
        System.out.println(computer.toString());
    }
}
