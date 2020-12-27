package picsart.service;

import picsart.comparators.vacuumCleanerComparators.DateComparator;
import picsart.comparators.vacuumCleanerComparators.YearComparator;
import picsart.comparators.vacuumCleanerComparators.CostComparator;
import picsart.model.vacuumCleaner.VacuumCleaner;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class VacuumCleanerService {

    private static String path = FilePaths.VACUUM_CLEANER.getValue();
    private static Set<VacuumCleaner> vacuumCleanerSet;

    static {
        try {
            vacuumCleanerSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private VacuumCleanerService() {
    }

    public static VacuumCleaner create() throws IOException {
        System.out.println("Create camera\n");
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
        System.out.println("Enter pipe type:");
        String pipeType = scanner.nextLine();
        while (pipeType.equals("")) {
            System.out.println("Pipe type have not to be blank: ");
            pipeType = scanner.nextLine();
        }
        System.out.println("Enter dust collector:");
        String dustCollector = scanner.nextLine();
        while (dustCollector.equals("")) {
            System.out.println("Dust collector have not to be blank: ");
            dustCollector = scanner.nextLine();
        }
        System.out.println("Enter type of management:");
        String typeOfManagement = scanner.nextLine();
        while (typeOfManagement.equals("")) {
            System.out.println("Type of management have not to be blank: ");
            typeOfManagement = scanner.nextLine();
        }
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        while (color.equals("")) {
            System.out.println("Color have not to be blank: ");
            color = scanner.nextLine();
        }
        System.out.println("Enter floor and carpet knob 'yes' or 'no':");
        boolean isHaveFloorAndCarpetKnob = false;
        String floorAndCarpetKnob = scanner.nextLine();
        while (!floorAndCarpetKnob.equals("yes") && !floorAndCarpetKnob.equals("no")) {
            System.out.println("Floor and carpet knob have not to be blank insert 'yes' or 'no': ");
            floorAndCarpetKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveFloorAndCarpetKnob = true;
        }
        System.out.println("Enter soft furniture knob 'yes' or 'no':");
        boolean isHaveSoftFurnitureKnob = false;
        String softFurnitureKnob = scanner.nextLine();
        while (!softFurnitureKnob.equals("yes") && !softFurnitureKnob.equals("no")) {
            System.out.println("Soft furniture knob have not to be blank insert 'yes' or 'no': ");
            softFurnitureKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveSoftFurnitureKnob = true;
        }
        System.out.println("Enter corners knob knob 'yes' or 'no':");
        boolean isHaveCornersKnob = false;
        String cornersKnob = scanner.nextLine();
        while (!cornersKnob.equals("yes") && !cornersKnob.equals("no")) {
            System.out.println("Corners knob have not to be blank insert 'yes' or 'no': ");
            cornersKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveCornersKnob = true;
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

        VacuumCleaner vacuumCleaner = new VacuumCleaner(IDGenerator.generateID(9));
        vacuumCleaner.setModel(model);
        vacuumCleaner.setPower(power);
        vacuumCleaner.setPowerConsumption(powerConsumption);
        vacuumCleaner.setPrice(price);
        vacuumCleaner.setYear(year);
        vacuumCleaner.setColor(color);
        vacuumCleaner.setCornersKnob(isHaveCornersKnob);
        vacuumCleaner.setFloorAndCarpetKnob(isHaveFloorAndCarpetKnob);
        vacuumCleaner.setSoftFurnitureKnob(isHaveSoftFurnitureKnob);
        vacuumCleaner.setDustCollector(dustCollector);
        vacuumCleaner.setPipeType(pipeType);
        vacuumCleaner.setType(type);
        vacuumCleaner.setTypeOfManagement(typeOfManagement);

        writeIntoFile(vacuumCleaner);
        vacuumCleanerSet.add(vacuumCleaner);
        return vacuumCleaner;
    }

    public static Set<VacuumCleaner> multipleCreate(int size) throws IOException {
        Set<VacuumCleaner> vacuumCleaners = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating vacuum cleaner number: " + (i + 1));
            vacuumCleaners.add(create());
        }

        return vacuumCleaners;
    }

    public static void updateById(int id) throws IOException {
        VacuumCleaner vacuumCleaner = findById(id);
        if (vacuumCleaner == null) {
            return;
        }
        deleteById(id);
        vacuumCleanerSet.remove(vacuumCleaner);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter type:");
        String type = scanner.nextLine();

        System.out.println("Enter pipe type:");
        String pipeType = scanner.nextLine();

        System.out.println("Enter dust collector:");
        String dustCollector = scanner.nextLine();

        System.out.println("Enter type of management:");
        String typeOfManagement = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter floor and carpet knob 'yes' or 'no':");
        boolean isHaveFloorAndCarpetKnob = false;
        String floorAndCarpetKnob = scanner.nextLine();
        while (!floorAndCarpetKnob.equals("yes") && !floorAndCarpetKnob.equals("no")) {
            System.out.println("Floor and carpet knob have not to be blank insert 'yes' or 'no': ");
            floorAndCarpetKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveFloorAndCarpetKnob = true;
        }
        System.out.println("Enter soft furniture knob 'yes' or 'no':");
        boolean isHaveSoftFurnitureKnob = false;
        String softFurnitureKnob = scanner.nextLine();
        while (!softFurnitureKnob.equals("yes") && !softFurnitureKnob.equals("no")) {
            System.out.println("Soft furniture knob have not to be blank insert 'yes' or 'no': ");
            softFurnitureKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveSoftFurnitureKnob = true;
        }
        System.out.println("Enter soft furniture knob 'yes' or 'no':");
        boolean isHaveCornersKnob = false;
        String cornersKnob = scanner.nextLine();
        while (!cornersKnob.equals("yes") && !cornersKnob.equals("no")) {
            System.out.println("Corners knob have not to be blank insert 'yes' or 'no': ");
            cornersKnob = scanner.nextLine();
        }
        if (floorAndCarpetKnob.equals("yes")) {
            isHaveCornersKnob = true;
        }

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!type.equals("")) {
            vacuumCleaner.setType(type);
        }
        if (!pipeType.equals("")) {
            vacuumCleaner.setPipeType(pipeType);
        }
        if (!dustCollector.equals("")) {
            vacuumCleaner.setDustCollector(dustCollector);
        }
        if (!typeOfManagement.equals("")) {
            vacuumCleaner.setTypeOfManagement(typeOfManagement);
        }
        if (!color.equals("")) {
            vacuumCleaner.setColor(color);
        }
        vacuumCleaner.setFloorAndCarpetKnob(isHaveFloorAndCarpetKnob);
        vacuumCleaner.setSoftFurnitureKnob(isHaveSoftFurnitureKnob);
        vacuumCleaner.setCornersKnob(isHaveCornersKnob);
        if (!model.equals("")) {
            vacuumCleaner.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            vacuumCleaner.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            vacuumCleaner.setPower(power);
        }
        if (price > 0) {
            vacuumCleaner.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            vacuumCleaner.setYear(year);
        }

        writeIntoFile(vacuumCleaner);
        vacuumCleanerSet.add(vacuumCleaner);
    }

    public static boolean checkId(int id) {
        Iterator<VacuumCleaner> iterator = vacuumCleanerSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            VacuumCleaner next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Vacuum cleaner by id " + id + " does not exist:");
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

        Iterator<VacuumCleaner> vacuumCleanerSetIterator = vacuumCleanerSet.iterator();
        while (vacuumCleanerSetIterator.hasNext()) {
            VacuumCleaner next = vacuumCleanerSetIterator.next();
            if (next.getId() == id) {
                vacuumCleanerSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<VacuumCleaner> vacuumCleaners = ConverterService.readVacuumCleanersFile(strings);
        for (VacuumCleaner vacuumCleaner : vacuumCleaners) {
            writeIntoFile(vacuumCleaner);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        vacuumCleanerSet.clear();
    }

    public static VacuumCleaner findById(long id) {
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            if (vacuumCleaner.getId() == id) {
                return vacuumCleaner;
            }
        }

        System.out.println("Vacuum cleaner by ID: " + id + " does not exist");
        return null;
    }

    public static Set<VacuumCleaner> findByModel(Set<VacuumCleaner> vacuumCleaners, String model) {
        Set<VacuumCleaner> vacuumCleanerSet;
        if (vacuumCleaners == null) {
            vacuumCleanerSet = VacuumCleanerService.vacuumCleanerSet;
        } else {
            vacuumCleanerSet = vacuumCleaners;
        }
        Set<VacuumCleaner> byModel = new HashSet<>();
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            if (vacuumCleaner.getModel().equals(model)) {
                byModel.add(vacuumCleaner);
            }
        }

        return byModel;
    }

    public static Set<VacuumCleaner> findByPrice(Set<VacuumCleaner> vacuumCleaners, double from, double to) {
        Set<VacuumCleaner> vacuumCleanerSet;
        if (vacuumCleaners == null) {
            vacuumCleanerSet = VacuumCleanerService.vacuumCleanerSet;
        } else {
            vacuumCleanerSet = vacuumCleaners;
        }
        int nullCounter = 0;
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            if (vacuumCleaner.getPrice() < from || vacuumCleaner.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == vacuumCleanerSet.size()) {
            System.out.println("Vacuum cleaner by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<VacuumCleaner> byPriceRange = new HashSet<>();
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            double price = vacuumCleaner.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(vacuumCleaner);
            }
        }

        return byPriceRange;
    }

    public static Set<VacuumCleaner> findByYear(Set<VacuumCleaner> vacuumCleaners, int year) {
        Set<VacuumCleaner> vacuumCleanerSet;
        if (vacuumCleaners == null) {
            vacuumCleanerSet = VacuumCleanerService.vacuumCleanerSet;
        } else {
            vacuumCleanerSet = vacuumCleaners;
        }
        Set<VacuumCleaner> byYear = new HashSet<>();
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            if (vacuumCleaner.getYear() == year) {
                byYear.add(vacuumCleaner);
            }
        }

        return byYear;
    }

    public static Set<VacuumCleaner> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<VacuumCleaner> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<VacuumCleaner> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<VacuumCleaner> findByAddingDate(Set<VacuumCleaner> vacuumCleaners, String date) {
        Set<VacuumCleaner> vacuumCleanerSet;
        if (vacuumCleaners == null) {
            vacuumCleanerSet = VacuumCleanerService.vacuumCleanerSet;
        } else {
            vacuumCleanerSet = vacuumCleaners;
        }
        Set<VacuumCleaner> byAddingDate = new HashSet<>();
        for (VacuumCleaner vacuumCleaner : vacuumCleanerSet) {
            String cameraDate = vacuumCleaner.getDate().substring(0, vacuumCleaner.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(vacuumCleaner);
            }
        }

        return byAddingDate;
    }

    public static VacuumCleaner newer() {
        return Collections.max(vacuumCleanerSet, new YearComparator());
    }

    public static VacuumCleaner older() {
        return Collections.min(vacuumCleanerSet, new YearComparator());
    }

    public static VacuumCleaner biggerCost() {
        return Collections.max(vacuumCleanerSet, new CostComparator());
    }

    public static VacuumCleaner smallerCost() {
        return Collections.min(vacuumCleanerSet, new CostComparator());
    }

    public static VacuumCleaner newerAdded() {
        return Collections.max(vacuumCleanerSet, new DateComparator());
    }

    public static VacuumCleaner olderAdded() {
        return Collections.min(vacuumCleanerSet, new DateComparator());
    }

    public static List<VacuumCleaner> ascendingOrderByPrice() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new CostComparator());
        return vacuumCleaners;
    }

    public static List<VacuumCleaner> descendingOrderByPrice() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new CostComparator().reversed());
        return vacuumCleaners;
    }

    public static List<VacuumCleaner> ascendingOrderByYear() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new YearComparator());
        return vacuumCleaners;
    }

    public static List<VacuumCleaner> descendingOrderByYear() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new YearComparator().reversed());
        return vacuumCleaners;
    }

    public static List<VacuumCleaner> ascendingOrderByAddingDate() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new DateComparator());
        return vacuumCleaners;
    }

    public static List<VacuumCleaner> descendingOrderByAddingDate() {
        List<VacuumCleaner> vacuumCleaners = new ArrayList<>(vacuumCleanerSet);
        vacuumCleaners.sort(new DateComparator(true));
        return vacuumCleaners;
    }

    private static List<VacuumCleaner> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readVacuumCleanersFile(strings);
    }

    private static void writeIntoFile(VacuumCleaner vacuumCleaner) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + vacuumCleaner.getId())
                .append("\nModel: " + vacuumCleaner.getModel())
                .append("\nType: " + vacuumCleaner.getType())
                .append("\nPipe-type: " + vacuumCleaner.getPipeType())
                .append("\nDust-collector: " + vacuumCleaner.getDustCollector())
                .append("\nType-of-management: " + vacuumCleaner.getTypeOfManagement())
                .append("\nColor: " + vacuumCleaner.getColor())
                .append("\nFloor-and-carpet-knob: " + ((vacuumCleaner.isFloorAndCarpetKnob()) ? "have" : "haven't"))
                .append("\nSoft-furniture-knob: " + ((vacuumCleaner.isSoftFurnitureKnob()) ? "have" : "haven't"))
                .append("\nCorners-knob: " + ((vacuumCleaner.isCornersKnob()) ? "have" : "haven't"))
                .append("\nPower: " + vacuumCleaner.getPower())
                .append("\nPower-consumption: " + vacuumCleaner.getPowerConsumption())
                .append("\nYear: " + vacuumCleaner.getYear())
                .append("\nPrice: " + vacuumCleaner.getPrice())
                .append("\nDate: " + vacuumCleaner.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<VacuumCleaner> vacuumCleaners) throws IOException {
        if (vacuumCleaners == null) {
            vacuumCleaners = readFromFile();
            for (VacuumCleaner vacuumCleaner : vacuumCleaners) {
                System.out.println(vacuumCleaner.toString());
            }
            return;
        }
        if (!vacuumCleaners.isEmpty()) {
            for (VacuumCleaner vacuumCleaner : vacuumCleaners) {
                print(vacuumCleaner);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(VacuumCleaner vacuumCleaner) {
        System.out.println(vacuumCleaner.toString());
    }
}
