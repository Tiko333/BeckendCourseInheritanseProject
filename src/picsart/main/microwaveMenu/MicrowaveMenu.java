package picsart.main.microwaveMenu;

import picsart.main.MainUtils;
import picsart.model.microwave.Microwave;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CameraService;
import picsart.service.MicrowaveService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class MicrowaveMenu {
    public static UserModel microwaveMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminMicrowaveMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userMicrowaveMenu(user);
        }
        return user;
    }

    private static void adminMicrowaveMenu(UserModel user) throws IOException {
        System.out.println("\nMicrowave admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd microwave:\n");
                    MicrowaveService.create();
                    break;
                case 2:
                    System.out.println("\ncreate microwaves:\n");
                    System.out.println("how much microwaves to create:");
                    int size = s.nextInt();
                    System.out.println();
                    MicrowaveService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate microwave by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    MicrowaveService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete microwaves by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    MicrowaveService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all microwaves:\n");
                    CameraService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer microwave:\n");
                    MicrowaveService.print(MicrowaveService.newer());
                    break;
                case 7:
                    System.out.println("\nolder microwave:\n");
                    MicrowaveService.print(MicrowaveService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost microwave:\n");
                    MicrowaveService.print(MicrowaveService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost microwave:\n");
                    MicrowaveService.print(MicrowaveService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    MicrowaveService.print(MicrowaveService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    MicrowaveService.print(MicrowaveService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all microwaves:\n");
                    MicrowaveService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind microwave by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    Microwave byId = MicrowaveService.findById(id2);
                    if (byId != null) {
                        MicrowaveService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind microwaves by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind microwaves by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind microwaves by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind microwaves by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind microwaves by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String microwaveModel = s.nextLine();
                    System.out.println("enter year:");
                    int microwaveYear = s.nextInt();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByYear(microwaveModel, microwaveYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind microwaves by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String microwaveModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String microwaveAddingDate = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByDate(microwaveModel1, microwaveAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind microwaves by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String microwaveModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByPrice(microwaveModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit microwave menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminMicrowaveMenu(user);
            }
        }

    }

    private static void userMicrowaveMenu(UserModel user) throws IOException {
        System.out.println("\nMicrowave user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer microwave:\n");
                    MicrowaveService.print(MicrowaveService.newer());
                    break;
                case 2:
                    System.out.println("\nolder microwave:\n");
                    MicrowaveService.print(MicrowaveService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost microwave:\n");
                    MicrowaveService.print(MicrowaveService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost microwave:\n");
                    MicrowaveService.print(MicrowaveService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    MicrowaveService.print(MicrowaveService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    MicrowaveService.print(MicrowaveService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    MicrowaveService.printAll(MicrowaveService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    MicrowaveService.printAll(MicrowaveService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all microwaves:\n");
                    MicrowaveService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind microwave by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    Microwave byId = MicrowaveService.findById(id);
                    if (byId != null) {
                        MicrowaveService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind microwaves by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind microwaves by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind microwaves by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind microwaves by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind microwaves by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String microwaveModel = s.nextLine();
                    System.out.println("enter year:");
                    int microwaveYear = s.nextInt();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByYear(microwaveModel, microwaveYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind microwaves by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String microwaveModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String microwaveAddingDate = s.nextLine();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByDate(microwaveModel1, microwaveAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind microwaves by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String microwaveModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    MicrowaveService.printAll(MicrowaveService.findModelByPrice(microwaveModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    Microwave item = MicrowaveService.findById(id1);
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
                    System.out.println("Exit microwave menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userMicrowaveMenu(user);
            }
        }
    }
}
