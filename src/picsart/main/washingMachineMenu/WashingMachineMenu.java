package picsart.main.washingMachineMenu;

import picsart.main.MainUtils;
import picsart.model.washingMachine.WashingMachine;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.UserService;
import picsart.service.WashingMachineService;

import java.io.IOException;
import java.util.Scanner;

public class WashingMachineMenu {
    public static UserModel washingMachineMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminWashingMachineMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userWashingMachineMenu(user);
        }
        return user;
    }

    private static void adminWashingMachineMenu(UserModel user) throws IOException {
        System.out.println("\nWashing machine admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd washing machine:\n");
                    WashingMachineService.create();
                    break;
                case 2:
                    System.out.println("\ncreate washing machines:\n");
                    System.out.println("how much washing machines to create:");
                    int size = s.nextInt();
                    System.out.println();
                    WashingMachineService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate washing machine by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    WashingMachineService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete washing machines by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    WashingMachineService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all washing machines:\n");
                    WashingMachineService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer washing machine:\n");
                    WashingMachineService.print(WashingMachineService.newer());
                    break;
                case 7:
                    System.out.println("\nolder washing machine:\n");
                    WashingMachineService.print(WashingMachineService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost washing machine:\n");
                    WashingMachineService.print(WashingMachineService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost washing machine:\n");
                    WashingMachineService.print(WashingMachineService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    WashingMachineService.print(WashingMachineService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    WashingMachineService.print(WashingMachineService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all washing machines:\n");
                    WashingMachineService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind washing machine by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    WashingMachine byId = WashingMachineService.findById(id2);
                    if (byId != null) {
                        WashingMachineService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind washing machines by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind washing machines by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind washing machines by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind washing machines by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind washing machines by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String washingMachineModel = s.nextLine();
                    System.out.println("enter year:");
                    int washingMachineYear = s.nextInt();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByYear(washingMachineModel, washingMachineYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind washing machines by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String washingMachineModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String washingMachineAddingDate = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByDate(washingMachineModel1, washingMachineAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind washing machines by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String washingMachineModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByPrice(washingMachineModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit washing machine menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminWashingMachineMenu(user);
            }
        }

    }

    private static void userWashingMachineMenu(UserModel user) throws IOException {
        System.out.println("\nWashing machine user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer washing machine:\n");
                    WashingMachineService.print(WashingMachineService.newer());
                    break;
                case 2:
                    System.out.println("\nolder washing machine:\n");
                    WashingMachineService.print(WashingMachineService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost washing machine:\n");
                    WashingMachineService.print(WashingMachineService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost washing machine:\n");
                    WashingMachineService.print(WashingMachineService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    WashingMachineService.print(WashingMachineService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    WashingMachineService.print(WashingMachineService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    WashingMachineService.printAll(WashingMachineService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    WashingMachineService.printAll(WashingMachineService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all washing machines:\n");
                    WashingMachineService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind washing machine by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    WashingMachine byId = WashingMachineService.findById(id);
                    if (byId != null) {
                        WashingMachineService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind washing machines by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind washing machines by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind washing machines by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind washing machines by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind washing machines by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String washingMachineModel = s.nextLine();
                    System.out.println("enter year:");
                    int washingMachineYear = s.nextInt();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByYear(washingMachineModel, washingMachineYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind washing machines by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String washingMachineModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String washingMachineAddingDate = s.nextLine();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByDate(washingMachineModel1, washingMachineAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind washing machines by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String washingMachineModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    WashingMachineService.printAll(WashingMachineService.findModelByPrice(washingMachineModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    WashingMachine item = WashingMachineService.findById(id1);
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
                    System.out.println("Exit washing machine menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userWashingMachineMenu(user);
            }
        }
    }
}
