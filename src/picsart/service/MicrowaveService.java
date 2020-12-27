package picsart.service;

import picsart.comparators.microwaveComparators.*;
import picsart.model.microwave.Microwave;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class MicrowaveService {

    private static String path = FilePaths.MICROWAVE.getValue();
    private static Set<Microwave> microwaveSet;

    static {
        try {
            microwaveSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private MicrowaveService() {
    }

    public static Microwave create() throws IOException {
        System.out.println("Create microwave\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter oven capacity:");
        String ovenCapacity = scanner.nextLine();
        while (ovenCapacity.equals("")) {
            System.out.println("Oven capacity have not to be blank: ");
            ovenCapacity = scanner.nextLine();
        }
        System.out.println("Enter control:");
        String control = scanner.nextLine();
        while (control.equals("")) {
            System.out.println("Control have not to be blank: ");
            control = scanner.nextLine();
        }
        System.out.println("Enter switches:");
        String switches = scanner.nextLine();
        while (switches.equals("")) {
            System.out.println("Switches have not to be blank: ");
            switches = scanner.nextLine();
        }
        System.out.println("Enter dimension:");
        String dimension = scanner.nextLine();
        while (dimension.equals("")) {
            System.out.println("Dimension have not to be blank: ");
            dimension = scanner.nextLine();
        }
        System.out.println("Enter screen 'yes' or 'no':");
        boolean isHaveScreen = false;
        String screen = scanner.nextLine();
        while (!screen.equals("yes") && !screen.equals("no")) {
            System.out.println("Screen have not to be blank insert 'yes' or 'no': ");
            screen = scanner.nextLine();
        }
        if (screen.equals("yes")) {
            isHaveScreen = true;
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
        while (weight <= 0) {
            System.out.println("Weight must be bigger than 0: ");
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

        Microwave microwave = new Microwave(IDGenerator.generateID(9));
        microwave.setModel(model);
        microwave.setPower(power);
        microwave.setPowerConsumption(powerConsumption);
        microwave.setPrice(price);
        microwave.setYear(year);
        microwave.setControl(control);
        microwave.setDimension(dimension);
        microwave.setOvenCapacity(ovenCapacity);
        microwave.setScreen(isHaveScreen);
        microwave.setSwitches(switches);
        microwave.setWeight(weight);

        writeIntoFile(microwave);
        microwaveSet.add(microwave);
        return microwave;
    }

    public static Set<Microwave> multipleCreate(int size) throws IOException {
        Set<Microwave> microwaves = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating microwave number: " + (i + 1));
            microwaves.add(create());
        }

        return microwaves;
    }

    public static void updateById(int id) throws IOException {
        Microwave microwave = findById(id);
        if (microwave == null) {
            return;
        }
        deleteById(id);
        microwaveSet.remove(microwave);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter oven capacity:");
        String ovenCapacity = scanner.nextLine();

        System.out.println("Enter control:");
        String control = scanner.nextLine();

        System.out.println("Enter switches:");
        String switches = scanner.nextLine();

        System.out.println("Enter dimension:");
        String dimension = scanner.nextLine();

        System.out.println("Enter screen 'yes' or 'no':");
        boolean isHaveScreen = false;
        String screen = scanner.nextLine();
        while (!screen.equals("yes") && !screen.equals("no")) {
            System.out.println("Screen have not to be blank insert 'yes' or 'no': ");
            screen = scanner.nextLine();
        }
        if (screen.equals("yes")) {
            isHaveScreen = true;
        }

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter weight 0 to skip:");
        double weight = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!ovenCapacity.equals("")) {
            microwave.setOvenCapacity(ovenCapacity);
        }
        if (!control.equals("")) {
            microwave.setControl(control);
        }
        if (!switches.equals("")) {
            microwave.setSwitches(switches);
        }
        if (!dimension.equals("")) {
            microwave.setDimension(dimension);
        }
        microwave.setScreen(isHaveScreen);
        if (!model.equals("")) {
            microwave.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            microwave.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            microwave.setPower(power);
        }
        if (price > 0) {
            microwave.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            microwave.setYear(year);
        }
        if (weight > 0) {
            microwave.setWeight(weight);
        }

        writeIntoFile(microwave);
        microwaveSet.add(microwave);
    }

    public static boolean checkId(int id) {
        Iterator<Microwave> iterator = microwaveSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Microwave next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Microwave by id " + id + " does not exist:");
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

        Iterator<Microwave> microwaveSetIterator = microwaveSet.iterator();
        while (microwaveSetIterator.hasNext()) {
            Microwave next = microwaveSetIterator.next();
            if (next.getId() == id) {
                microwaveSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Microwave> microwaves = ConverterService.readMicrowavesFile(strings);
        for (Microwave microwave : microwaves) {
            writeIntoFile(microwave);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        microwaveSet.clear();
    }

    public static Microwave findById(long id) {
        for (Microwave microwave : microwaveSet) {
            if (microwave.getId() == id) {
                return microwave;
            }
        }

        System.out.println("Microwave by ID: " + id + " does not exist");
        return null;
    }

    public static Set<Microwave> findByModel(Set<Microwave> microwaves, String model) {
        Set<Microwave> microwaveSet;
        if (microwaves == null) {
            microwaveSet = MicrowaveService.microwaveSet;
        } else {
            microwaveSet = microwaves;
        }
        Set<Microwave> byModel = new HashSet<>();
        for (Microwave microwave : microwaveSet) {
            if (microwave.getModel().equals(model)) {
                byModel.add(microwave);
            }
        }

        return byModel;
    }

    public static Set<Microwave> findByPrice(Set<Microwave> microwaves, double from, double to) {
        Set<Microwave> microwaveSet;
        if (microwaves == null) {
            microwaveSet = MicrowaveService.microwaveSet;
        } else {
            microwaveSet = microwaves;
        }
        int nullCounter = 0;
        for (Microwave microwave : microwaveSet) {
            if (microwave.getPrice() < from || microwave.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == microwaveSet.size()) {
            System.out.println("Microwaves by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<Microwave> byPriceRange = new HashSet<>();
        for (Microwave microwave : microwaveSet) {
            double price = microwave.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(microwave);
            }
        }

        return byPriceRange;
    }

    public static Set<Microwave> findByYear(Set<Microwave> microwaves, int year) {
        Set<Microwave> microwaveSet;
        if (microwaves == null) {
            microwaveSet = MicrowaveService.microwaveSet;
        } else {
            microwaveSet = microwaves;
        }
        Set<Microwave> byYear = new HashSet<>();
        for (Microwave microwave : microwaveSet) {
            if (microwave.getYear() == year) {
                byYear.add(microwave);
            }
        }

        return byYear;
    }

    public static Set<Microwave> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<Microwave> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<Microwave> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<Microwave> findByAddingDate(Set<Microwave> microwaves, String date) {
        Set<Microwave> microwaveSet;
        if (microwaves == null) {
            microwaveSet = MicrowaveService.microwaveSet;
        } else {
            microwaveSet = microwaves;
        }
        Set<Microwave> byAddingDate = new HashSet<>();
        for (Microwave microwave : microwaveSet) {
            String cameraDate = microwave.getDate().substring(0, microwave.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(microwave);
            }
        }

        return byAddingDate;
    }

    public static Microwave newer() {
        return Collections.max(microwaveSet, new YearComparator());
    }

    public static Microwave older() {
        return Collections.min(microwaveSet, new YearComparator());
    }

    public static Microwave biggerCost() {
        return Collections.max(microwaveSet, new CostComparator());
    }

    public static Microwave smallerCost() {
        return Collections.min(microwaveSet, new CostComparator());
    }

    public static Microwave newerAdded() {
        return Collections.max(microwaveSet, new DateComparator());
    }

    public static Microwave olderAdded() {
        return Collections.min(microwaveSet, new DateComparator());
    }

    public static List<Microwave> ascendingOrderByPrice() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new CostComparator());
        return microwaves;
    }

    public static List<Microwave> descendingOrderByPrice() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new CostComparator().reversed());
        return microwaves;
    }

    public static List<Microwave> ascendingOrderByYear() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new YearComparator());
        return microwaves;
    }

    public static List<Microwave> descendingOrderByYear() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new YearComparator().reversed());
        return microwaves;
    }

    public static List<Microwave> ascendingOrderByAddingDate() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new DateComparator());
        return microwaves;
    }

    public static List<Microwave> descendingOrderByAddingDate() {
        List<Microwave> microwaves = new ArrayList<>(microwaveSet);
        microwaves.sort(new DateComparator(true));
        return microwaves;
    }

    private static List<Microwave> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readMicrowavesFile(strings);
    }

    private static void writeIntoFile(Microwave microwave) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + microwave.getId())
                .append("\nModel: " + microwave.getModel())
                .append("\nOven-capacity: " + microwave.getOvenCapacity())
                .append("\nControl: " + microwave.getControl())
                .append("\nSwitches: " + microwave.getSwitches())
                .append("\nDimension: " + microwave.getDimension())
                .append("\nWeight: " + microwave.getWeight())
                .append("\nScreen: " + ((microwave.isScreen()) ? "have" : "haven't"))
                .append("\nPower: " + microwave.getPower())
                .append("\nPower-consumption: " + microwave.getPowerConsumption())
                .append("\nYear: " + microwave.getYear())
                .append("\nPrice: " + microwave.getPrice())
                .append("\nDate: " + microwave.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<Microwave> microwaves) throws IOException {
        if (microwaves == null) {
            microwaves = readFromFile();
            for (Microwave microwave : microwaves) {
                System.out.println(microwave.toString());
            }
            return;
        }
        if (!microwaves.isEmpty()) {
            for (Microwave microwave : microwaves) {
                print(microwave);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Microwave microwave) {
        System.out.println(microwave.toString());
    }
}
