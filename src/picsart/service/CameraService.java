package picsart.service;

import picsart.comparators.cameraComparators.CostComparator;
import picsart.comparators.cameraComparators.DateComparator;
import picsart.comparators.cameraComparators.YearComparator;
import picsart.model.camera.Camera;
import picsart.paths.FilePaths;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CameraService {

    private static String path = FilePaths.CAMERA.getValue();
    private static Set<Camera> cameraSet;

    static {
        try {
            cameraSet = new HashSet<>(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CameraService() {
    }

    public static Camera create() throws IOException {
        System.out.println("Create camera\n");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter megapixels:");
        String megapixels = scanner.nextLine();
        while (megapixels.equals("")) {
            System.out.println("Megapixels have not to be blank: ");
            megapixels = scanner.nextLine();
        }
        System.out.println("Enter pixel dimensions:");
        String pixelDimensions = scanner.nextLine();
        while (pixelDimensions.equals("")) {
            System.out.println("Pixel dimensions have not to be blank: ");
            pixelDimensions = scanner.nextLine();
        }
        System.out.println("Enter pixel Size:");
        String pixelSize = scanner.nextLine();
        while (pixelSize.equals("")) {
            System.out.println("Pixel Size have not to be blank: ");
            pixelSize = scanner.nextLine();
        }
        System.out.println("Enter sensor size:");
        String sensorSize = scanner.nextLine();
        while (sensorSize.equals("")) {
            System.out.println("Sensor size have not to be blank: ");
            sensorSize = scanner.nextLine();
        }
        System.out.println("Enter aspect ratio:");
        String aspectRatio = scanner.nextLine();
        while (aspectRatio.equals("")) {
            System.out.println("Aspect ratio have not to be blank: ");
            aspectRatio = scanner.nextLine();
        }
        System.out.println("Enter image processor:");
        String imageProcessor = scanner.nextLine();
        while (imageProcessor.equals("")) {
            System.out.println("Image processor have not to be blank: ");
            imageProcessor = scanner.nextLine();
        }
        System.out.println("Enter sensor stabilization 'yes' or 'no':");
        boolean isHaveSensorStabilization = false;
        String sensorStabilization = scanner.nextLine();
        while (!sensorStabilization.equals("yes") && !sensorStabilization.equals("no")) {
            System.out.println("sensor stabilization have not to be blank insert 'yes' or 'no': ");
            sensorStabilization = scanner.nextLine();
        }
        if (sensorStabilization.equals("yes")) {
            isHaveSensorStabilization = true;
        }
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
        System.out.println("Enter memory:");
        String memory = scanner.nextLine();
        while (memory.equals("")) {
            System.out.println("Amount of the memory have not to be blank: ");
            memory = scanner.nextLine();
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

        Camera camera = new Camera(IDGenerator.generateID(9));
        camera.setModel(model);
        camera.setPower(power);
        camera.setPowerConsumption(powerConsumption);
        camera.setPrice(price);
        camera.setYear(year);
        camera.setAspectRatio(aspectRatio);
        camera.setImageProcessor(imageProcessor);
        camera.setMegapixels(megapixels);
        camera.setPixelDimensions(pixelDimensions);
        camera.setPixelSize(pixelSize);
        camera.setSensorSize(sensorSize);
        camera.setSensorStabilization(isHaveSensorStabilization);

        writeIntoFile(camera);
        cameraSet.add(camera);
        return camera;
    }

    public static Set<Camera> multipleCreate(int size) throws IOException {
        Set<Camera> cameras = new HashSet<>();
        for (int i = 0; i < size; i++) {
            System.out.println("Creating camera number: " + (i + 1));
            cameras.add(create());
        }

        return cameras;
    }

    public static void updateById(int id) throws IOException {
        Camera camera = findById(id);
        if (camera == null) {
            return;
        }
        deleteById(id);
        cameraSet.remove(camera);

        System.out.println("\nInsert updating fields press 'enter' to skip:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter model:");
        String model = scanner.nextLine();

        System.out.println("Enter megapixels:");
        String megapixels = scanner.nextLine();

        System.out.println("Enter pixel dimensions:");
        String pixelDimensions = scanner.nextLine();

        System.out.println("Enter pixel Size:");
        String pixelSize = scanner.nextLine();

        System.out.println("Enter sensor size:");
        String sensorSize = scanner.nextLine();

        System.out.println("Enter aspect ratio:");
        String aspectRatio = scanner.nextLine();

        System.out.println("Enter image processor:");
        String imageProcessor = scanner.nextLine();

        System.out.println("Enter sensor stabilization 'yes' or 'no':");
        boolean isHaveSensorStabilization = false;
        String sensorStabilization = scanner.nextLine();
        while (!sensorStabilization.equals("yes") && !sensorStabilization.equals("no")) {
            System.out.println("sensor stabilization have not to be blank insert 'yes' or 'no': ");
            sensorStabilization = scanner.nextLine();
        }
        if (sensorStabilization.equals("yes")) {
            isHaveSensorStabilization = true;
        }

        System.out.println("Enter power consumption:");
        String powerConsumption = scanner.nextLine();

        System.out.println("Enter power:");
        String power = scanner.nextLine();

        System.out.println("Enter price 0 to skip:");
        double price = scanner.nextDouble();

        System.out.println("Enter year 0 to skip:");
        int year = scanner.nextInt();


        if (!megapixels.equals("")) {
            camera.setMegapixels(megapixels);
        }
        if (!pixelDimensions.equals("")) {
            camera.setPixelDimensions(pixelDimensions);
        }
        if (!pixelSize.equals("")) {
            camera.setPixelSize(pixelSize);
        }
        if (!sensorSize.equals("")) {
            camera.setSensorSize(sensorSize);
        }
        if (!aspectRatio.equals("")) {
            camera.setAspectRatio(aspectRatio);
        }
        if (!imageProcessor.equals("")) {
            camera.setImageProcessor(imageProcessor);
        }
        camera.setSensorStabilization(isHaveSensorStabilization);
        if (!model.equals("")) {
            camera.setModel(model);
        }
        if (!powerConsumption.equals("")) {
            camera.setPowerConsumption(powerConsumption);
        }
        if (!power.equals("")) {
            camera.setPower(power);
        }
        if (price > 0) {
            camera.setPrice(price);
        }
        if (year >= 1990 && year <= 2020) {
            camera.setYear(year);
        }

        writeIntoFile(camera);
        cameraSet.add(camera);
    }

    public static boolean checkId(int id) {
        Iterator<Camera> iterator = cameraSet.iterator();
        boolean isExistingByThisId = false;
        while (iterator.hasNext()) {
            Camera next = iterator.next();
            if (next.getId() == id) {
                isExistingByThisId = true;
                break;
            }
        }
        return isExistingByThisId;
    }

    public static boolean deleteById(int id) throws IOException {
        if (!checkId(id)) {
            System.out.println("Camera by id " + id + " does not exist:");
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

        Iterator<Camera> cameraSetIterator = cameraSet.iterator();
        while (cameraSetIterator.hasNext()) {
            Camera next = cameraSetIterator.next();
            if (next.getId() == id) {
                cameraSetIterator.remove();
                break;
            }
        }

        deleteAll();
        List<Camera> cameras = ConverterService.readCamerasFile(strings);
        for (Camera camera : cameras) {
            writeIntoFile(camera);
        }

        return true;
    }

    public static void deleteAll() throws IOException {
        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        cameraSet.clear();
    }

    public static Camera findById(long id) {
        for (Camera camera : cameraSet) {
            if (camera.getId() == id) {
                return camera;
            }
        }

        System.out.println("Camera by ID: " + id + " does not exist");
        return null;
    }

    public static Set<Camera> findByModel(Set<Camera> cameras, String model) {
        Set<Camera> cameraSet;
        if (cameras == null) {
            cameraSet = CameraService.cameraSet;
        } else {
            cameraSet = cameras;
        }
        Set<Camera> byModel = new HashSet<>();
        for (Camera camera : cameraSet) {
            if (camera.getModel().equals(model)) {
                byModel.add(camera);
            }
        }

        return byModel;
    }

    public static Set<Camera> findByPrice(Set<Camera> cameras, double from, double to) {
        Set<Camera> cameraSet;
        if (cameras == null) {
            cameraSet = CameraService.cameraSet;
        } else {
            cameraSet = cameras;
        }
        int nullCounter = 0;
        for (Camera camera : cameraSet) {
            if (camera.getPrice() < from || camera.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == cameraSet.size()) {
            System.out.println("Cameras by range " + from + "$ to " + to + "$ has noy found:");
            return new HashSet<>();
        }

        Set<Camera> byPriceRange = new HashSet<>();
        for (Camera camera : cameraSet) {
            double price = camera.getPrice();
            if (price >= from && price <= to) {
                byPriceRange.add(camera);
            }
        }

        return byPriceRange;
    }

    public static Set<Camera> findByYear(Set<Camera> cameras, int year) {
        Set<Camera> cameraSet;
        if (cameras == null) {
            cameraSet = CameraService.cameraSet;
        } else {
            cameraSet = cameras;
        }
        Set<Camera> byYear = new HashSet<>();
        for (Camera camera : cameraSet) {
            if (camera.getYear() == year) {
                byYear.add(camera);
            }
        }

        return byYear;
    }

    public static Set<Camera> findModelByPrice(String model, double from, double to) {
        return findByPrice(findByModel(null, model), from, to);
    }

    public static Set<Camera> findModelByYear(String model, int year) {
        return findByYear(findByModel(null, model), year);
    }

    public static Set<Camera> findModelByDate(String model, String date) {
        return findByAddingDate(findByModel(null, model), date);
    }

    public static Set<Camera> findByAddingDate(Set<Camera> cameras, String date) {
        Set<Camera> cameraSet;
        if (cameras == null) {
            cameraSet = CameraService.cameraSet;
        } else {
            cameraSet = cameras;
        }
        Set<Camera> byAddingDate = new HashSet<>();
        for (Camera camera : cameraSet) {
            String cameraDate = camera.getDate().substring(0, camera.getDate().indexOf(' '));
            if (cameraDate.equals(date)) {
                byAddingDate.add(camera);
            }
        }

        return byAddingDate;
    }

    public static Camera newer() {
        return Collections.max(cameraSet, new YearComparator());
    }

    public static Camera older() {
        return Collections.min(cameraSet, new YearComparator());
    }

    public static Camera biggerCost() {
        return Collections.max(cameraSet, new CostComparator());
    }

    public static Camera smallerCost() {
        return Collections.min(cameraSet, new CostComparator());
    }

    public static Camera newerAdded() {
        return Collections.max(cameraSet, new DateComparator());
    }

    public static Camera olderAdded() {
        return Collections.min(cameraSet, new DateComparator());
    }

    public static List<Camera> ascendingOrderByPrice() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new CostComparator());
        return cameras;
    }

    public static List<Camera> descendingOrderByPrice() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new CostComparator().reversed());
        return cameras;
    }

    public static List<Camera> ascendingOrderByYear() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new YearComparator());
        return cameras;
    }

    public static List<Camera> descendingOrderByYear() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new YearComparator().reversed());
        return cameras;
    }

    public static List<Camera> ascendingOrderByAddingDate() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new DateComparator());
        return cameras;
    }

    public static List<Camera> descendingOrderByAddingDate() {
        List<Camera> cameras = new ArrayList<>(cameraSet);
        cameras.sort(new DateComparator(true));
        return cameras;
    }

    private static List<Camera> readFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        return ConverterService.readCamerasFile(strings);
    }

    private static void writeIntoFile(Camera camera) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("ID: " + camera.getId())
                .append("\nCamera-model: " + camera.getModel())
                .append("\nMegapixels: " + camera.getMegapixels())
                .append("\nPixel-dimensions: " + camera.getPixelDimensions())
                .append("\nPixel-size: " + camera.getPixelSize())
                .append("\nSensor-size: " + camera.getSensorSize())
                .append("\nAspect-ratio: " + camera.getAspectRatio())
                .append("\nImage-processor: " + camera.getImageProcessor())
                .append("\nSensor-stabilization: " + ((camera.isSensorStabilization()) ? "have sensor stabilization" : "haven't sensor stabilization"))
                .append("\nPower: " + camera.getPower())
                .append("\nPower-consumption: " + camera.getPowerConsumption())
                .append("\nYear: " + camera.getYear())
                .append("\nPrice: " + camera.getPrice())
                .append("\nDate: " + camera.getDate() + "\n" + "\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Collection<Camera> cameras) throws IOException {
        if (cameras == null) {
            cameras = readFromFile();
            for (Camera camera : cameras) {
                System.out.println(camera.toString());
            }
            return;
        }
        if (!cameras.isEmpty()) {
            for (Camera camera : cameras) {
                print(camera);
            }
            return;
        }
        System.out.println("No result");

    }

    public static void print(Camera camera) {
        System.out.println(camera.toString());
    }

}
