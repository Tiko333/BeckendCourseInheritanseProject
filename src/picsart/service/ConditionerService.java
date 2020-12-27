package picsart.service;

import picsart.comparators.conditionerComparators.CostComparator;
import picsart.comparators.conditionerComparators.DateComparator;
import picsart.comparators.conditionerComparators.YearComparator;
import picsart.model.conditioner.Conditioner;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConditionerService {

    private static String path = FilePaths.CONDITIONER.getValue();
    private static Set<Conditioner> conditionerSet;

    static {
        try {
            conditionerSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConditionerService() {
    }

    public static Conditioner create() throws IOException {
        System.out.println("Create conditioner\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter type:");
        String type = scanner.nextLine();
        while (type.equals("")) {
            System.out.println("Type have not to be blank: ");
            type = scanner.nextLine();
        }
        System.out.println("Enter operation modes:");
        String operationModes = scanner.nextLine();
        while (operationModes.equals("")) {
            System.out.println("Operation modes have not to be blank: ");
            operationModes = scanner.nextLine();
        }
        System.out.println("Enter noise level:");
        String noiseLevel = scanner.nextLine();
        while (noiseLevel.equals("")) {
            System.out.println("Noise level have not to be blank: ");
            noiseLevel = scanner.nextLine();
        }
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        while (color.equals("")) {
            System.out.println("Color have not to be blank: ");
            color = scanner.nextLine();
        }
        System.out.println("Enter maximum working area:");
        String maximumWorkingArea = scanner.nextLine();
        while (maximumWorkingArea.equals("")) {
            System.out.println("Maximum working area have not to be blank: ");
            maximumWorkingArea = scanner.nextLine();
        }
        System.out.println("Enter size:");
        String size = scanner.nextLine();
        while (size.equals("")) {
            System.out.println("Size have not to be blank: ");
            size = scanner.nextLine();
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

        Conditioner conditioner = new Conditioner(IDGenerator.generateID(9));
        conditioner.setModel(model);
        conditioner.setPower(power);
        conditioner.setPowerConsumption(powerConsumption);
        conditioner.setPrice(price);
        conditioner.setYear(year);
        conditioner.setType(type);
        conditioner.setOperationModes(operationModes);
        conditioner.setNoiseLevel(noiseLevel);
        conditioner.setColor(color);
        conditioner.setMaximumWorkingArea(maximumWorkingArea);
        conditioner.setSize(size);


        writeIntoFile(conditioner);
        conditionerSet.add(conditioner);
        return conditioner;
    }

    public static Set<Conditioner> multipleCreate(int size) throws IOException {
        Set<Conditioner> conditioners = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating conditioner number: " + (i + 1));
            conditioners.add(create());
        }

        return conditioners;
    }

    public static void updateById(int id) throws IOException {
        Conditioner conditioner = findById(id);
        if (conditioner==null) {
            return;
        }
        deleteById(id);
        conditionerSet.remove(conditioner);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter type:");
        String type = scanner.nextLine();

        System.out.println("Enter operation modes:");
        String operationModes = scanner.nextLine();

        System.out.println("Enter noise level:");
        String noiseLevel = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter maximum working area:");
        String maximumWorkingArea = scanner.nextLine();

        System.out.println("Enter size:");
        String size = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!type.equals("")) {
            conditioner.setType(type);
        }
        if (!operationModes.equals("")) {
            conditioner.setOperationModes(operationModes);
        }
        if (!noiseLevel.equals("")) {
            conditioner.setNoiseLevel(noiseLevel);
        }
        if (!color.equals("")) {
            conditioner.setColor(color);
        }
        if (!maximumWorkingArea.equals("")) {
            conditioner.setMaximumWorkingArea(maximumWorkingArea);
        }
        if (!size.equals("")) {
            conditioner.setSize(size);
        }

        if (!model.equals("")) {
            conditioner.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            conditioner.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            conditioner.setPower(power);
        }
        if (price > 0) {
            conditioner.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            conditioner.setYear(year);
        }

        writeIntoFile(conditioner);
        conditionerSet.add(conditioner);
    }

    public static boolean checkId(int id) {
        Iterator<Conditioner> iterator = conditionerSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Conditioner next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Conditioner by id " + id + " does not exist:");
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

        Iterator<Conditioner> conditionerSetIterator = conditionerSet.iterator();
        while (conditionerSetIterator.hasNext()) {
            Conditioner next = conditionerSetIterator.next();
            if (next.getId() == id) {
                conditionerSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Conditioner> conditioners = ConverterService.readConditionerFile(strings);
        for (Conditioner conditioner : conditioners) {
            writeIntoFile(conditioner);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        conditionerSet.clear();
    }

    public static Conditioner findById(long id) {
        for (Conditioner conditioner : conditionerSet) {
            if (conditioner.getId() == id) {
                return conditioner;
            }
        }

        System.out.println("Conditioner by ID: " + id + " does not exist");
        return null;
    }

    public static Set<Conditioner> findByModel(Set<Conditioner> conditioners, String model) {
        Set<Conditioner> conditionerSet;
        if (conditioners == null) {
            conditionerSet = ConditionerService.conditionerSet;
        } else {
            conditionerSet = conditioners;
        }
        Set<Conditioner> byModel = new HashSet<>();
        for (Conditioner conditioner : conditionerSet) {
            if (conditioner.getModel().equals(model)) {
                byModel.add(conditioner);
            }
        }

        return byModel;
    }

    public static Set<Conditioner> findByPrice(Set<Conditioner> conditioners, double from, double to) {
        Set<Conditioner> conditionerSet;
        if (conditioners == null) {
            conditionerSet = ConditionerService.conditionerSet;
        } else {
            conditionerSet = conditioners;
        }
        int nullCounter = 0;
        for (Conditioner conditioner : conditionerSet) {
            if (conditioner.getPrice() < from || conditioner.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == conditionerSet.size()) {
            System.out.println("Conditioners by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<Conditioner> byPriceRange = new HashSet<>();
        for (Conditioner conditioner : conditionerSet) {
            double price = conditioner.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(conditioner);
            }
        }

        return byPriceRange;
    }

    public static Set<Conditioner> findByYear(Set<Conditioner> conditioners, int year) {
        Set<Conditioner> conditionerSet;
        if (conditioners == null) {
            conditionerSet = ConditionerService.conditionerSet;
        } else {
            conditionerSet = conditioners;
        }
        Set<Conditioner> byYear = new HashSet<>();
        for (Conditioner conditioner : conditionerSet) {
            if (conditioner.getYear() == year) {
                byYear.add(conditioner);
            }
        }

        return byYear;
    }

    public static Set<Conditioner> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<Conditioner> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<Conditioner> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<Conditioner> findByAddingDate(Set<Conditioner> conditioners, String date) {
        Set<Conditioner> conditionerSet;
        if (conditioners == null) {
            conditionerSet = ConditionerService.conditionerSet;
        } else {
            conditionerSet = conditioners;
        }
        Set<Conditioner> byAddingDate = new HashSet<>();
        for (Conditioner conditioner : conditionerSet) {
            String cameraDate = conditioner.getDate().substring(0, conditioner.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(conditioner);
            }
        }

        return byAddingDate;
    }

    public static Conditioner newer() {
        return Collections.max(conditionerSet, new YearComparator());
    }

    public static Conditioner older() {
        return Collections.min(conditionerSet, new YearComparator());
    }

    public static Conditioner biggerCost() {
        return Collections.max(conditionerSet, new CostComparator());
    }

    public static Conditioner smallerCost() {
        return Collections.min(conditionerSet, new CostComparator());
    }

    public static Conditioner newerAdded() {
        return Collections.max(conditionerSet, new DateComparator());
    }

    public static Conditioner olderAdded() {
        return Collections.min(conditionerSet, new DateComparator());
    }

    public static List<Conditioner> ascendingOrderByPrice() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new CostComparator());
        return conditioners;
    }

    public static List<Conditioner> descendingOrderByPrice() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new CostComparator().reversed());
        return conditioners;
    }

    public static List<Conditioner> ascendingOrderByYear() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new YearComparator());
        return conditioners;
    }

    public static List<Conditioner> descendingOrderByYear() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new YearComparator().reversed());
        return conditioners;
    }

    public static List<Conditioner> ascendingOrderByAddingDate() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new DateComparator());
        return conditioners;
    }

    public static List<Conditioner> descendingOrderByAddingDate() {
        List<Conditioner> conditioners = new ArrayList<>(conditionerSet);
        conditioners.sort(new DateComparator(true));
        return conditioners;
    }

    private static List<Conditioner> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readConditionerFile(strings);
    }

    private static void writeIntoFile(Conditioner conditioner) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + conditioner.getId())
                .append("\nConditioner-model: " + conditioner.getModel())
                .append("\nType: " + conditioner.getType())
                .append("\nOperation-modes: " + conditioner.getOperationModes())
                .append("\nMaximum-working-area: " + conditioner.getMaximumWorkingArea())
                .append("\nNoise-level: " + conditioner.getNoiseLevel())
                .append("\nSize: " + conditioner.getSize())
                .append("\nColor: " + conditioner.getColor())
                .append("\nPower: " + conditioner.getPower())
                .append("\nPower-consumption: " + conditioner.getPowerConsumption())
                .append("\nYear: " + conditioner.getYear())
                .append("\nPrice: " + conditioner.getPrice())
                .append("\nDate: " + conditioner.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<Conditioner> cameras) throws IOException {
        if (cameras == null) {
            cameras = readFromFile();
            for (Conditioner conditioner : cameras) {
                System.out.println(conditioner.toString());
            }
            return;
        }
        if (!cameras.isEmpty()) {
            for (Conditioner conditioner : cameras) {
                print(conditioner);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(Conditioner conditioner) {
        System.out.println(conditioner.toString());
    }

}
