package picsart.service;

import picsart.model.computer.Computer;
import picsart.model.tv.Tv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class TVService {
    private static final String FILE_PATH = "src/picsart/files/tvs.txt";

    public static Tv create() throws IOException {
        System.out.println("Create TV:\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter screen type:");
        String screenType = scanner.nextLine();
        while (screenType.equals("")) {
            System.out.println("Screen type have not to be blank: ");
            screenType = scanner.nextLine();
        }
        System.out.println("Enter resolution:");
        String resolution = scanner.nextLine();
        while (resolution.equals("")) {
            System.out.println("resolution have not to be blank: ");
            resolution = scanner.nextLine();
        }
        System.out.println("Enter features '3d' or 'smart':");
        String features3dOrSmart = scanner.nextLine();
        while (features3dOrSmart.equals("")) {
            System.out.println("features have not to be blank: ");
            features3dOrSmart = scanner.nextLine();
        }
        System.out.println("Enter 3d technologies 'active 3d' or 'passive 3d' or 'not 3d':");
        String technologies3d = scanner.nextLine();
        while (!technologies3d.equals("active 3d") && !technologies3d.equals("passive 3d") && !technologies3d.equals("not 3d")) {
            System.out.println("3D technologies must be or 'active 3d' or 'passive 3d' or 'not 3d': ");
            technologies3d = scanner.nextLine();
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

        System.out.println("Enter screen size:");
        String screenSize = scanner.nextLine();
        while (screenSize.equals("")) {
            System.out.println("Power have not to be blank: ");
            screenSize = scanner.nextLine();
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
        System.out.println("Enter refresh rate:");
        int refreshRate = scanner.nextInt();
        while (refreshRate != 60 && refreshRate != 120 && refreshRate != 240) {
            System.out.println("Refresh rate must be '60', '120', '240' Hz: ");
            refreshRate = scanner.nextInt();
        }

        Tv tv = new Tv(IDGenerator.generateID(9));
        tv.setTechnologies3d(technologies3d);
        tv.setScreenType(screenType);
        tv.setScreenSize(screenSize);
        tv.setResolution(resolution);
        tv.setRefreshRate(refreshRate);
        tv.setFeatures3dOrSmart(features3dOrSmart);
        tv.setModel(model);
        tv.setPower(power);
        tv.setPowerConsumption(powerConsumption);
        tv.setPrice(price);
        tv.setYear(year);

        writeIntoFile(tv);
        return tv;
    }

    public static Tv[] createTvs(int size) throws IOException {
        Tv[] tvs = new Tv[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Creating TV number: " + (i + 1));
            tvs[i] = create();
        }

        return tvs;
    }

    public static Tv findById(long id) throws IOException {
        Tv[] computers = readTVsFromFile();
        for (Tv tv : computers) {
            if (tv.getId() == id) {
                System.out.println(tv.toString());
                return tv;
            }
        }

        System.out.println("TV by ID: " + id + " does not exist:");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        Tv[] tvs = readTVsFromFile();
        boolean isFound = false;
        for (int i = 0; i < tvs.length; i++) {
            Tv tv = tvs[i];
            if (tv.getModel().equals(model)) {
                System.out.println(tv.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == tvs.length - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no TV by model: " + model);
        }
    }

    public static Tv[] findByPrice(double from, double to) throws IOException {
        Tv[] tvs = readTVsFromFile();
        int nullCounter = 0;
        for (Tv tv : tvs) {
            if (tv.getPrice() < from || tv.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == tvs.length) {
            System.out.println("TVs by range " + from + "$ to " + to + "$ has noy found:");
            return new Tv[0];
        }
        int index = 0;
        Tv[] selectedTVsByPriceRange = new Tv[tvs.length - nullCounter];
        for (Tv tv : tvs) {
            double price = tv.getPrice();
            if (price >= from && price <= to) {
                selectedTVsByPriceRange[index++] = tv;
            }
        }

        printAll(selectedTVsByPriceRange);
        return selectedTVsByPriceRange;
    }

    public static Tv newerTv() throws IOException {
        Tv[] tvs = readTVsFromFile();
        Tv newerTv = tvs[0];
        for (Tv tv : tvs) {
            if (tv.getYear() >= newerTv.getYear()) {
                newerTv = tv;
            }
        }

        printTv(newerTv);
        return newerTv;
    }

    public static Tv olderTv() throws IOException {
        Tv[] computers = readTVsFromFile();
        Tv olderTv = computers[0];
        for (Tv tv : computers) {
            if (tv.getYear() < olderTv.getYear()) {
                olderTv = tv;
            }
        }

        printTv(olderTv);
        return olderTv;
    }

    public static Tv biggerCost() throws IOException {
        Tv[] tvs = readTVsFromFile();
        Tv biggerCostTv = tvs[0];
        for (Tv tv : tvs) {
            if (tv.getPrice() > biggerCostTv.getPrice()) {
                biggerCostTv = tv;
            }
        }

        printTv(biggerCostTv);
        return biggerCostTv;
    }

    public static Tv smallerCost() throws IOException {
        Tv[] tvs = readTVsFromFile();
        Tv smallerCostTv = tvs[0];
        for (Tv tv : tvs) {
            if (tv.getPrice() < smallerCostTv.getPrice()) {
                smallerCostTv = tv;
            }
        }

        printTv(smallerCostTv);
        return smallerCostTv;
    }

    public static Tv[] ascendingOrderByPrice() throws IOException {
        Tv[] tvs = readTVsFromFile();
        for (int i = 0; i < tvs.length; i++) {
            for (int j = 1; j < tvs.length - i; j++) {
                if (tvs[j - 1].getPrice() > tvs[j].getPrice()) {
                    Tv temp = tvs[j];
                    tvs[j] = tvs[j - 1];
                    tvs[j - 1] = temp;
                }
            }
        }

        printAll(tvs);
        return tvs;
    }

    public static Tv[] descendingOrderByPrice() throws IOException {
        Tv[] tvs = readTVsFromFile();
        for (int i = 0; i < tvs.length; i++) {
            for (int j = 1; j < tvs.length - i; j++) {
                if (tvs[j - 1].getPrice() < tvs[j].getPrice()) {
                    Tv temp = tvs[j];
                    tvs[j] = tvs[j - 1];
                    tvs[j - 1] = temp;
                }
            }
        }

        printAll(tvs);
        return tvs;
    }

    public static Tv[] ascendingOrderByYear() throws IOException {
        Tv[] tvs = readTVsFromFile();
        for (int i = 0; i < tvs.length; i++) {
            for (int j = 1; j < tvs.length - i; j++) {
                if (tvs[j - 1].getYear() > tvs[j].getYear()) {
                    Tv temp = tvs[j];
                    tvs[j] = tvs[j - 1];
                    tvs[j - 1] = temp;
                }
            }
        }

        printAll(tvs);
        return tvs;
    }

    public static Tv[] descendingOrderByYear() throws IOException {
        Tv[] tvs = readTVsFromFile();
        for (int i = 0; i < tvs.length; i++) {
            for (int j = 1; j < tvs.length - i; j++) {
                if (tvs[j - 1].getYear() < tvs[j].getYear()) {
                    Tv temp = tvs[j];
                    tvs[j] = tvs[j - 1];
                    tvs[j - 1] = temp;
                }
            }
        }

        printAll(tvs);
        return tvs;
    }

    private static Tv[] readTVsFromFile() throws IOException {
        String[] strings = Files.readAllLines(Path.of(FILE_PATH)).toArray(new String[0]);

        return ConverterService.readTvsFile(strings);
    }

    private static void writeIntoFile(Tv tv) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + tv.getId())
                .append("\nTV-model: " + tv.getModel())
                .append("\nScreen-type: " + tv.getScreenType())
                .append("\nScreen-size: " + tv.getScreenSize())
                .append("\nResolution: " + tv.getResolution())
                .append("\nFeatures: " + tv.getFeatures3dOrSmart())
                .append("\nRefresh-Rate: " + tv.getRefreshRate())
                .append("\nTechnologies-3d: " + tv.getTechnologies3d())
                .append("\nPower: " + tv.getPower())
                .append("\nPower-consumption: " + tv.getPowerConsumption())
                .append("\nYear: " + tv.getYear())
                .append("\nPrice: " + tv.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Tv[] tvs) throws IOException {
        if (tvs == null) {
            tvs = readTVsFromFile();
            for (Tv tv : tvs) {
                System.out.println(tv.toString());
            }
            return;
        }
        for (Tv tv : tvs) {
            System.out.println(tv.toString());
        }
    }

    public static void printTv(Tv tv) {
        System.out.println(tv.toString());
    }
}
