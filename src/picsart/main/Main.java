package picsart.main;

import picsart.model.cellPhone.Phone;
import picsart.service.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String ENTER_COMMAND_NUMBER = "Enter command number:";

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("Menu\n");
            System.out.println("1. Camera");
            System.out.println("2. Cellphone");
            System.out.println("3. Computer");
            System.out.println("4. TV");
            System.out.println("5. Game Console");
            System.out.println("6. exit\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    cameraMenu();
                    break;
                case 2:
                    cellphoneMenu();
                    break;
                case 3:
                    computersMenu();
                    break;
                case 4:
                    tvMenu();
                    break;
                case 5:
                    consoleMenu();
                    break;
                case 6:
                    isMenuActive = false;
                    break;
            }
        }
    }

    private static void cameraMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nCamera menu:\n");
            System.out.println("1. add camera");
            System.out.println("2. create cameras");
            System.out.println("3. newer camera");
            System.out.println("4. older camera");
            System.out.println("5. bigger cost camera");
            System.out.println("6. smaller cost camera");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all cameras");
            System.out.println("12. find camera by ID");
            System.out.println("13. find cameras by model");
            System.out.println("14. find cameras by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd camera:\n");
                    CameraService.create();
                    break;
                case 2:
                    System.out.println("\ncreate cameras:\n");
                    System.out.println("how much cameras to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    CameraService.createCameras(size);
                    break;
                case 3:
                    System.out.println("\nnewer camera:\n");
                    CameraService.newerCamera();
                    break;
                case 4:
                    System.out.println("\nolder camera:\n");
                    CameraService.olderCamera();
                    break;
                case 5:
                    System.out.println("\nbigger cost camera:\n");
                    CameraService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost camera:\n");
                    CameraService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    CameraService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    CameraService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    CameraService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    CameraService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all consoles:\n");
                    CameraService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind camera by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    CameraService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind cameras by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    CameraService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind cameras by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    CameraService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit camera menu:");
                    break;
            }
        }
    }

    private static void cellphoneMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nPhone menu:\n");
            System.out.println("1. add phone");
            System.out.println("2. create phones");
            System.out.println("3. newer phone");
            System.out.println("4. older phone");
            System.out.println("5. bigger cost phone");
            System.out.println("6. smaller cost phone");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all phones");
            System.out.println("12. find phone by ID");
            System.out.println("13. find phones by model");
            System.out.println("14. find phones by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd phone:\n");
                    PhoneService.create();
                    break;
                case 2:
                    System.out.println("\ncreate phones:\n");
                    System.out.println("how much phones to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    PhoneService.createPhones(size);
                    break;
                case 3:
                    System.out.println("\nnewer phone:\n");
                    PhoneService.newerPhone();
                    break;
                case 4:
                    System.out.println("\nolder phone:\n");
                    PhoneService.olderPhone();
                    break;
                case 5:
                    System.out.println("\nbigger cost phone:\n");
                    PhoneService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost phone:\n");
                    PhoneService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    PhoneService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    PhoneService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    PhoneService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    PhoneService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all phones:\n");
                    PhoneService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind phone by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    PhoneService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind phones by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    PhoneService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind phones by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    PhoneService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit phone menu:");
                    break;
            }
        }
    }

    private static void computersMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nComputers menu:\n");
            System.out.println("1. computers");
            System.out.println("2. laptops");
            System.out.println("3. back");
            Scanner s = new Scanner(System.in);
            System.out.println();
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\ncomputers:\n");
                    computerMenu();
                    break;
                case 2:
                    System.out.println("\nlaptops:\n");
                    laptopMenu();
                    break;
                case 3:
                    isMenuActive = false;
                    System.out.println("Exit computers menu:");
                    break;
            }

        }
    }

    private static void computerMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nComputer menu:\n");
            System.out.println("1. add computer");
            System.out.println("2. create computers");
            System.out.println("3. newer computer");
            System.out.println("4. older computer");
            System.out.println("5. bigger cost computer");
            System.out.println("6. smaller cost computer");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all computers");
            System.out.println("12. find computer by ID");
            System.out.println("13. find computers by model");
            System.out.println("14. find computers by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd computer:\n");
                    ComputerService.create();
                    break;
                case 2:
                    System.out.println("\ncreate computers:\n");
                    System.out.println("how much computers to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    ComputerService.createComputers(size);
                    break;
                case 3:
                    System.out.println("\nnewer computer:\n");
                    ComputerService.newerComputer();
                    break;
                case 4:
                    System.out.println("\nolder computer:\n");
                    ComputerService.olderComputer();
                    break;
                case 5:
                    System.out.println("\nbigger cost computer:\n");
                    ComputerService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost computer:\n");
                    ComputerService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    ComputerService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    ComputerService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    ComputerService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    ComputerService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all computers:\n");
                    ComputerService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind computer by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    ComputerService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind computers by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    ComputerService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind computers by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    ComputerService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit computer menu:");
                    break;
            }
        }
    }

    private static void laptopMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nLaptop menu:\n");
            System.out.println("1. add laptop");
            System.out.println("2. create laptops");
            System.out.println("3. newer laptop");
            System.out.println("4. older laptop");
            System.out.println("5. bigger cost laptop");
            System.out.println("6. smaller cost laptop");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all laptops");
            System.out.println("12. find laptop by ID");
            System.out.println("13. find laptops by model");
            System.out.println("14. find laptops by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd laptop:\n");
                    LaptopService.create();
                    break;
                case 2:
                    System.out.println("\ncreate laptops:\n");
                    System.out.println("how much laptops to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    LaptopService.createLaptops(size);
                    break;
                case 3:
                    System.out.println("\nnewer laptop:\n");
                    LaptopService.newerLaptop();
                    break;
                case 4:
                    System.out.println("\nolder laptop:\n");
                    LaptopService.olderLaptop();
                    break;
                case 5:
                    System.out.println("\nbigger cost laptop:\n");
                    LaptopService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost laptop:\n");
                    LaptopService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    LaptopService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    LaptopService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    LaptopService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    LaptopService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all computers:\n");
                    LaptopService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind laptop by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    LaptopService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind laptops by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    LaptopService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind laptops by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    LaptopService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit laptop menu:");
                    break;
            }
        }
    }

    private static void tvMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nTV menu:\n");
            System.out.println("1. add tv");
            System.out.println("2. create tvs");
            System.out.println("3. newer tv");
            System.out.println("4. older tv");
            System.out.println("5. bigger cost tv");
            System.out.println("6. smaller cost tv");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all tvs");
            System.out.println("12. find tv by ID");
            System.out.println("13. find tvs by model");
            System.out.println("14. find tvs by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd tv:\n");
                    TVService.create();
                    break;
                case 2:
                    System.out.println("\ncreate tvs:\n");
                    System.out.println("how much tvs to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    TVService.createTvs(size);
                    break;
                case 3:
                    System.out.println("\nnewer tv:\n");
                    TVService.newerTv();
                    break;
                case 4:
                    System.out.println("\nolder tv:\n");
                    TVService.olderTv();
                    break;
                case 5:
                    System.out.println("\nbigger cost tv:\n");
                    TVService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost tv:\n");
                    TVService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    TVService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    TVService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    TVService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    TVService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all tvs:\n");
                    TVService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind tv by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    TVService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind tvs by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    TVService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind tvs by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    TVService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit laptop menu:");
                    break;
            }
        }
    }

    private static void consoleMenu() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            System.out.println("\n\nGame console menu:\n");
            System.out.println("1. add console");
            System.out.println("2. create consoles");
            System.out.println("3. newer console");
            System.out.println("4. older console");
            System.out.println("5. bigger cost console");
            System.out.println("6. smaller cost console");
            System.out.println("7. ascending order by price");
            System.out.println("8. descending order by price");
            System.out.println("9. ascending order by year");
            System.out.println("10. descending order by year");
            System.out.println("11. print all consoles");
            System.out.println("12. find console by ID");
            System.out.println("13. find consoles by model");
            System.out.println("14. find consoles by price");
            System.out.println("15. back\n");
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd console:\n");
                    ConsoleService.create();
                    break;
                case 2:
                    System.out.println("\ncreate consoles:\n");
                    System.out.println("how much consoles to create:");
                    Scanner sizeScanner = new Scanner(System.in);
                    int size = sizeScanner.nextInt();
                    System.out.println();
                    ConsoleService.createConsoles(size);
                    break;
                case 3:
                    System.out.println("\nnewer console:\n");
                    ConsoleService.newerConsole();
                    break;
                case 4:
                    System.out.println("\nolder console:\n");
                    ConsoleService.olderConsole();
                    break;
                case 5:
                    System.out.println("\nbigger cost console:\n");
                    ConsoleService.biggerCost();
                    break;
                case 6:
                    System.out.println("\nsmaller cost console:\n");
                    ConsoleService.smallerCost();
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    ConsoleService.ascendingOrderByPrice();
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    ConsoleService.descendingOrderByPrice();
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    ConsoleService.ascendingOrderByYear();
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    ConsoleService.descendingOrderByYear();
                    break;
                case 11:
                    System.out.println("\nprint all consoles:\n");
                    ConsoleService.printAll(null);
                    break;
                case 12:
                    System.out.println("\nfind console by ID:\n");
                    System.out.println("enter the ID:");
                    Scanner idScanner = new Scanner(System.in);
                    int id = idScanner.nextInt();
                    System.out.println();
                    ConsoleService.findById(id);
                    break;
                case 13:
                    System.out.println("\nfind consoles by model:\n");
                    Scanner modelScanner = new Scanner(System.in);
                    String model = modelScanner.nextLine();
                    System.out.println();
                    ConsoleService.findByModel(model);
                    break;
                case 14:
                    System.out.println("\nfind consoles by price:\n");
                    Scanner priceScanner = new Scanner(System.in);
                    System.out.println("Enter from price:");
                    int from = priceScanner.nextInt();
                    System.out.println("Enter to price:");
                    int to = priceScanner.nextInt();
                    System.out.println();
                    ConsoleService.findByPrice(from, to);
                    System.out.println();
                    break;
                case 15:
                    isMenuActive = false;
                    System.out.println("Exit console menu:");
                    break;
            }
        }
    }
}
