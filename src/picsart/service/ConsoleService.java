package picsart.service;

import picsart.comparators.consoleComparators.CostComparator;
import picsart.comparators.consoleComparators.DateComparator;
import picsart.comparators.consoleComparators.YearComparator;
import picsart.model.videoGameConsole.Console;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConsoleService {
    private static String path = FilePaths.CONSOLE.getValue();

    private static Set<Console> consoleSet;

    static {
        try {
            consoleSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ConsoleService() {}

    public static Console create() throws IOException {
        System.out.println("Create Game Console\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
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
        System.out.println("Enter processor:");
        String processor = scanner.nextLine();
        while (processor.equals("")) {
            System.out.println("Name of the processor have not to be blank: ");
            processor = scanner.nextLine();
        }
        System.out.println("Enter memory:");
        String memory = scanner.nextLine();
        while (memory.equals("")) {
            System.out.println("Amount of the memory have not to be blank: ");
            memory = scanner.nextLine();
        }
        System.out.println("Enter storage:");
        String storage = scanner.nextLine();
        while (storage.equals("")) {
            System.out.println("Amount of the storage have not to be blank: ");
            storage = scanner.nextLine();
        }
        System.out.println("Enter drive:");
        String drive = scanner.nextLine();
        while (drive.equals("")) {
            System.out.println("Drive have not to be blank: ");
            drive = scanner.nextLine();
        }
        System.out.println("Enter aVoutput:");
        String aVoutput = scanner.nextLine();
        while (aVoutput.equals("")) {
            System.out.println("aVoutput have not to be blank: ");
            aVoutput = scanner.nextLine();
        }
        System.out.println("Enter weight:");
        double weight = scanner.nextDouble();
        while (weight <= 0) {
            System.out.println("weight must be bigger than 0: ");
            weight = scanner.nextDouble();
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

        Console console = new Console(IDGenerator.generateID(9));
        console.setProcessor(processor);
        console.setMemory(memory);
        console.setStorage(storage);
        console.setDrive(drive);
        console.setAVoutput(aVoutput);
        console.setWeight(weight);
        console.setModel(model);
        console.setPower(power);
        console.setPowerConsumption(powerConsumption);
        console.setPrice(price);
        console.setYear(year);

        writeIntoFile(console);
        consoleSet.add(console);
        return console;
    }

    public static List<Console> multipleCreate(int size) throws IOException {
        List<Console> consoles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating console number: " + (i + 1));
            consoles.add(create());
        }

        return consoles;
    }

    public static void updateById(int id) throws IOException {
        Console console = findById(id);
        if (console == null) {
            return;
        }
        deleteById(id);
        consoleSet.remove(console);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter processor:");
        String processor = scanner.nextLine();

        System.out.println("Enter memory:");
        String memory = scanner.nextLine();

        System.out.println("Enter storage:");
        String storage = scanner.nextLine();

        System.out.println("Enter drive:");
        String drive = scanner.nextLine();

        System.out.println("Enter aVoutput:");
        String aVoutput = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter price 0 to skip:");
        double weight = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!model.equals("")) {
            console.setModel(model);
        }
        if (!processor.equals("")) {
            console.setProcessor(processor);
        }
        if (!memory.equals("")) {
            console.setMemory(memory);
        }
        if (!storage.equals("")) {
            console.setStorage(storage);
        }
        if (!drive.equals("")) {
            console.setDrive(drive);
        }
        if (!aVoutput.equals("")) {
            console.setAVoutput(aVoutput);
        }
        if (!power.equals("")) {
            console.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            console.setPowerConsumption(powerConsumption);
        }
        if (price > 0) {
            console.setPrice(price);
        }
        if (weight > 0) {
            console.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            console.setYear(year);
        }

        writeIntoFile(console);
        consoleSet.add(console);
    }

    public static boolean checkId(int id) {
        Iterator<Console> iterator = consoleSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Console next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Console by id " + id + " does not exist:");
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

        Iterator<Console> consoleSetIterator = consoleSet.iterator();
        while (consoleSetIterator.hasNext()) {
            Console next = consoleSetIterator.next();
            if (next.getId() == id) {
                consoleSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Console> consoles = ConverterService.readConsolesFile(strings);
        for (Console console : consoles) {
            writeIntoFile(console);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        consoleSet.clear();
    }

    public static Console findById(long id) throws IOException {
        for (Console console : readFromFile()) {
            if (console.getId() == id) {
                return console;
            }
        }
        System.out.println("Game console by ID: " + id + " does not exist:");
        return null;
    }

    public static List<Console> findByModel(List<Console> consoles, String model) throws IOException {
        List<Console> consoleList;
        if (consoles == null) {
            consoleList = readFromFile();
        } else {
            consoleList = consoles;
        }
        List<Console> byModel = new ArrayList<>();
        for (Console console : consoleList) {
            if (console.getModel().equals(model)) {
                byModel.add(console);
            }
        }

        return byModel;
    }

    public static List<Console> findByPrice(List<Console> consoles, double from, double to) throws IOException {
        List<Console> consoleList;
        if (consoles == null) {
            consoleList = readFromFile();
        } else {
            consoleList = consoles;
        }
        int nullCounter = 0;
        for (Console console : consoleList) {
            if (console.getPrice() < from || console.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == consoleList.size()) {
            System.out.println("Consoles by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Console> byPriceRange = new LinkedList<>();
        for (Console console : consoleList) {
            double price = console.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(console);
            }
        }

        return byPriceRange;
    }

    public static List<Console> findByYear(List<Console> consoles, int year) throws IOException {
        List<Console> consoleList;
        if (consoles == null) {
            consoleList = readFromFile();
        } else {
            consoleList = consoles;
        }
        List<Console> byYear = new ArrayList<>();
        for (Console console : consoleList) {
            if (console.getYear() == year) {
                byYear.add(console);
            }
        }

        return byYear;
    }

    public static List<Console> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Console> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Console> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Console> findByAddingDate(List<Console> consoles, String date) throws IOException {
        List<Console> consoleList;
        if (consoles == null) {
            consoleList = readFromFile();
        } else {
            consoleList = consoles;
        }
        List<Console> byAddingDate = new ArrayList<>();
        for (Console console : consoleList) {
            String cameraDate = console.getDate().substring(0, console.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(console);
            }
        }

        return byAddingDate;
    }

    public static Console newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Console older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Console biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Console smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Console newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Console olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Console> ascendingOrderByPrice() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new CostComparator());
        return consoles;
    }

    public static List<Console> descendingOrderByPrice() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new CostComparator().reversed());
        return consoles;
    }

    public static List<Console> ascendingOrderByYear() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new YearComparator());
        return consoles;
    }

    public static List<Console> descendingOrderByYear() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new YearComparator().reversed());
        return consoles;
    }

    public static List<Console> ascendingOrderByAddingDate() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new DateComparator());
        return consoles;
    }

    public static List<Console> descendingOrderByAddingDate() throws IOException {
        List<Console> consoles = readFromFile();
        consoles.sort(new DateComparator(true));
        return consoles;
    }

    private static List<Console> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readConsolesFile(strings);
    }

    private static void writeIntoFile(Console console) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + console.getId())
                .append("\nConsole-model: " + console.getModel())
                .append("\nProcessor: " + console.getProcessor())
                .append("\nMemory: " + console.getMemory())
                .append("\nStorage: " + console.getStorage())
                .append("\nDrive: " + console.getDrive())
                .append("\nAVoutput: " + console.getAVoutput())
                .append("\nWeight: " + console.getWeight())
                .append("\nPower: " + console.getPower())
                .append("\nPower-consumption: " + console.getPowerConsumption())
                .append("\nYear: " + console.getYear())
                .append("\nPrice: " + console.getPrice())
                .append("\nDate: " + console.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Console> consoles) throws IOException {
        if (consoles == null) {
            consoles = readFromFile();
            for (Console console : consoles) {
                System.out.println(console.toString());
            }
            return;
        }
        if (!consoles.isEmpty()) {
            for (Console console : consoles) {
                print(console);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Console console) {
        System.out.println(console.toString());
    }
}
