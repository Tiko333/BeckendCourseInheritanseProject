package picsart.main.conditionerMenu;

import picsart.main.MainUtils;
import picsart.model.conditioner.Conditioner;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.ConditionerService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class ConditionerMenu {
    public static UserModel conditionerMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminConditionerMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userConditionerMenu(user);
        }
        return user;
    }

    private static void adminConditionerMenu(UserModel user) throws IOException {
        System.out.println("\nConditioner admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd conditioner:\n");
                    ConditionerService.create();
                    break;
                case 2:
                    System.out.println("\ncreate conditioners:\n");
                    System.out.println("how much conditioners to create:");
                    int size = s.nextInt();
                    System.out.println();
                    ConditionerService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate conditioner by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    ConditionerService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete conditioners by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    ConditionerService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all conditioners:\n");
                    ConditionerService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer conditioner:\n");
                    ConditionerService.print(ConditionerService.newer());
                    break;
                case 7:
                    System.out.println("\nolder conditioner:\n");
                    ConditionerService.print(ConditionerService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost conditioner:\n");
                    ConditionerService.print(ConditionerService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost conditioner:\n");
                    ConditionerService.print(ConditionerService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    ConditionerService.print(ConditionerService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    ConditionerService.print(ConditionerService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all conditioners:\n");
                    ConditionerService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind conditioner by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    Conditioner byId = ConditionerService.findById(id2);
                    if (byId != null) {
                        ConditionerService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind conditioners by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind conditioners by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind conditioners by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind conditioners by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind conditioners by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String conditionerModel = s.nextLine();
                    System.out.println("enter year:");
                    int conditionerYear = s.nextInt();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByYear(conditionerModel, conditionerYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind conditioners by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String conditionerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String conditionerAddingDate = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByDate(conditionerModel1, conditionerAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind conditioners by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String conditionerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByPrice(conditionerModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit conditioner menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminConditionerMenu(user);
            }
        }

    }

    private static void userConditionerMenu(UserModel user) throws IOException {
        System.out.println("\nConditioner user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer conditioner:\n");
                    ConditionerService.print(ConditionerService.newer());
                    break;
                case 2:
                    System.out.println("\nolder conditioner:\n");
                    ConditionerService.print(ConditionerService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost conditioner:\n");
                    ConditionerService.print(ConditionerService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost conditioner:\n");
                    ConditionerService.print(ConditionerService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    ConditionerService.print(ConditionerService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    ConditionerService.print(ConditionerService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    ConditionerService.printAll(ConditionerService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    ConditionerService.printAll(ConditionerService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all cameras:\n");
                    ConditionerService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind conditioner by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    Conditioner byId = ConditionerService.findById(id);
                    if (byId != null) {
                        ConditionerService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind conditioners by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind conditioners by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind conditioners by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind conditioners by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind conditioners by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String conditionerModel = s.nextLine();
                    System.out.println("enter year:");
                    int conditionerYear = s.nextInt();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByYear(conditionerModel, conditionerYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind conditioners by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String conditionerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String conditionerAddingDate = s.nextLine();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByDate(conditionerModel1, conditionerAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind conditioners by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String conditionerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    ConditionerService.printAll(ConditionerService.findModelByPrice(conditionerModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    Conditioner item = ConditionerService.findById(id1);
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
                    System.out.println("Exit camera menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userConditionerMenu(user);
            }
        }
    }
}
