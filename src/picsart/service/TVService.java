package picsart.service;

import picsart.comparators.tvComparators.CostComparator;
import picsart.comparators.tvComparators.DateComparator;
import picsart.comparators.tvComparators.YearComparator;
import picsart.model.tv.Tv;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class TVService {
    private static String path = FilePaths.TV.getValue();

    private static Set<Tv> tvSet;

    static {
        try {
            tvSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TVService() {}

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
        tvSet.add(tv);
        return tv;
    }

    public static List<Tv> multipleCreate(int size) throws IOException {
        List<Tv> tvs = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating TV number: " + (i + 1));
            tvs.add(create());
        }

        return tvs;
    }

    public static void updateById(int id) throws IOException {
        Tv tv = findById(id);
        if (tv == null) {
            return;
        }
        deleteById(id);
        tvSet.remove(tv);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter screen type:");
        String screenType = scanner.nextLine();

        System.out.println("Enter screen size:");
        String screenSize = scanner.nextLine();

        System.out.println("Enter resolution:");
        String resolution = scanner.nextLine();

        System.out.println("Enter 3d or smart:");
        String features3dOrSmart = scanner.nextLine();

        System.out.println("Enter technologies3d:");
        String technologies3d = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter refresh rate:");
        int refreshRate = scanner.nextInt();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();

        if (!screenType.equals("")) {
            tv.setScreenType(screenType);
        }
        if (!resolution.equals("")) {
            tv.setResolution(resolution);
        }
        if (!features3dOrSmart.equals("")) {
            tv.setFeatures3dOrSmart(features3dOrSmart);
        }
        if (!technologies3d.equals("")) {
            tv.setTechnologies3d(technologies3d);
        }
        if (refreshRate == 60 || refreshRate == 120 || refreshRate == 240) {
            tv.setRefreshRate(refreshRate);
        }
        if (!screenSize.equals("")) {
            tv.setScreenSize(screenSize);
        }
        if (!model.equals("")) {
            tv.setModel(model);
        }
        if (!power.equals("")) {
            tv.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            tv.setPowerConsumption(powerConsumption);
        }
        if (!model.equals("")) {
            tv.setModel(model);
        }
        if (price != 0) {
            tv.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            tv.setYear(year);
        }

        writeIntoFile(tv);
        tvSet.add(tv);
    }

    public static boolean checkId(int id) {
        Iterator<Tv> iterator = tvSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Tv next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Tv by id " + id + " does not exist:");
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

        Iterator<Tv> tvSetIterator = tvSet.iterator();
        while (tvSetIterator.hasNext()) {
            Tv next = tvSetIterator.next();
            if (next.getId() == id) {
                tvSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Tv> laptops = ConverterService.readTvsFile(strings);
        for (Tv tv : laptops) {
            writeIntoFile(tv);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        tvSet.clear();
    }

    public static Tv findById(long id) throws IOException {
        for (Tv tv : readFromFile()) {
            if (tv.getId() == id) {
                return tv;
            }
        }

        System.out.println("TV by ID: " + id + " does not exist:");
        return null;
    }

    public static List<Tv> findByModel(List<Tv> tvs, String model) throws IOException {
        List<Tv> tvList;
        if (tvs == null) {
            tvList = readFromFile();
        } else {
            tvList = tvs;
        }
        List<Tv> byModel = new ArrayList<>();
        for (Tv tv : tvList) {
            if (tv.getModel().equals(model)) {
                byModel.add(tv);
            }
        }

        return byModel;
    }

    public static List<Tv> findByPrice(List<Tv> tvs, double from, double to) throws IOException {
        List<Tv> tvList;
        if (tvs == null) {
            tvList = readFromFile();
        } else {
            tvList = tvs;
        }
        int nullCounter = 0;
        for (Tv tv : tvList) {
            if (tv.getPrice() < from || tv.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == tvList.size()) {
            System.out.println("TVs by range " + from + "$ to " + to + "$ has noy found:");
            return new ArrayList<>();
        }

        List<Tv> byPriceRange = new ArrayList<>();
        for (Tv tv : tvList) {
            double price = tv.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(tv);
            }
        }

        return byPriceRange;
    }

    public static List<Tv> findByYear(List<Tv> tvs, int year) throws IOException {
        List<Tv> tvList;
        if (tvs == null) {
            tvList = readFromFile();
        } else {
            tvList = tvs;
        }
        List<Tv> byYear = new ArrayList<>();
        for (Tv tv : tvList) {
            if (tv.getYear() == year) {
                byYear.add(tv);
            }
        }

        return byYear;
    }

    public static List<Tv> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Tv> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Tv> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Tv> findByAddingDate(List<Tv> tvs, String date) throws IOException {
        List<Tv> tvList;
        if (tvs == null) {
            tvList = readFromFile();
        } else {
            tvList = tvs;
        }
        List<Tv> byAddingDate = new ArrayList<>();
        for (Tv tv : tvList) {
            String cameraDate = tv.getDate().substring(0, tv.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(tv);
            }
        }

        return byAddingDate;
    }

    public static Tv newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Tv older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Tv biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Tv smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Tv newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Tv olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Tv> ascendingOrderByPrice() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new CostComparator());
        return tvs;
    }

    public static List<Tv> descendingOrderByPrice() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new CostComparator().reversed());
        return tvs;
    }

    public static List<Tv> ascendingOrderByYear() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new YearComparator());
        return tvs;
    }

    public static List<Tv> descendingOrderByYear() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new YearComparator().reversed());

        return tvs;
    }

    public static List<Tv> ascendingOrderByAddingDate() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new DateComparator());

        return tvs;
    }

    public static List<Tv> descendingOrderByAddingDate() throws IOException {
        List<Tv> tvs = readFromFile();
        tvs.sort(new DateComparator(true));
        return tvs;
    }

    private static List<Tv> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
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
                .append("\nPrice: " + tv.getPrice())
                .append("\nDate: " + tv.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Tv> tvs) throws IOException {
        if (tvs == null) {
            tvs = readFromFile();
            for (Tv tv : tvs) {
                System.out.println(tv.toString());
            }
            return;
        }
        if (!tvs.isEmpty()) {
            for (Tv tv : tvs) {
                print(tv);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Tv tv) {
        System.out.println(tv.toString());
    }
}
