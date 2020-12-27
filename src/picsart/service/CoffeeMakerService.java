package picsart.service;

import picsart.comparators.coffeeMakerComparators.CostComparator;
import picsart.comparators.coffeeMakerComparators.DateComparator;
import picsart.comparators.coffeeMakerComparators.YearComparator;
import picsart.model.coffeeMaker.CoffeeMaker;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CoffeeMakerService {

    private static String path = FilePaths.COFFEE_MAKER.getValue();
    private static Set<CoffeeMaker> coffeeMakerSet;

    static {
        try {
            coffeeMakerSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CoffeeMakerService() {
    }

    public static CoffeeMaker create() throws IOException {
        System.out.println("Create coffee maker\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter coffee type:");
        String coffeeType = scanner.nextLine();
        while (coffeeType.equals("")) {
            System.out.println("Coffee type have not to be blank: ");
            coffeeType = scanner.nextLine();
        }
        System.out.println("Enter capacity:");
        String capacity = scanner.nextLine();
        while (capacity.equals("")) {
            System.out.println("Capacity have not to be blank: ");
            capacity = scanner.nextLine();
        }
        System.out.println("Enter material of corpus:");
        String materialOfCorpus = scanner.nextLine();
        while (materialOfCorpus.equals("")) {
            System.out.println("Material of corpus have not to be blank: ");
            materialOfCorpus = scanner.nextLine();
        }
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        while (color.equals("")) {
            System.out.println("Color have not to be blank: ");
            color = scanner.nextLine();
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
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        while (weight < 1) {
            System.out.println("weight must be bigger than 0: ");
            weight = scanner.nextInt();
        }
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        while (year < 2000 || year > 2020) {
            System.out.println("Year must be bigger than 2000 and smaller than 2020: ");
            year = scanner.nextInt();
        }

        CoffeeMaker coffeeMaker = new CoffeeMaker(IDGenerator.generateID(9));
        coffeeMaker.setModel(model);
        coffeeMaker.setPower(power);
        coffeeMaker.setPowerConsumption(powerConsumption);
        coffeeMaker.setPrice(price);
        coffeeMaker.setYear(year);
        coffeeMaker.setCapacity(capacity);
        coffeeMaker.setCoffeeType(coffeeType);
        coffeeMaker.setColor(color);
        coffeeMaker.setMaterialOfCorpus(materialOfCorpus);
        coffeeMaker.setWeight(weight);
        writeIntoFile(coffeeMaker);
        coffeeMakerSet.add(coffeeMaker);
        return coffeeMaker;
    }

    public static Set<CoffeeMaker> multipleCreate(int size) throws IOException {
        Set<CoffeeMaker> coffeeMakers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating coffee maker number: " + (i + 1));
            coffeeMakers.add(create());
        }

        return coffeeMakers;
    }

    public static void updateById(int id) throws IOException {
        CoffeeMaker coffeeMaker = findById(id);
        if (coffeeMaker == null) {
            return;
        }
        deleteById(id);
        coffeeMakerSet.remove(coffeeMaker);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter coffee type:");
        String coffeeType = scanner.nextLine();

        System.out.println("Enter capacity:");
        String capacity = scanner.nextLine();

        System.out.println("Enter material of corpus:");
        String materialOfCorpus = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter weight 0 to skip:");
        int weight = scanner.nextInt();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!coffeeType.equals("")) {
            coffeeMaker.setCoffeeType(coffeeType);
        }
        if (!capacity.equals("")) {
            coffeeMaker.setCapacity(capacity);
        }
        if (!materialOfCorpus.equals("")) {
            coffeeMaker.setMaterialOfCorpus(materialOfCorpus);
        }
        if (!color.equals("")) {
            coffeeMaker.setColor(color);
        }
        if (!model.equals("")) {
            coffeeMaker.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            coffeeMaker.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            coffeeMaker.setPower(power);
        }
        if (price > 0) {
            coffeeMaker.setPrice(price);
        }
        if (weight > 0) {
            coffeeMaker.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            coffeeMaker.setYear(year);
        }

        writeIntoFile(coffeeMaker);
        coffeeMakerSet.add(coffeeMaker);
    }

    public static boolean checkId(int id) {
        Iterator<CoffeeMaker> iterator = coffeeMakerSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            CoffeeMaker next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Coffee maker by id " + id + " does not exist:");
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

        Iterator<CoffeeMaker> coffeeMakerSetIterator = coffeeMakerSet.iterator();
        while (coffeeMakerSetIterator.hasNext()) {
            CoffeeMaker next = coffeeMakerSetIterator.next();
            if (next.getId() == id) {
                coffeeMakerSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<CoffeeMaker> coffeeMakers = ConverterService.readCoffeeMakersFile(strings);
        for (CoffeeMaker coffeeMaker : coffeeMakers) {
            writeIntoFile(coffeeMaker);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        coffeeMakerSet.clear();
    }

    public static CoffeeMaker findById(long id) {
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            if (coffeeMaker.getId() == id) {
                return coffeeMaker;
            }
        }

        System.out.println("Coffee maker by ID: " + id + " does not exist");
        return null;
    }

    public static Set<CoffeeMaker> findByModel(Set<CoffeeMaker> coffeeMakers, String model) {
        Set<CoffeeMaker> coffeeMakerSet;
        if (coffeeMakers == null) {
            coffeeMakerSet = CoffeeMakerService.coffeeMakerSet;
        } else {
            coffeeMakerSet = coffeeMakers;
        }
        Set<CoffeeMaker> byModel = new HashSet<>();
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            if (coffeeMaker.getModel().equals(model)) {
                byModel.add(coffeeMaker);
            }
        }

        return byModel;
    }

    public static Set<CoffeeMaker> findByPrice(Set<CoffeeMaker> coffeeMakers, double from, double to) {
        Set<CoffeeMaker> coffeeMakerSet;
        if (coffeeMakers == null) {
            coffeeMakerSet = CoffeeMakerService.coffeeMakerSet;
        } else {
            coffeeMakerSet = coffeeMakers;
        }
        int nullCounter = 0;
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            if (coffeeMaker.getPrice() < from || coffeeMaker.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == coffeeMakerSet.size()) {
            System.out.println("Coffee makers by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<CoffeeMaker> byPriceRange = new HashSet<>();
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            double price = coffeeMaker.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(coffeeMaker);
            }
        }

        return byPriceRange;
    }

    public static Set<CoffeeMaker> findByYear(Set<CoffeeMaker> coffeeMakers, int year) {
        Set<CoffeeMaker> coffeeMakerSet;
        if (coffeeMakers == null) {
            coffeeMakerSet = CoffeeMakerService.coffeeMakerSet;
        } else {
            coffeeMakerSet = coffeeMakers;
        }
        Set<CoffeeMaker> byYear = new HashSet<>();
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            if (coffeeMaker.getYear() == year) {
                byYear.add(coffeeMaker);
            }
        }

        return byYear;
    }

    public static Set<CoffeeMaker> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<CoffeeMaker> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<CoffeeMaker> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<CoffeeMaker> findByAddingDate(Set<CoffeeMaker> coffeeMakers, String date) {
        Set<CoffeeMaker> coffeeMakerSet;
        if (coffeeMakers == null) {
            coffeeMakerSet = CoffeeMakerService.coffeeMakerSet;
        } else {
            coffeeMakerSet = coffeeMakers;
        }
        Set<CoffeeMaker> byAddingDate = new HashSet<>();
        for (CoffeeMaker coffeeMaker : coffeeMakerSet) {
            String cameraDate = coffeeMaker.getDate().substring(0, coffeeMaker.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(coffeeMaker);
            }
        }

        return byAddingDate;
    }

    public static CoffeeMaker newer() {
        return Collections.max(coffeeMakerSet, new YearComparator());
    }

    public static CoffeeMaker older() {
        return Collections.min(coffeeMakerSet, new YearComparator());
    }

    public static CoffeeMaker biggerCost() {
        return Collections.max(coffeeMakerSet, new CostComparator());
    }

    public static CoffeeMaker smallerCost() {
        return Collections.min(coffeeMakerSet, new CostComparator());
    }

    public static CoffeeMaker newerAdded() {
        return Collections.max(coffeeMakerSet, new DateComparator());
    }

    public static CoffeeMaker olderAdded() {
        return Collections.min(coffeeMakerSet, new DateComparator());
    }

    public static List<CoffeeMaker> ascendingOrderByPrice() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new CostComparator());
        return coffeeMakers;
    }

    public static List<CoffeeMaker> descendingOrderByPrice() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new CostComparator().reversed());
        return coffeeMakers;
    }

    public static List<CoffeeMaker> ascendingOrderByYear() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new YearComparator());
        return coffeeMakers;
    }

    public static List<CoffeeMaker> descendingOrderByYear() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new YearComparator().reversed());
        return coffeeMakers;
    }

    public static List<CoffeeMaker> ascendingOrderByAddingDate() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new DateComparator());
        return coffeeMakers;
    }

    public static List<CoffeeMaker> descendingOrderByAddingDate() {
        List<CoffeeMaker> coffeeMakers = new ArrayList<>(coffeeMakerSet);
        coffeeMakers.sort(new DateComparator(true));
        return coffeeMakers;
    }

    private static List<CoffeeMaker> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readCoffeeMakersFile(strings);
    }

    private static void writeIntoFile(CoffeeMaker coffeeMaker) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + coffeeMaker.getId())
                .append("\nCoffee-maker-model: " + coffeeMaker.getModel())
                .append("\nCoffee-type: " + coffeeMaker.getCoffeeType())
                .append("\nCapacity: " + coffeeMaker.getCapacity())
                .append("\nMaterial-of-corpus: " + coffeeMaker.getMaterialOfCorpus())
                .append("\nColor: " + coffeeMaker.getColor())
                .append("\nWeight: " + coffeeMaker.getWeight())
                .append("\nPower: " + coffeeMaker.getPower())
                .append("\nPower-consumption: " + coffeeMaker.getPowerConsumption())
                .append("\nYear: " + coffeeMaker.getYear())
                .append("\nPrice: " + coffeeMaker.getPrice())
                .append("\nDate: " + coffeeMaker.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<CoffeeMaker> coffeeMakers) throws IOException {
        if (coffeeMakers == null) {
            coffeeMakers = readFromFile();
            for (CoffeeMaker coffeeMaker : coffeeMakers) {
                System.out.println(coffeeMaker.toString());
            }
            return;
        }
        if (!coffeeMakers.isEmpty()) {
            for (CoffeeMaker coffeeMaker : coffeeMakers) {
                print(coffeeMaker);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(CoffeeMaker coffeeMaker) {
        System.out.println(coffeeMaker.toString());
    }
}
