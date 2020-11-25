package picsart.service;

import picsart.model.cellPhone.Phone;
import picsart.model.videoGameConsole.Console;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

// fix create
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

    public static Console[] createConsoles(int size) throws IOException {
        Console[] consoles = new Console[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Creating console number: " + (i + 1));
            consoles[i] = create();
        }

        return consoles;
    }

    public static Console findById(long id) throws IOException {
        Console[] consoles = readConsolesFromFile();
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
        Console[] consoles = readConsolesFromFile();
        boolean isFound = false;
        for (int i = 0; i < consoles.length; i++) {
            Console console = consoles[i];
            if (console.getModel().equals(model)) {
                System.out.println(console.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == consoles.length - 1)) {
                return;
            }
        }
        if (!isFound) {
            System.out.println("There is no game console by model: " + model);
        }
    }

    public static Console[] findByPrice(double from, double to) throws IOException {
        Console[] consoles = readConsolesFromFile();
        int nullCounter = 0;
        for (Console console : consoles) {
            if (console.getPrice() < from || console.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == consoles.length) {
            System.out.println("Phones by range " + from + "$ to " + to + "$ has noy found:");
            return new Console[0];
        }
        int index = 0;
        Console[] selectedConsolesByPriceRange = new Console[consoles.length - nullCounter];
        for (Console phone : consoles) {
            double price = phone.getPrice();
            if (price >= from && price <= to) {
                selectedConsolesByPriceRange[index++] = phone;
            }
        }

        printAll(selectedConsolesByPriceRange);
        return selectedConsolesByPriceRange;
    }

    public static Console newerConsole() throws IOException {
        Console[] consoles = readConsolesFromFile();
        Console newerConsole = consoles[0];
        for (Console console : consoles) {
            if (console.getYear() >= newerConsole.getYear()) {
                newerConsole = console;
            }
        }

        printConsole(newerConsole);
        return newerConsole;
    }

    public static Console olderConsole() throws IOException {
        Console[] consoles = readConsolesFromFile();
        Console olderConsole = consoles[0];
        for (Console console : consoles) {
            if (console.getYear() < olderConsole.getYear()) {
                olderConsole = console;
            }
        }

        printConsole(olderConsole);
        return olderConsole;
    }

    public static Console biggerCost() throws IOException {
        Console[] consoles = readConsolesFromFile();
        Console biggerCostConsole = consoles[0];
        for (Console console : consoles) {
            if (console.getPrice() > biggerCostConsole.getPrice()) {
                biggerCostConsole = console;
            }
        }

        printConsole(biggerCostConsole);
        return biggerCostConsole;
    }

    public static Console smallerCost() throws IOException {
        Console[] consoles = readConsolesFromFile();
        Console smallerCostConsole = consoles[0];
        for (Console console : consoles) {
            if (console.getPrice() < smallerCostConsole.getPrice()) {
                smallerCostConsole = console;
            }
        }

        printConsole(smallerCostConsole);
        return smallerCostConsole;
    }

    public static Console[] ascendingOrderByPrice() throws IOException {
        Console[] consoles = readConsolesFromFile();
        for (int i = 0; i < consoles.length; i++) {
            for (int j = 1; j < consoles.length - i; j++) {
                if (consoles[j - 1].getPrice() > consoles[j].getPrice()) {
                    Console temp = consoles[j];
                    consoles[j] = consoles[j - 1];
                    consoles[j - 1] = temp;
                }
            }
        }

        printAll(consoles);
        return consoles;
    }

    public static Console[] descendingOrderByPrice() throws IOException {
        Console[] consoles = readConsolesFromFile();
        for (int i = 0; i < consoles.length; i++) {
            for (int j = 1; j < consoles.length - i; j++) {
                if (consoles[j - 1].getPrice() < consoles[j].getPrice()) {
                    Console temp = consoles[j];
                    consoles[j] = consoles[j - 1];
                    consoles[j - 1] = temp;
                }
            }
        }

        printAll(consoles);
        return consoles;
    }

    public static Console[] ascendingOrderByYear() throws IOException {
        Console[] consoles = readConsolesFromFile();
        for (int i = 0; i < consoles.length; i++) {
            for (int j = 1; j < consoles.length - i; j++) {
                if (consoles[j - 1].getYear() > consoles[j].getYear()) {
                    Console temp = consoles[j];
                    consoles[j] = consoles[j - 1];
                    consoles[j - 1] = temp;
                }
            }
        }

        printAll(consoles);
        return consoles;
    }

    public static Console[] descendingOrderByYear() throws IOException {
        Console[] consoles = readConsolesFromFile();
        for (int i = 0; i < consoles.length; i++) {
            for (int j = 1; j < consoles.length - i; j++) {
                if (consoles[j - 1].getYear() < consoles[j].getYear()) {
                    Console temp = consoles[j];
                    consoles[j] = consoles[j - 1];
                    consoles[j - 1] = temp;
                }
            }
        }

        printAll(consoles);
        return consoles;
    }

    private static Console[] readConsolesFromFile() throws IOException {
        String[] strings = Files.readAllLines(Path.of(FILE_PATH)).toArray(new String[0]);

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

    public static void printAll(Console[] consoles) throws IOException {
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
