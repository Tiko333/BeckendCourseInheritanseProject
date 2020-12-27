package picsart.service;

import picsart.comparators.speakerComparators.*;
import picsart.model.speaker.Speaker;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class SpeakerService {

    private static String path = FilePaths.SPEAKER.getValue();
    private static Set<Speaker> speakerSet;

    static {
        try {
            speakerSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SpeakerService() {
    }

    public static Speaker create() throws IOException {
        System.out.println("Create camera\n");
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter frequency:");
        String frequency = scanner.nextLine();
        while (frequency.equals("")) {
            System.out.println("Frequency have not to be blank: ");
            frequency = scanner.nextLine();
        }
        System.out.println("Enter interface type:");
        String interfaceType = scanner.nextLine();
        while (interfaceType.equals("")) {
            System.out.println("Pixel dimensions have not to be blank: ");
            interfaceType = scanner.nextLine();
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

        Speaker speaker = new Speaker(IDGenerator.generateID(9));
        speaker.setModel(model);
        speaker.setPower(power);
        speaker.setPowerConsumption(powerConsumption);
        speaker.setPrice(price);
        speaker.setYear(year);
        speaker.setFrequency(frequency);
        speaker.setInterfaceType(interfaceType);

        writeIntoFile(speaker);
        speakerSet.add(speaker);
        return speaker;
    }

    public static Set<Speaker> multipleCreate(int size) throws IOException {
        Set<Speaker> speakers = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating speaker number: " + (i + 1));
            speakers.add(create());
        }

        return speakers;
    }

    public static void updateById(int id) throws IOException {
        Speaker speaker = findById(id);
        if (speaker == null) {
            return;
        }
        deleteById(id);
        speakerSet.remove(speaker);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter frequency:");
        String frequency = scanner.nextLine();

        System.out.println("Enter interface type:");
        String interfaceType = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();

        if (!frequency.equals("")) {
            speaker.setFrequency(frequency);
        }
        if (!interfaceType.equals("")) {
            speaker.setInterfaceType(interfaceType);
        }
        if (!model.equals("")) {
            speaker.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            speaker.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            speaker.setPower(power);
        }
        if (price > 0) {
            speaker.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            speaker.setYear(year);
        }

        writeIntoFile(speaker);
        speakerSet.add(speaker);
    }

    public static boolean checkId(int id) {
        Iterator<Speaker> iterator = speakerSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Speaker next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Speaker by id " + id + " does not exist:");
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

        Iterator<Speaker> speakerSetIterator = speakerSet.iterator();
        while (speakerSetIterator.hasNext()) {
            Speaker next = speakerSetIterator.next();
            if (next.getId() == id) {
                speakerSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Speaker> speakers = ConverterService.readSpeakersFile(strings);
        for (Speaker speaker : speakers) {
            writeIntoFile(speaker);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        speakerSet.clear();
    }

    public static Speaker findById(long id) {
        for (Speaker speaker : speakerSet) {
            if (speaker.getId() == id) {
                return speaker;
            }
        }

        System.out.println("Speaker by ID: " + id + " does not exist");
        return null;
    }

    public static Set<Speaker> findByModel(Set<Speaker> speakers, String model) {
        Set<Speaker> speakerSet;
        if (speakers == null) {
            speakerSet = SpeakerService.speakerSet;
        } else {
            speakerSet = speakers;
        }
        Set<Speaker> byModel = new HashSet<>();
        for (Speaker speaker : speakerSet) {
            if (speaker.getModel().equals(model)) {
                byModel.add(speaker);
            }
        }

        return byModel;
    }

    public static Set<Speaker> findByPrice(Set<Speaker> speakers, double from, double to) {
        Set<Speaker> speakerSet;
        if (speakers == null) {
            speakerSet = SpeakerService.speakerSet;
        } else {
            speakerSet = speakers;
        }
        int nullCounter = 0;
        for (Speaker speaker : speakerSet) {
            if (speaker.getPrice() < from || speaker.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == speakerSet.size()) {
            System.out.println("Speakers by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<Speaker> byPriceRange = new HashSet<>();
        for (Speaker speaker : speakerSet) {
            double price = speaker.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(speaker);
            }
        }

        return byPriceRange;
    }

    public static Set<Speaker> findByYear(Set<Speaker> speakers, int year) {
        Set<Speaker> speakerSet;
        if (speakers == null) {
            speakerSet = SpeakerService.speakerSet;
        } else {
            speakerSet = speakers;
        }
        Set<Speaker> byYear = new HashSet<>();
        for (Speaker speaker : speakerSet) {
            if (speaker.getYear() == year) {
                byYear.add(speaker);
            }
        }

        return byYear;
    }

    public static Set<Speaker> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<Speaker> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<Speaker> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<Speaker> findByAddingDate(Set<Speaker> speakers, String date) {
        Set<Speaker> speakerSet;
        if (speakers == null) {
            speakerSet = SpeakerService.speakerSet;
        } else {
            speakerSet = speakers;
        }
        Set<Speaker> byAddingDate = new HashSet<>();
        for (Speaker speaker : speakerSet) {
            String cameraDate = speaker.getDate().substring(0, speaker.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(speaker);
            }
        }

        return byAddingDate;
    }

    public static Speaker newer() {
        return Collections.max(speakerSet, new YearComparator());
    }

    public static Speaker older() {
        return Collections.min(speakerSet, new YearComparator());
    }

    public static Speaker biggerCost() {
        return Collections.max(speakerSet, new CostComparator());
    }

    public static Speaker smallerCost() {
        return Collections.min(speakerSet, new CostComparator());
    }

    public static Speaker newerAdded() {
        return Collections.max(speakerSet, new DateComparator());
    }

    public static Speaker olderAdded() {
        return Collections.min(speakerSet, new DateComparator());
    }

    public static List<Speaker> ascendingOrderByPrice() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new CostComparator());
        return speakers;
    }

    public static List<Speaker> descendingOrderByPrice() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new CostComparator().reversed());
        return speakers;
    }

    public static List<Speaker> ascendingOrderByYear() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new YearComparator());
        return speakers;
    }

    public static List<Speaker> descendingOrderByYear() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new YearComparator().reversed());
        return speakers;
    }

    public static List<Speaker> ascendingOrderByAddingDate() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new DateComparator());
        return speakers;
    }

    public static List<Speaker> descendingOrderByAddingDate() {
        List<Speaker> speakers = new ArrayList<>(speakerSet);
        speakers.sort(new DateComparator(true));
        return speakers;
    }

    private static List<Speaker> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readSpeakersFile(strings);
    }

    private static void writeIntoFile(Speaker speaker) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + speaker.getId())
                .append("\nModel: " + speaker.getModel())
                .append("\nFrequency: " + speaker.getFrequency())
                .append("\nInterface-type: " + speaker.getInterfaceType())
                .append("\nPower: " + speaker.getPower())
                .append("\nPower-consumption: " + speaker.getPowerConsumption())
                .append("\nYear: " + speaker.getYear())
                .append("\nPrice: " + speaker.getPrice())
                .append("\nDate: " + speaker.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<Speaker> speakers) throws IOException {
        if (speakers == null) {
            speakers = readFromFile();
            for (Speaker speaker : speakers) {
                System.out.println(speaker.toString());
            }
            return;
        }
        if (!speakers.isEmpty()) {
            for (Speaker speaker : speakers) {
                print(speaker);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(Speaker speaker) {
        System.out.println(speaker.toString());
    }
}
