package picsart.service;

import picsart.model.camera.Camera;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class CameraService {
    private static final String FILE_PATH = "src/picsart/files/cameras.txt";

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
        return camera;
    }

    public static Camera[] createCameras(int size) throws IOException {
        Camera[] cameras = new Camera[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Creating camera number: " + (i + 1));
            cameras[i] = create();
        }

        return cameras;
    }

    public static Camera findById(long id) throws IOException {
        Camera[] cameras = readCamerasFromFile();
        for (Camera camera : cameras) {
            if (camera.getId() == id) {
                System.out.println(camera.toString());
                return camera;
            }
        }

        System.out.println("Camera by ID: " + id + " does not exist");
        return null;
    }

    public static void findByModel(String model) throws IOException {
        Camera[] cameras = readCamerasFromFile();
        boolean isFound = false;
        for (int i = 0; i < cameras.length; i++) {
            Camera camera = cameras[i];
            if (camera.getModel().equals(model)) {
                System.out.println(camera.toString());
                isFound = true;
                continue;
            }
            if (isFound && (i == cameras.length - 1)) {
                return;
            }
        }

        if (!isFound) {
            System.out.println("There is no camera by model: " + model);
        }
    }

    public static Camera[] findByPrice(double from, double to) throws IOException {
        Camera[] cameras = readCamerasFromFile();
        int nullCounter = 0;
        for (Camera phone : cameras) {
            if (phone.getPrice() < from || phone.getPrice() > to) {
                nullCounter++;
            }
        }
        if (nullCounter == cameras.length) {
            System.out.println("Cameras by range " + from + "$ to " + to + "$ has noy found:");
            return new Camera[0];
        }
        int index = 0;
        Camera[] selectedPhonesByPriceRange = new Camera[cameras.length - nullCounter];
        for (Camera phone : cameras) {
            double price = phone.getPrice();
            if (price >= from && price <= to) {
                selectedPhonesByPriceRange[index++] = phone;
            }
        }

        printAll(selectedPhonesByPriceRange);
        return selectedPhonesByPriceRange;
    }

    public static Camera newerCamera() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        Camera newerCamera = cameras[0];
        for (Camera camera : cameras) {
            if (camera.getYear() >= newerCamera.getYear()) {
                newerCamera = camera;
            }
        }

        printConsole(newerCamera);
        return newerCamera;
    }

    public static Camera olderCamera() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        Camera olderCamera = cameras[0];
        for (Camera camera : cameras) {
            if (camera.getYear() < olderCamera.getYear()) {
                olderCamera = camera;
            }
        }

        printConsole(olderCamera);
        return olderCamera;
    }

    public static Camera biggerCost() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        Camera biggerCostCamera = cameras[0];
        for (Camera camera : cameras) {
            if (camera.getPrice() > biggerCostCamera.getPrice()) {
                biggerCostCamera = camera;
            }
        }

        printConsole(biggerCostCamera);
        return biggerCostCamera;
    }

    public static Camera smallerCost() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        Camera smallerCostCamera = cameras[0];
        for (Camera camera : cameras) {
            if (camera.getPrice() < smallerCostCamera.getPrice()) {
                smallerCostCamera = camera;
            }
        }

        printConsole(smallerCostCamera);
        return smallerCostCamera;
    }

    public static Camera[] ascendingOrderByPrice() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        for (int i = 0; i < cameras.length; i++) {
            for (int j = 1; j < cameras.length - i; j++) {
                if (cameras[j - 1].getPrice() > cameras[j].getPrice()) {
                    Camera temp = cameras[j];
                    cameras[j] = cameras[j - 1];
                    cameras[j - 1] = temp;
                }
            }
        }

        printAll(cameras);
        return cameras;
    }

    public static Camera[] descendingOrderByPrice() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        for (int i = 0; i < cameras.length; i++) {
            for (int j = 1; j < cameras.length - i; j++) {
                if (cameras[j - 1].getPrice() < cameras[j].getPrice()) {
                    Camera temp = cameras[j];
                    cameras[j] = cameras[j - 1];
                    cameras[j - 1] = temp;
                }
            }
        }

        printAll(cameras);
        return cameras;
    }

    public static Camera[] ascendingOrderByYear() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        for (int i = 0; i < cameras.length; i++) {
            for (int j = 1; j < cameras.length - i; j++) {
                if (cameras[j - 1].getYear() > cameras[j].getYear()) {
                    Camera temp = cameras[j];
                    cameras[j] = cameras[j - 1];
                    cameras[j - 1] = temp;
                }
            }
        }

        printAll(cameras);
        return cameras;
    }

    public static Camera[] descendingOrderByYear() throws IOException {
        Camera[] cameras = readCamerasFromFile();
        for (int i = 0; i < cameras.length; i++) {
            for (int j = 1; j < cameras.length - i; j++) {
                if (cameras[j - 1].getYear() < cameras[j].getYear()) {
                    Camera temp = cameras[j];
                    cameras[j] = cameras[j - 1];
                    cameras[j - 1] = temp;
                }
            }
        }

        printAll(cameras);
        return cameras;
    }

    private static Camera[] readCamerasFromFile() throws IOException {
        String[] strings = Files.readAllLines(Path.of(FILE_PATH)).toArray(new String[0]);

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
                .append("\nSensor-stabilization: " + ((camera.isSensorStabilization()) ? "have sensor stabilization" : "haven't not sensor stabilization"))
                .append("\nPower: " + camera.getPower())
                .append("\nPower-consumption: " + camera.getPowerConsumption())
                .append("\nYear: " + camera.getYear())
                .append("\nPrice: " + camera.getPrice() + "\n" + "\n");

        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        Files.write(Paths.get(FILE_PATH), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void printAll(Camera[] cameras) throws IOException {
        if (cameras == null) {
            cameras = readCamerasFromFile();
            for (Camera camera : cameras) {
                System.out.println(camera.toString());
            }
            return;
        }
        for (Camera camera : cameras) {
            System.out.println(camera.toString());
        }
    }

    public static void printConsole(Camera camera) {
        System.out.println(camera.toString());
    }
}