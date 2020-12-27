package picsart.main.coffeeMakerMenu;

import picsart.main.MainUtils;
import picsart.model.coffeeMaker.CoffeeMaker;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CoffeeMakerService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class CoffeeMakerMenu {
    public static UserModel coffeeMakerMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminCoffeeMakerMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userCoffeeMakerMenu(user);
        }
        return user;
    }

    private static void adminCoffeeMakerMenu(UserModel user) throws IOException {
        System.out.println("\nCoffee maker admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd coffee maker:\n");
                    CoffeeMakerService.create();
                    break;
                case 2:
                    System.out.println("\ncreate coffee makers:\n");
                    System.out.println("how much cameras to create:");
                    int size = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate coffee maker by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete coffee makers by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all coffee makers:\n");
                    CoffeeMakerService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.newer());
                    break;
                case 7:
                    System.out.println("\nolder coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    CoffeeMakerService.print(CoffeeMakerService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    CoffeeMakerService.print(CoffeeMakerService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all coffee makers:\n");
                    CoffeeMakerService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind coffee maker by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    CoffeeMaker byId = CoffeeMakerService.findById(id2);
                    if (byId != null) {
                        CoffeeMakerService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind coffee makers by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind coffee makers by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind coffee makers by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind coffee makers by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind coffee makers by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String coffeeMakerModel = s.nextLine();
                    System.out.println("enter year:");
                    int coffeeMakerYear = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByYear(coffeeMakerModel, coffeeMakerYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind coffee makers by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String coffeeMakerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String coffeeMakerAddingDate = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByDate(coffeeMakerModel1, coffeeMakerAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind coffee makers by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String coffeeMakerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByPrice(coffeeMakerModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit coffee maker menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminCoffeeMakerMenu(user);
            }
        }

    }

    private static void userCoffeeMakerMenu(UserModel user) throws IOException {
        System.out.println("\nCoffee maker user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.newer());
                    break;
                case 2:
                    System.out.println("\nolder coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost coffee maker:\n");
                    CoffeeMakerService.print(CoffeeMakerService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    CoffeeMakerService.print(CoffeeMakerService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    CoffeeMakerService.print(CoffeeMakerService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    CoffeeMakerService.printAll(CoffeeMakerService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all coffee makers:\n");
                    CoffeeMakerService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind coffee maker by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    CoffeeMaker byId = CoffeeMakerService.findById(id);
                    if (byId != null) {
                        CoffeeMakerService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind coffee makers by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind coffee makers by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind coffee makers by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind coffee makers by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind coffee makers by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String coffeeMakerModel = s.nextLine();
                    System.out.println("enter year:");
                    int coffeeMakerYear = s.nextInt();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByYear(coffeeMakerModel, coffeeMakerYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind coffee makers by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String coffeeMakerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String coffeeMakerAddingDate = s.nextLine();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByDate(coffeeMakerModel1, coffeeMakerAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind coffee makers by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String coffeeMakerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    CoffeeMakerService.printAll(CoffeeMakerService.findModelByPrice(coffeeMakerModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    CoffeeMaker item = CoffeeMakerService.findById(id1);
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
                    System.out.println("Exit coffee maker menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userCoffeeMakerMenu(user);
            }
        }
    }
}
