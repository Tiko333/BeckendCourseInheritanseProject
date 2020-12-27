package picsart.service;

import picsart.comparators.phoneComparators.CostComparator;
import picsart.comparators.phoneComparators.DateComparator;
import picsart.comparators.phoneComparators.YearComparator;
import picsart.model.camera.Camera;
import picsart.model.cellPhone.Phone;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class PhoneService {
    private static String path = FilePaths.PHONE.getValue();
    private static Set<Phone> phoneSet;

    static {
        try {
            phoneSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PhoneService() {}

    public static Phone create() throws IOException {
        System.out.println("Create phone:\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();
        while (model.equals("")) {
            System.out.println("Name of the model have not to be blank: ");
            model = scanner.nextLine();
        }
        System.out.println("Enter display type:");
        String displayType = scanner.nextLine();
        while (displayType.equals("")) {
            System.out.println("Display type have not to be blank: ");
            displayType = scanner.nextLine();
        }
        System.out.println("Enter display size:");
        String displaySize = scanner.nextLine();
        while (displaySize.equals("")) {
            System.out.println("Display size have not to be blank: ");
            displaySize = scanner.nextLine();
        }
        System.out.println("Enter display resolution:");
        String displayResolution = scanner.nextLine();
        while (displayResolution.equals("")) {
            System.out.println("Display resolution have not to be blank: ");
            displayResolution = scanner.nextLine();
        }
        System.out.println("Enter display protection:");
        String displayProtection = scanner.nextLine();
        while (displayProtection.equals("")) {
            System.out.println("Display protection have not to be blank: ");
            displayProtection = scanner.nextLine();
        }
        System.out.println("Enter platform chipset:");
        String platformChipset = scanner.nextLine();
        while (platformChipset.equals("")) {
            System.out.println("Platform chipset have not to be blank: ");
            platformChipset = scanner.nextLine();
        }
        System.out.println("Enter main camera:");
        String mainCamera = scanner.nextLine();
        while (mainCamera.equals("")) {
            System.out.println("Main camera have not to be blank: ");
            mainCamera = scanner.nextLine();
        }
        System.out.println("Enter frontal camera:");
        String frontalCamera = scanner.nextLine();
        while (frontalCamera.equals("")) {
            System.out.println("Frontal camera have not to be blank: ");
            frontalCamera = scanner.nextLine();
        }
        System.out.println("Enter battery:");
        String battery = scanner.nextLine();
        while (battery.equals("")) {
            System.out.println("Battery have not to be blank: ");
            battery = scanner.nextLine();
        }
        System.out.println("Enter platform CPU:");
        String platformCPU = scanner.nextLine();
        while (platformCPU.equals("")) {
            System.out.println("Name of the platform CPU have not to be blank: ");
            platformCPU = scanner.nextLine();
        }
        System.out.println("Enter platform OS:");
        String platformOS = scanner.nextLine();
        while (platformOS.equals("")) {
            System.out.println("Platform OS have not to be blank: ");
            platformOS = scanner.nextLine();
        }

        System.out.println("Enter platform GPU:");
        String platformGPU = scanner.nextLine();
        while (platformGPU.equals("")) {
            System.out.println("Platform GPU have not to be blank: ");
            platformGPU = scanner.nextLine();
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
        System.out.println("Enter memory:");
        int memory = scanner.nextInt();
        while (memory <= 0) {
            System.out.println("Memory must be bigger than 0: ");
            memory = scanner.nextInt();
        }
        System.out.println("Enter ram:");
        int ram = scanner.nextInt();
        while (ram < 1) {
            System.out.println("Ram must be bigger than 1: ");
            ram = scanner.nextInt();
        }

        Phone phone = new Phone(IDGenerator.generateID(9));
        phone.setBattery(battery);
        phone.setFrontalCamera(frontalCamera);
        phone.setMainCamera(mainCamera);
        phone.setMemory(memory);
        phone.setPlatformChipset(platformChipset);
        phone.setPlatformGPU(platformGPU);
        phone.setPlatformCPU(platformCPU);
        phone.setPlatformOS(platformOS);
        phone.setDisplayProtection(displayProtection);
        phone.setDisplayResolution(displayResolution);
        phone.setDisplaySize(displaySize);
        phone.setDisplayType(displayType);
        phone.setRam(ram);
        phone.setModel(model);
        phone.setPower(power);
        phone.setPowerConsumption(powerConsumption);
        phone.setPrice(price);
        phone.setYear(year);

        writeIntoFile(phone);
        phoneSet.add(phone);
        return phone;
    }

    public static List<Phone> multipleCreate(int size) throws IOException {
        List<Phone> phones = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating phone number: " + (i + 1));
            phones.add(create());
        }

        return phones;
    }

    public static void updateById(int id) throws IOException {
        Phone phone = findById(id);
        if (phone==null) {
            return;
        }
        deleteById(id);
        phoneSet.remove(phone);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter display type:");
        String displayType = scanner.nextLine();

        System.out.println("Enter display size:");
        String displaySize = scanner.nextLine();

        System.out.println("Enter display resolution:");
        String displayResolution = scanner.nextLine();

        System.out.println("Enter display protection:");
        String displayProtection = scanner.nextLine();

        System.out.println("Enter platform OS:");
        String platformOS = scanner.nextLine();

        System.out.println("Enter platform CPU:");
        String platformCPU = scanner.nextLine();

        System.out.println("Enter platform GPU:");
        String platformGPU = scanner.nextLine();

        System.out.println("Enter platform chipset:");
        String platformChipset = scanner.nextLine();

        System.out.println("Enter main camera:");
        String mainCamera = scanner.nextLine();

        System.out.println("Enter frontal camera:");
        String frontalCamera = scanner.nextLine();

        System.out.println("Enter battery:");
        String battery = scanner.nextLine();

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter memory 0 to skip:");
        int memory = scanner.nextInt();

        System.out.println("Enter ram 0 to skip:");
        int ram = scanner.nextInt();


        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!displayType.equals("")) {
            phone.setDisplayType(displayType);
        }
        if (!displaySize.equals("")) {
            phone.setDisplaySize(displaySize);
        }
        if (!displayResolution.equals("")) {
            phone.setDisplayResolution(displayResolution);
        }
        if (!displayProtection.equals("")) {
            phone.setDisplayProtection(displayProtection);
        }
        if (!platformOS.equals("")) {
            phone.setPlatformOS(platformOS);
        }
        if (!platformCPU.equals("")) {
            phone.setPlatformCPU(platformCPU);
        }
        if (!model.equals("")) {
            phone.setModel(model);
        }
        if (!platformGPU.equals("")) {
            phone.setPlatformGPU(platformGPU);
        }
        if (!platformChipset.equals("")) {
            phone.setPlatformChipset(platformChipset);
        }
        if (!mainCamera.equals("")) {
            phone.setMainCamera(mainCamera);
        }
        if (!frontalCamera.equals("")) {
            phone.setFrontalCamera(frontalCamera);
        }
        if (!battery.equals("")) {
            phone.setBattery(battery);
        }
        if (memory >= 16) {
            phone.setMemory(memory);
        }
        if (ram > 1) {
            phone.setRam(ram);
        }
        if (!power.equals("")) {
            phone.setPower(power);
        }
        if (!powerConsumption.equals("")) {
            phone.setPowerConsumption(powerConsumption);
        }
        if (!model.equals("")) {
            phone.setModel(model);
        }
        if (price > 0) {
            phone.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            phone.setYear(year);
        }

        writeIntoFile(phone);
        phoneSet.add(phone);
    }

    public static boolean checkId(int id) {
        Iterator<Phone> iterator = phoneSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Phone next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Phone by id " + id + " does not exist:");
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

        Iterator<Phone> phoneSetIterator = phoneSet.iterator();
        while (phoneSetIterator.hasNext()) {
            Phone next = phoneSetIterator.next();
            if (next.getId() == id) {
                phoneSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Phone> cameras = ConverterService.readPhonesFile(strings);
        for (Phone phone : cameras) {
            writeIntoFile(phone);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj , StandardOpenOption.TRUNCATE_EXISTING);
        phoneSet.clear();
    }

    public static Phone findById(long id) throws IOException {
        for (Phone phone : readFromFile()) {
            if (phone.getId() == id) {
                return phone;
            }
        }

        System.out.println("Phone by ID: " + id + " does not exist:");
        return null;
    }

    public static List<Phone> findByModel(List<Phone> phones, String model) throws IOException {
        List<Phone> phoneList;
        if (phones == null) {
            phoneList = readFromFile();
        } else {
            phoneList = phones;
        }
        List<Phone> byModel = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getModel().equals(model)) {
                byModel.add(phone);
            }
        }

        return byModel;
    }

    public static List<Phone> findByPrice(List<Phone> phones, double from, double to) throws IOException {
        List<Phone> phoneList;
        if (phones == null) {
            phoneList = readFromFile();
        } else {
            phoneList = phones;
        }
        int nullCounter = 0;
        for (Phone phone : phoneList) {
            if (phone.getPrice() < from || phone.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == phoneList.size()) {
            System.out.println("Phones by range " + from + "$ to " + to + "$ has noy found:");
            return new LinkedList<>();
        }
        List<Phone> byPriceRange = new LinkedList<>();
        for (Phone phone : phoneList) {
            double price = phone.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(phone);
            }
        }

        return byPriceRange;
    }

    public static List<Phone> findByYear(List<Phone> phones, int year) throws IOException {
        List<Phone> phoneList;
        if (phones == null) {
            phoneList = readFromFile();
        } else {
            phoneList = phones;
        }
        List<Phone> byYear = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (phone.getYear() == year) {
                byYear.add(phone);
            }
        }

        return byYear;
    }

    public static List<Phone> findModelByPrice(String model, double from, double to) throws IOException {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static List<Phone> findModelByYear(String model, int year) throws IOException {
        return findByYear(findByModel(null, model), year);
    }

    public static List<Phone> findModelByDate(String model, String date) throws IOException {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static List<Phone> findByAddingDate(List<Phone> phones, String date) throws IOException {
        List<Phone> phoneList;
        if (phones == null) {
            phoneList = readFromFile();
        } else {
            phoneList = phones;
        }
        List<Phone> byAddingDate = new ArrayList<>();
        for (Phone phone : phoneList) {
            String cameraDate = phone.getDate().substring(0, phone.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(phone);
            }
        }

        return byAddingDate;
    }

    public static Phone newer() throws IOException {
        return Collections.max(readFromFile(), new YearComparator());
    }

    public static Phone older() throws IOException {
        return Collections.min(readFromFile(), new YearComparator());
    }

    public static Phone biggerCost() throws IOException {
        return Collections.max(readFromFile(), new CostComparator());
    }

    public static Phone smallerCost() throws IOException {
        return Collections.min(readFromFile(), new CostComparator());
    }

    public static Phone newerAdded() throws IOException {
        return Collections.max(readFromFile(), new DateComparator());
    }

    public static Phone olderAdded() throws IOException {
        return Collections.min(readFromFile(), new DateComparator());
    }

    public static List<Phone> ascendingOrderByPrice() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new CostComparator());
        return phones;
    }

    public static List<Phone> descendingOrderByPrice() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new CostComparator().reversed());
        return phones;
    }

    public static List<Phone> ascendingOrderByYear() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new YearComparator());
        return phones;
    }

    public static List<Phone> descendingOrderByYear() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new YearComparator().reversed());
        return phones;
    }

    public static List<Phone> ascendingOrderByAddingDate() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new DateComparator());
        return phones;
    }

    public static List<Phone> descendingOrderByAddingDate() throws IOException {
        List<Phone> phones = readFromFile();
        phones.sort(new DateComparator(true));
        return phones;
    }

    public static List<Phone> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readPhonesFile(strings);
    }

    private static void writeIntoFile(Phone phone) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + phone.getId())
                .append("\nPhone-model: " + phone.getModel())
                .append("\nDisplay-type: " + phone.getDisplayType())
                .append("\nDisplay-size: " + phone.getDisplaySize())
                .append("\nDisplay-resolution: " + phone.getDisplayResolution())
                .append("\nDisplay-protection: " + phone.getDisplayProtection())
                .append("\nPlatform-OS: " + phone.getPlatformOS())
                .append("\nPlatform-CPU: " + phone.getPlatformCPU())
                .append("\nPlatform-GPU: " + phone.getPlatformGPU())
                .append("\nPlatform-chipset: " + phone.getPlatformChipset())
                .append("\nMemory: " + phone.getMemory())
                .append("\nRam: " + phone.getRam())
                .append("\nMain-camera: " + phone.getMainCamera())
                .append("\nFrontal-camera: " + phone.getFrontalCamera())
                .append("\nBattery: " + phone.getBattery())
                .append("\nPower: " + phone.getPower())
                .append("\nPower-consumption: " + phone.getPowerConsumption())
                .append("\nYear: " + phone.getYear())
                .append("\nPrice: " + phone.getPrice())
                .append("\nDate: " + phone.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(List<Phone> phones) throws IOException {
        if (phones == null) {
            phones = readFromFile();
            for (Phone phone : phones) {
                System.out.println(phone.toString());
            }
            return;
        }
        if (!phones.isEmpty()) {
            for (Phone phone : phones) {
                print(phone);
            }
            return;
        }
        System.out.println("No result");
    }

    public static void print(Phone phone) {
        System.out.println(phone.toString());
    }

}
