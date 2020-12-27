package picsart.service;

import picsart.comparators.washingMachineComparators.CostComparator;
import picsart.comparators.washingMachineComparators.DateComparator;
import picsart.comparators.washingMachineComparators.YearComparator;
import picsart.model.washingMachine.WashingMachine;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class WashingMachineService {

    private static String path = FilePaths.WASHING_MACHINE.getValue();
    private static Set<WashingMachine> washingMachineSet;

    static {
        try {
            washingMachineSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private WashingMachineService() {
    }

    public static WashingMachine create() throws IOException {
        System.out.println("Create washing machine\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter type of installation:");
        String typeOfInstallation = scanner.nextLine();
        while (typeOfInstallation.equals("")) {
            System.out.println("Type of installation have not to be blank: ");
            typeOfInstallation = scanner.nextLine();
        }
        System.out.println("Enter download type:");
        String downloadType = scanner.nextLine();
        while (downloadType.equals("")) {
            System.out.println("Download type have not to be blank: ");
            downloadType = scanner.nextLine();
        }
        System.out.println("Enter maximum download:");
        String maximumDownload = scanner.nextLine();
        while (maximumDownload.equals("")) {
            System.out.println("Maximum download have not to be blank: ");
            maximumDownload = scanner.nextLine();
        }
        System.out.println("Enter programs:");
        String programs = scanner.nextLine();
        while (programs.equals("")) {
            System.out.println("Programs have not to be blank: ");
            programs = scanner.nextLine();
        }
        System.out.println("Enter dimensions:");
        String dimensions = scanner.nextLine();
        while (dimensions.equals("")) {
            System.out.println("Dimensions have not to be blank: ");
            dimensions = scanner.nextLine();
        }
        System.out.println("Enter display 'yes' or 'no':");
        boolean isHaveDisplay = false;
        String display = scanner.nextLine();
        while (!display.equals("yes") && !display.equals("no")) {
            System.out.println("Display have not to be blank insert 'yes' or 'no': ");
            display = scanner.nextLine();
        }
        if (display.equals("yes")) {
            isHaveDisplay = true;
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
        System.out.println("Enter weight:");
        int weight = scanner.nextInt();
        while (weight < 1) {
            System.out.println("Year must be bigger than 1: ");
            weight = scanner.nextInt();
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

        WashingMachine washingMachine = new WashingMachine(IDGenerator.generateID(9));
        washingMachine.setModel(model);
        washingMachine.setPower(power);
        washingMachine.setPowerConsumption(powerConsumption);
        washingMachine.setPrice(price);
        washingMachine.setYear(year);
        washingMachine.setDimensions(dimensions);
        washingMachine.setDisplay(isHaveDisplay);
        washingMachine.setDownloadType(downloadType);
        washingMachine.setMaximumDownload(maximumDownload);
        washingMachine.setPrograms(programs);
        washingMachine.setTypeOfInstallation(typeOfInstallation);
        washingMachine.setWeight(weight);


        writeIntoFile(washingMachine);
        washingMachineSet.add(washingMachine);
        return washingMachine;
    }

    public static Set<WashingMachine> multipleCreate(int size) throws IOException {
        Set<WashingMachine> washingMachines = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating washing machine number: " + (i + 1));
            washingMachines.add(create());
        }

        return washingMachines;
    }

    public static void updateById(int id) throws IOException {
        WashingMachine washingMachine = findById(id);
        if (washingMachine == null) {
            return;
        }
        deleteById(id);
        washingMachineSet.remove(washingMachine);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter type of installation:");
        String typeOfInstallation = scanner.nextLine();

        System.out.println("Enter download type:");
        String downloadType = scanner.nextLine();

        System.out.println("Enter maximum download:");
        String maximumDownload = scanner.nextLine();

        System.out.println("Enter programs:");
        String programs = scanner.nextLine();

        System.out.println("Enter dimensions:");
        String dimensions = scanner.nextLine();


        System.out.println("Enter display 'yes' or 'no':");
        boolean isHaveDisplay = false;
        String display = scanner.nextLine();
        while (!display.equals("yes") && !display.equals("no")) {
            System.out.println("Display have not to be blank insert 'yes' or 'no': ");
            display = scanner.nextLine();
        }
        if (display.equals("yes")) {
            isHaveDisplay = true;
        }

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter weight 0 to skip:");
        int weight = scanner.nextInt();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!typeOfInstallation.equals("")) {
            washingMachine.setTypeOfInstallation(typeOfInstallation);
        }
        if (!downloadType.equals("")) {
            washingMachine.setDownloadType(downloadType);
        }
        if (!maximumDownload.equals("")) {
            washingMachine.setMaximumDownload(maximumDownload);
        }
        if (!programs.equals("")) {
            washingMachine.setPrograms(programs);
        }
        if (!dimensions.equals("")) {
            washingMachine.setDimensions(dimensions);
        }
        if (weight > 0) {
            washingMachine.setWeight(weight);
        }
        washingMachine.setDisplay(isHaveDisplay);
        if (!model.equals("")) {
            washingMachine.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            washingMachine.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            washingMachine.setPower(power);
        }
        if (price > 0) {
            washingMachine.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            washingMachine.setYear(year);
        }

        writeIntoFile(washingMachine);
        washingMachineSet.add(washingMachine);
    }

    public static boolean checkId(int id) {
        Iterator<WashingMachine> iterator = washingMachineSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            WashingMachine next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Washing machine by id " + id + " does not exist:");
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

        Iterator<WashingMachine> washingMachineSetIterator = washingMachineSet.iterator();
        while (washingMachineSetIterator.hasNext()) {
            WashingMachine next = washingMachineSetIterator.next();
            if (next.getId() == id) {
                washingMachineSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<WashingMachine> washingMachines = ConverterService.readWashingMachineFile(strings);
        for (WashingMachine washingMachine : washingMachines) {
            writeIntoFile(washingMachine);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        washingMachineSet.clear();
    }

    public static WashingMachine findById(long id) {
        for (WashingMachine washingMachine : washingMachineSet) {
            if (washingMachine.getId() == id) {
                return washingMachine;
            }
        }

        System.out.println("Camera by ID: " + id + " does not exist");
        return null;
    }

    public static Set<WashingMachine> findByModel(Set<WashingMachine> washingMachines, String model) {
        Set<WashingMachine> washingMachineSet;
        if (washingMachines == null) {
            washingMachineSet = WashingMachineService.washingMachineSet;
        } else {
            washingMachineSet = washingMachines;
        }
        Set<WashingMachine> byModel = new HashSet<>();
        for (WashingMachine washingMachine : washingMachineSet) {
            if (washingMachine.getModel().equals(model)) {
                byModel.add(washingMachine);
            }
        }

        return byModel;
    }

    public static Set<WashingMachine> findByPrice(Set<WashingMachine> washingMachines, double from, double to) {
        Set<WashingMachine> washingMachineSet;
        if (washingMachines == null) {
            washingMachineSet = WashingMachineService.washingMachineSet;
        } else {
            washingMachineSet = washingMachines;
        }
        int nullCounter = 0;
        for (WashingMachine washingMachine : washingMachineSet) {
            if (washingMachine.getPrice() < from || washingMachine.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == washingMachineSet.size()) {
            System.out.println("Washing machines by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<WashingMachine> byPriceRange = new HashSet<>();
        for (WashingMachine washingMachine : washingMachineSet) {
            double price = washingMachine.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(washingMachine);
            }
        }

        return byPriceRange;
    }

    public static Set<WashingMachine> findByYear(Set<WashingMachine> washingMachines, int year) {
        Set<WashingMachine> washingMachineSet;
        if (washingMachines == null) {
            washingMachineSet = WashingMachineService.washingMachineSet;
        } else {
            washingMachineSet = washingMachines;
        }
        Set<WashingMachine> byYear = new HashSet<>();
        for (WashingMachine washingMachine : washingMachineSet) {
            if (washingMachine.getYear() == year) {
                byYear.add(washingMachine);
            }
        }

        return byYear;
    }

    public static Set<WashingMachine> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<WashingMachine> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<WashingMachine> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<WashingMachine> findByAddingDate(Set<WashingMachine> washingMachines, String date) {
        Set<WashingMachine> washingMachineSet;
        if (washingMachines == null) {
            washingMachineSet = WashingMachineService.washingMachineSet;
        } else {
            washingMachineSet = washingMachines;
        }
        Set<WashingMachine> byAddingDate = new HashSet<>();
        for (WashingMachine washingMachine : washingMachineSet) {
            String cameraDate = washingMachine.getDate().substring(0, washingMachine.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(washingMachine);
            }
        }

        return byAddingDate;
    }

    public static WashingMachine newer() {
        return Collections.max(washingMachineSet, new YearComparator());
    }

    public static WashingMachine older() {
        return Collections.min(washingMachineSet, new YearComparator());
    }

    public static WashingMachine biggerCost() {
        return Collections.max(washingMachineSet, new CostComparator());
    }

    public static WashingMachine smallerCost() {
        return Collections.min(washingMachineSet, new CostComparator());
    }

    public static WashingMachine newerAdded() {
        return Collections.max(washingMachineSet, new DateComparator());
    }

    public static WashingMachine olderAdded() {
        return Collections.min(washingMachineSet, new DateComparator());
    }

    public static List<WashingMachine> ascendingOrderByPrice() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new CostComparator());
        return washingMachines;
    }

    public static List<WashingMachine> descendingOrderByPrice() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new CostComparator().reversed());
        return washingMachines;
    }

    public static List<WashingMachine> ascendingOrderByYear() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new YearComparator());
        return washingMachines;
    }

    public static List<WashingMachine> descendingOrderByYear() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new YearComparator().reversed());
        return washingMachines;
    }

    public static List<WashingMachine> ascendingOrderByAddingDate() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new DateComparator());
        return washingMachines;
    }

    public static List<WashingMachine> descendingOrderByAddingDate() {
        List<WashingMachine> washingMachines = new ArrayList<>(washingMachineSet);
        washingMachines.sort(new DateComparator(true));
        return washingMachines;
    }

    private static List<WashingMachine> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readWashingMachineFile(strings);
    }

    private static void writeIntoFile(WashingMachine washingMachine) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + washingMachine.getId())
                .append("\nModel: " + washingMachine.getModel())
                .append("\nType-of-installation: " + washingMachine.getTypeOfInstallation())
                .append("\nDownload-type: " + washingMachine.getDownloadType())
                .append("\nMaximum-download: " + washingMachine.getMaximumDownload())
                .append("\nPrograms: " + washingMachine.getPrograms())
                .append("\nDimensions: " + washingMachine.getDimensions())
                .append("\nDisplay: " + ((washingMachine.isDisplay()) ? "have" : "haven't"))
                .append("\nWeight: " + washingMachine.getWeight())
                .append("\nPower: " + washingMachine.getPower())
                .append("\nPower-consumption: " + washingMachine.getPowerConsumption())
                .append("\nYear: " + washingMachine.getYear())
                .append("\nPrice: " + washingMachine.getPrice())
                .append("\nDate: " + washingMachine.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<WashingMachine> washingMachines) throws IOException {
        if (washingMachines == null) {
            washingMachines = readFromFile();
            for (WashingMachine washingMachine : washingMachines) {
                System.out.println(washingMachine.toString());
            }
            return;
        }
        if (!washingMachines.isEmpty()) {
            for (WashingMachine washingMachine : washingMachines) {
                print(washingMachine);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(WashingMachine washingMachine) {
        System.out.println(washingMachine.toString());
    }
}
