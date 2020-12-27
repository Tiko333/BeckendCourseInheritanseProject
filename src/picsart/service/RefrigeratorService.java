package picsart.service;

import picsart.comparators.refrigeratorComparators.CostComparator;
import picsart.comparators.refrigeratorComparators.DateComparator;
import picsart.comparators.refrigeratorComparators.YearComparator;
import picsart.model.refrigerator.Refrigerator;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class RefrigeratorService {

    private static String path = FilePaths.REFRIGERATOR.getValue();

    private static Set<Refrigerator> refrigeratorSet;

    static {
        try {
            refrigeratorSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private RefrigeratorService() {}

    public static Refrigerator create() throws IOException {
        System.out.println("Create refrigerator\n");
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
        System.out.println("Enter energy consumption class:");
        String energyConsumptionClass = scanner.nextLine();
        while (energyConsumptionClass.equals("")) {
            System.out.println("Energy consumption class have not to be blank: ");
            energyConsumptionClass = scanner.nextLine();
        }
        System.out.println("Enter dimensions:");
        String dimensions = scanner.nextLine();
        while (dimensions.equals("")) {
            System.out.println("Dimensions have not to be blank: ");
            dimensions = scanner.nextLine();
        }
        System.out.println("Enter freezer position:");
        String freezerPosition = scanner.nextLine();
        while (freezerPosition.equals("")) {
            System.out.println("Freezer position have not to be blank: ");
            freezerPosition = scanner.nextLine();
        }
        System.out.println("Enter freezer volume:");
        int freezerVolume = scanner.nextInt();
        while (freezerVolume <= 0) {
            System.out.println("Freezer volume have be bigger than 0: ");
            freezerVolume = scanner.nextInt();
        }
        System.out.println("Enter total volume:");
        int totalVolume = scanner.nextInt();
        while (totalVolume <= 0) {
            System.out.println("Total volume have be bigger than 0: ");
            totalVolume = scanner.nextInt();
        }
        System.out.println("Enter refrigerator volume:");
        int refrigeratorVolume = scanner.nextInt();
        while (refrigeratorVolume <= 0) {
            System.out.println("Refrigerator volume have be bigger than 0: ");
            refrigeratorVolume = scanner.nextInt();
        }
        System.out.println("Enter shelf material:");
        scanner.nextLine();
        String shelfMaterial = scanner.nextLine();
        while (shelfMaterial.equals("")) {
            System.out.println("Shelf material have not to be blank: ");
            shelfMaterial = scanner.nextLine();
        }
        System.out.println("Enter management:");
        String management = scanner.nextLine();
        while (management.equals("")) {
            System.out.println("Management have not to be blank: ");
            management = scanner.nextLine();
        }
        System.out.println("Enter freshness chamber 'yes' or 'no':");
        boolean isHaveFreshnessChamber = false;
        String freshnessChamber = scanner.nextLine();
        while (!freshnessChamber.equals("yes") && !freshnessChamber.equals("no")) {
            System.out.println("Freshness chamber have not to be blank insert 'yes' or 'no': ");
            freshnessChamber = scanner.nextLine();
        }
        if (freshnessChamber.equals("yes")) {
            isHaveFreshnessChamber = true;
        }
        System.out.println("Enter de frost 'yes' or 'no':");
        boolean isHaveDeFrost = false;
        String deFrost = scanner.nextLine();
        while (!deFrost.equals("yes") && !deFrost.equals("no")) {
            System.out.println("De frost have not to be blank insert 'yes' or 'no': ");
            deFrost = scanner.nextLine();
        }
        if (deFrost.equals("yes")) {
            isHaveDeFrost = true;
        }
        System.out.println("Enter no frost 'yes' or 'no':");
        boolean isHaveNoFrost = false;
        String noFrost = scanner.nextLine();
        while (!noFrost.equals("yes") && !noFrost.equals("no")) {
            System.out.println("No frost have not to be blank insert 'yes' or 'no': ");
            noFrost = scanner.nextLine();
        }
        if (noFrost.equals("yes")) {
            isHaveNoFrost = true;
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
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        while (year < 2000 || year > 2020) {
            System.out.println("Year must be bigger than 2000 and smaller than 2020: ");
            year = scanner.nextInt();
        }

        Refrigerator refrigerator = new Refrigerator(IDGenerator.generateID(9));
        refrigerator.setModel(model);
        refrigerator.setColor(color);
        refrigerator.setDeFrost(isHaveDeFrost);
        refrigerator.setDimensions(dimensions);
        refrigerator.setEnergyConsumptionClass(energyConsumptionClass);
        refrigerator.setFreezerPosition(freezerPosition);
        refrigerator.setFreezerVolume(freezerVolume);
        refrigerator.setFreshnessChamber(isHaveFreshnessChamber);
        refrigerator.setManagement(management);
        refrigerator.setNoFrost(isHaveNoFrost);
        refrigerator.setRefrigeratorVolume(refrigeratorVolume);
        refrigerator.setShelfMaterial(shelfMaterial);
        refrigerator.setTotalVolume(totalVolume);
        refrigerator.setType(type);
        refrigerator.setPower(power);
        refrigerator.setPowerConsumption(powerConsumption);
        refrigerator.setPrice(price);
        refrigerator.setYear(year);

        writeIntoFile(refrigerator);
        refrigeratorSet.add(refrigerator);
        return refrigerator;
    }

    public static List<Refrigerator> multipleCreate(int size) throws IOException {
        List<Refrigerator> refrigerators = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating refrigerator number: " + (i + 1));
            refrigerators.add(create());
        }

        return refrigerators;
    }

    public static void updateById(int id) throws IOException {
        Refrigerator refrigerator = findById(id);
        if (refrigerator == null) {
            return;
        }
        deleteById(id);
        refrigeratorSet.remove(refrigerator);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter type:");
        String type = scanner.nextLine();

        System.out.println("Enter energy consumption class:");
        String energyConsumptionClass = scanner.nextLine();

        System.out.println("Enter dimensions:");
        String dimensions = scanner.nextLine();

        System.out.println("Enter freezer position:");
        String freezerPosition = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter shelf material:");
        String shelfMaterial = scanner.nextLine();

        System.out.println("Enter shelf management:");
        String management = scanner.nextLine();

        System.out.println("Enter color:");
        String color = scanner.nextLine();

        System.out.println("Enter freshness chamber 'yes' or 'no':");
        boolean isHaveFreshnessChamber = false;
        String freshnessChamber = scanner.nextLine();
        while (!freshnessChamber.equals("yes") && !freshnessChamber.equals("no")) {
            System.out.println("freshness chamber have not to be blank insert 'yes' or 'no': ");
            freshnessChamber = scanner.nextLine();
        }
        if (freshnessChamber.equals("yes")) {
            isHaveFreshnessChamber = true;
        }

        System.out.println("Enter de frost 'yes' or 'no':");
        boolean isHaveDeFrost = false;
        String deFrost = scanner.nextLine();
        while (!deFrost.equals("yes") && !deFrost.equals("no")) {
            System.out.println("de frost have not to be blank insert 'yes' or 'no': ");
            deFrost = scanner.nextLine();
        }
        if (deFrost.equals("yes")) {
            isHaveDeFrost = true;
        }

         System.out.println("Enter no Frost 'yes' or 'no':");
        boolean isHaveNoFrost = false;
        String noFrost = scanner.nextLine();
        while (!noFrost.equals("yes") && !noFrost.equals("no")) {
            System.out.println("no Frost have not to be blank insert 'yes' or 'no': ");
            noFrost = scanner.nextLine();
        }
        if (noFrost.equals("yes")) {
            isHaveNoFrost = true;
        }

        System.out.println("Enter freezer volume 0 to skip:");
        int freezerVolume = scanner.nextInt();

        System.out.println("Enter total volume 0 to skip:");
        int totalVolume = scanner.nextInt();

         System.out.println("Enter refrigerator volume 0 to skip:");
        int refrigeratorVolume = scanner.nextInt();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter price 0 to skip:");
        double weight = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!model.equals("")) {
            refrigerator.setModel(model);
        }
        if (!type.equals("")) {
            refrigerator.setType(type);
        }
        if (!energyConsumptionClass.equals("")) {
            refrigerator.setEnergyConsumptionClass(energyConsumptionClass);
        }
        if (!dimensions.equals("")) {
            refrigerator.setDimensions(dimensions);
        }
        if (!freezerPosition.equals("")) {
            refrigerator.setFreezerPosition(freezerPosition);
        }
        if (!shelfMaterial.equals("")) {
            refrigerator.setShelfMaterial(shelfMaterial);
        }
        if (!management.equals("")) {
            refrigerator.setManagement(management);
        }
        if (!color.equals("")) {
            refrigerator.setColor(color);
        }
        if (freezerVolume > 0) {
            refrigerator.setFreezerVolume(freezerVolume);
        }
        if (totalVolume > 0) {
            refrigerator.setTotalVolume(totalVolume);
        }
        if (refrigeratorVolume > 0) {
            refrigerator.setRefrigeratorVolume(refrigeratorVolume);
        }
        refrigerator.setFreshnessChamber(isHaveFreshnessChamber);
        refrigerator.setDeFrost(isHaveDeFrost);
        refrigerator.setNoFrost(isHaveNoFrost);
        if (!power.equals("")) {
            refrigerator.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            refrigerator.setPowerConsumption(powerConsumption);
        }
        if (price > 0) {
            refrigerator.setPrice(price);
        }
        if (weight > 0) {
            refrigerator.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            refrigerator.setYear(year);
        }

        writeIntoFile(refrigerator);
        refrigeratorSet.add(refrigerator);
    }

    public static boolean checkId(int id) {
        Iterator<Refrigerator> iterator = refrigeratorSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Refrigerator next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Refrigerator by id " + id + " does not exist:");
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

        Iterator<Refrigerator> refrigeratorSetIterator = refrigeratorSet.iterator();
        while (refrigeratorSetIterator.hasNext()) {
            Refrigerator next = refrigeratorSetIterator.next();
            if (next.getId() == id) {
                refrigeratorSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Refrigerator> refrigerators = ConverterService.readRefrigeratorsFile(strings);
        for (Refrigerator refrigerator : refrigerators) {
            writeIntoFile(refrigerator);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        refrigeratorSet.clear();
    }

    public static Refrigerator findById(long id) throws IOException {
        for (Refrigerator refrigerator : readFromFile()) {
            if (refrigerator.getId() == id) {
                return refrigerator;
            }
        }

        System.out.println("Refrigerator by ID: " + id + " does not exist");
        return null;
    }

    public static List<Refrigerator> findByModel(List<Refrigerator> refrigerators, String model) throws IOException {
        List<Refrigerator> refrigeratorList;
        if (refrigerators == null) {
            refrigeratorList = readFromFile();
        } else {
            refrigeratorList = refrigerators;
        }
        List<Refrigerator> byModel = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            if (refrigerator.getModel().equals(model)) {
                byModel.add(refrigerator);
            }
        }

        return byModel;
    }

    public static List<Refrigerator> findByPrice(List<Refrigerator> refrigerators, double from, double to) throws IOException {
        List<Refrigerator> refrigeratorList;
        if (refrigerators == null) {
            refrigeratorList = readFromFile();
        } else {
            refrigeratorList = refrigerators;
        }
        int nullCounter = 0;
        for (Refrigerator refrigerator : refrigeratorList) {
            if (refrigerator.getPrice() < from || refrigerator.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == refrigeratorList.size()) {
            System.out.println("Refrigerators by range " + from + "$ to " + to + "$ has noy found:");
            return new ArrayList<>();
        }

        List<Refrigerator> byPriceRange = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            double price = refrigerator.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(refrigerator);
            }
        }

        return byPriceRange;
    }

    public static List<Refrigerator> findByYear(List<Refrigerator> refrigerators, int year) throws IOException {
        List<Refrigerator> refrigeratorList;
        if (refrigerators == null) {
            refrigeratorList = readFromFile();
        } else {
            refrigeratorList = refrigerators;
        }
        List<Refrigerator> byYear = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            if (refrigerator.getYear() == year) {
                byYear.add(refrigerator);
            }
        }

        return byYear;
    }

    public static List<Refrigerator> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Refrigerator> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Refrigerator> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Refrigerator> findByAddingDate(List<Refrigerator> refrigerators, String date) throws IOException {
        List<Refrigerator> refrigeratorList;
        if (refrigerators == null) {
            refrigeratorList = readFromFile();
        } else {
            refrigeratorList = refrigerators;
        }
        List<Refrigerator> byAddingDate = new ArrayList<>();
        for (Refrigerator refrigerator : refrigeratorList) {
            String cameraDate = refrigerator.getDate().substring(0, refrigerator.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(refrigerator);
            }
        }

        return byAddingDate;
    }

    public static Refrigerator newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Refrigerator older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Refrigerator biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Refrigerator smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Refrigerator newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Refrigerator olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Refrigerator> ascendingOrderByPrice() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new CostComparator());
        return refrigerators;
    }

    public static List<Refrigerator> descendingOrderByPrice() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new CostComparator().reversed());
        return refrigerators;
    }

    public static List<Refrigerator> ascendingOrderByYear() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new YearComparator());
        return refrigerators;
    }

    public static List<Refrigerator> descendingOrderByYear() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new YearComparator().reversed());
        return refrigerators;
    }

    public static List<Refrigerator> ascendingOrderByAddingDate() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new DateComparator());
        return refrigerators;
    }

    public static List<Refrigerator> descendingOrderByAddingDate() throws IOException {
        List<Refrigerator> refrigerators = readFromFile();
        refrigerators.sort(new DateComparator(true));
        return refrigerators;
    }

    private static List<Refrigerator> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readRefrigeratorsFile(strings);
    }

    private static void writeIntoFile(Refrigerator refrigerator) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + refrigerator.getId())
                .append("\nModel: " + refrigerator.getModel())
                .append("\nType: " + refrigerator.getType())
                .append("\nEnergy-consumption-class: " + refrigerator.getEnergyConsumptionClass())
                .append("\nDimensions: " + refrigerator.getDimensions())
                .append("\nFreezer-position: " + refrigerator.getFreezerPosition())
                .append("\nFreezer-volume: " + refrigerator.getFreezerVolume())
                .append("\nTotal-volume: " + refrigerator.getTotalVolume())
                .append("\nRefrigerator-volume: " + refrigerator.getRefrigeratorVolume())
                .append("\nShelf-material: " + refrigerator.getShelfMaterial())
                .append("\nManagement: " + refrigerator.getManagement())
                .append("\nColor: " + refrigerator.getColor())
                .append("\nFreshness-chamber: " + ((refrigerator.isFreshnessChamber()) ? "have" : "haven't"))
                .append("\nDe-frost: " + ((refrigerator.isDeFrost()) ? "have" : "haven't"))
                .append("\nNo-frost: " + ((refrigerator.isNoFrost()) ? "have" : "haven't"))
                .append("\nPower: " + refrigerator.getPower())
                .append("\nPower-consumption: " + refrigerator.getPowerConsumption())
                .append("\nYear: " + refrigerator.getYear())
                .append("\nPrice: " + refrigerator.getPrice())
                .append("\nDate: " + refrigerator.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Refrigerator> refrigerators) throws IOException {
        if (refrigerators == null) {
            refrigerators = readFromFile();
            for (Refrigerator refrigerator : refrigerators) {
                System.out.println(refrigerator.toString());
            }
            return;
        }
        if (!refrigerators.isEmpty()) {
            for (Refrigerator refrigerator : refrigerators) {
                print(refrigerator);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(Refrigerator refrigerator) {
        System.out.println(refrigerator.toString());
    }

}
