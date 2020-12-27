package picsart.main.phoneMenu;

import picsart.main.MainUtils;
import picsart.model.cellPhone.Phone;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CameraService;
import picsart.service.PhoneService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class PhoneMenu {
    public static UserModel cellphoneMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminCellphoneMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userCellphoneMenu(user);
        }
        return user;
    }

    private static void adminCellphoneMenu(UserModel user) throws IOException {
        System.out.println("\nPhone admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd phone:\n");
                    CameraService.create();
                    break;
                case 2:
                    System.out.println("\ncreate phones:\n");
                    System.out.println("how much phones to create:");
                    int size = s.nextInt();
                    System.out.println();
                    PhoneService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate phone by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    PhoneService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete phones by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    PhoneService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all phones:\n");
                    PhoneService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer phone:\n");
                    PhoneService.print(PhoneService.newer());
                    break;
                case 7:
                    System.out.println("\nolder phone:\n");
                    PhoneService.print(PhoneService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost phone:\n");
                    PhoneService.print(PhoneService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost phone:\n");
                    PhoneService.print(PhoneService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    PhoneService.print(PhoneService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    PhoneService.print(PhoneService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all phones:\n");
                    PhoneService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind phone by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    Phone byId = PhoneService.findById(id2);
                    if (byId != null) {
                        PhoneService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind phones by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind phones by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind phones by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind phones by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind phones by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String phoneModel = s.nextLine();
                    System.out.println("enter year:");
                    int phoneYear = s.nextInt();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByYear(phoneModel, phoneYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind phones by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String phoneModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String phoneAddingDate = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByDate(phoneModel1, phoneAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind phones by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String phoneModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByPrice(phoneModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit phone menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminCellphoneMenu(user);
            }
        }

    }

    private static void userCellphoneMenu(UserModel user) throws IOException {
        System.out.println("\nPhone user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer phone:\n");
                    PhoneService.print(PhoneService.newer());
                    break;
                case 2:
                    System.out.println("\nolder phone:\n");
                    PhoneService.print(PhoneService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost phone:\n");
                    PhoneService.print(PhoneService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost phone:\n");
                    PhoneService.print(PhoneService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    PhoneService.print(PhoneService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    PhoneService.print(PhoneService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    PhoneService.printAll(PhoneService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    PhoneService.printAll(PhoneService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all phones:\n");
                    PhoneService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind phone by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    Phone byId = PhoneService.findById(id);
                    if (byId != null) {
                        PhoneService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind phones by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind phones by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind phones by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind phones by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind phones by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String phoneModel = s.nextLine();
                    System.out.println("enter year:");
                    int phoneYear = s.nextInt();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByYear(phoneModel, phoneYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind phones by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String phoneModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String phoneAddingDate = s.nextLine();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByDate(phoneModel1, phoneAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind phones by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String phoneModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    PhoneService.printAll(PhoneService.findModelByPrice(phoneModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    Phone item = PhoneService.findById(id1);
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
                    System.out.println("Exit phone menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userCellphoneMenu(user);
            }
        }
    }
}
