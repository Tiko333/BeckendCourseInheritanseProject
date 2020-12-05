package picsart.service;

import picsart.comparators.consoleComparators.CostComparator;
import picsart.comparators.consoleComparators.YearComparator;
import picsart.model.videoGameConsole.Console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ConsoleService {
    private static final String FILE_PATH = "src/picsart/files/consoles.txt";

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
        return console;
    }

    public static List<Console> createConsoles(int size) throws IOException {
        List<Console> consoles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating console number: " + (i + 1));
            consoles.add(create());
        }

        return consoles;
    }

    public static Console findById(long id) throws IOException {
        List<Console> consoles = readConsolesFromFile();
        for (Console console : consoles) {
            if (console.getId() == id) {
                System.out.println(console.toString());
                return console;
            }
        }
        System.out.println("Game console by ID: " + id + " does not exist:");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        List<Console> consoles = readConsolesFromFile();
        boolean isFound = false;
        for (int i = 0; i < consoles.size(); i++) {
            Console console = consoles.get(i);
            if (console.getModel().equals(model)) {
                System.out.println(console.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == consoles.size() - 1)) {
                return;
            }
        }
        if (!isFound) {
            System.out.println("There is no game console by model: " + model);
        }
    }

    public static List<Console> findByPrice(double from, double to) throws IOException {
        List<Console> consoles = readConsolesFromFile();
        int nullCounter = 0;
        for (Console console : consoles) {
            if (console.getPrice() < from || console.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == consoles.size()) {
            System.out.println("Phones by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Console> selectedConsolesByPriceRange = new LinkedList<>();
        for (Console phone : consoles) {
            double price = phone.getPrice();
            if (price >= from && price <= to) {
                selectedConsolesByPriceRange.add(phone);
            }
        }

        printAll(selectedConsolesByPriceRange);
        return selectedConsolesByPriceRange;
    }

    public static Console newerConsole() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        Console max = Collections.max(consoles, new YearComparator());
        printConsole(max);
        return max;
    }

    public static Console olderConsole() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        Console min = Collections.min(consoles, new YearComparator());
        printConsole(min);
        return min;
    }

    public static Console biggerCost() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        Console max = Collections.max(consoles, new CostComparator());
        printConsole(max);
        return max;
    }

    public static Console smallerCost() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        Console min = Collections.min(consoles, new CostComparator());
        printConsole(min);
        return min;
    }

    public static List<Console> ascendingOrderByPrice() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        consoles.sort(new CostComparator());
        printAll(consoles);
        return consoles;
    }

    public static List<Console> descendingOrderByPrice() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        consoles.sort(new CostComparator().reversed());
        printAll(consoles);
        return consoles;
    }

    public static List<Console> ascendingOrderByYear() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        consoles.sort(new YearComparator());
        printAll(consoles);
        return consoles;
    }

    public static List<Console> descendingOrderByYear() throws IOException {
        List<Console> consoles = readConsolesFromFile();
        consoles.sort(new YearComparator().reversed());
        printAll(consoles);
        return consoles;
    }

    private static List<Console> readConsolesFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(FILE_PATH));

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
                .append("\nPrice: " + console.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Console> consoles) throws IOException {
        if (consoles == null) {
            consoles = readConsolesFromFile();
            for (Console console : consoles) {
                System.out.println(console.toString());
            }
            return;
        }
        for (Console console : consoles) {
            System.out.println(console.toString());
        }
    }

    public static void printConsole(Console console) {
        System.out.println(console.toString());
    }
}
