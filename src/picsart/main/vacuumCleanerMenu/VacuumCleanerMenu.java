package picsart.main.vacuumCleanerMenu;

import picsart.main.MainUtils;
import picsart.model.vacuumCleaner.VacuumCleaner;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CameraService;
import picsart.service.UserService;
import picsart.service.VacuumCleanerService;

import java.io.IOException;
import java.util.Scanner;

public class VacuumCleanerMenu {
    public static UserModel vacuumCleanerMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminVacuumCleanerMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userVacuumCleanerMenu(user);
        }
        return user;
    }

    private static void adminVacuumCleanerMenu(UserModel user) throws IOException {
        System.out.println("\nVacuum cleaner admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd vacuum cleaner:\n");
                    VacuumCleanerService.create();
                    break;
                case 2:
                    System.out.println("\ncreate vacuum cleaners:\n");
                    System.out.println("how much vacuum cleaners to create:");
                    int size = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate vacuum cleaner by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete vacuum cleaners by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all vacuum cleaners:\n");
                    VacuumCleanerService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.newer());
                    break;
                case 7:
                    System.out.println("\nolder vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    VacuumCleanerService.print(VacuumCleanerService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    VacuumCleanerService.print(VacuumCleanerService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all vacuum cleaners:\n");
                    VacuumCleanerService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind vacuum cleaner by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    VacuumCleaner byId = VacuumCleanerService.findById(id2);
                    if (byId != null) {
                        VacuumCleanerService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind vacuum cleaners by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind vacuum cleaners by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    CameraService.printAll(CameraService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind vacuum cleaners by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind vacuum cleaners by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind vacuum cleaners by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String vacuumCleanerModel = s.nextLine();
                    System.out.println("enter year:");
                    int vacuumCleanerYear = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByYear(vacuumCleanerModel, vacuumCleanerYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind vacuum cleaners by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String vacuumCleanerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String vacuumCleanerAddingDate = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByDate(vacuumCleanerModel1, vacuumCleanerAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind vacuum cleaners by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String vacuumCleanerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByPrice(vacuumCleanerModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit vacuum cleaner menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminVacuumCleanerMenu(user);
            }
        }

    }

    private static void userVacuumCleanerMenu(UserModel user) throws IOException {
        System.out.println("\nVacuum cleaner user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.newer());
                    break;
                case 2:
                    System.out.println("\nolder vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost vacuum cleaner:\n");
                    VacuumCleanerService.print(VacuumCleanerService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    VacuumCleanerService.print(VacuumCleanerService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    VacuumCleanerService.print(VacuumCleanerService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    VacuumCleanerService.printAll(VacuumCleanerService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all vacuum cleaners:\n");
                    VacuumCleanerService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind vacuum cleaner by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    VacuumCleaner byId = VacuumCleanerService.findById(id);
                    if (byId != null) {
                        VacuumCleanerService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind vacuum cleaners by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind vacuum cleaners by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind vacuum cleaners by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind vacuum cleaners by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind vacuum cleaners by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String vacuumCleanerModel = s.nextLine();
                    System.out.println("enter year:");
                    int vacuumCleanerYear = s.nextInt();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByYear(vacuumCleanerModel, vacuumCleanerYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind vacuum cleaners by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String vacuumCleanerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String vacuumCleanerAddingDate = s.nextLine();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByDate(vacuumCleanerModel1, vacuumCleanerAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind vacuum cleaners by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String vacuumCleanerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    VacuumCleanerService.printAll(VacuumCleanerService.findModelByPrice(vacuumCleanerModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    VacuumCleaner item = VacuumCleanerService.findById(id1);
                    if (item != null) {
                        UserService.updateCartByUserName(user, item, amount);
                    }
                    break;
                case 23:
                    System.out.println("cart items:");
                    UserService.printCart(user);
                    break;
                case 24:
                    System.out.println("Buy cart items:");
                    UserService.buyItems(user);
                    break;
                case 25:
                    isMenuActive = false;
                    System.out.println("Exit vacuum cleaner menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userVacuumCleanerMenu(user);
            }
        }
    }
}
