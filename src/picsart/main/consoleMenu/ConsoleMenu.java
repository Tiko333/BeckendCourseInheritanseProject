package picsart.main.consoleMenu;

import picsart.main.MainUtils;
import picsart.model.videoGameConsole.Console;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.ConsoleService;
import picsart.service.TVService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleMenu {
        public static UserModel consoleMenu(UserModel user) throws IOException {
            if (user.getRole() == Role.ADMIN) {
                adminConsoleMenu(user);
            }
            if (user.getRole() == Role.USER) {
                userConsoleMenu(user);
            }
            return user;
        }

        private static void adminConsoleMenu(UserModel user) throws IOException {
            System.out.println("\nConsole admin menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nadd console:\n");
                        ConsoleService.create();
                        break;
                    case 2:
                        System.out.println("\ncreate consoles:\n");
                        System.out.println("how much consoles to create:");
                        int size = s.nextInt();
                        System.out.println();
                        ConsoleService.multipleCreate(size);
                        break;
                    case 3:
                        System.out.println("\nupdate console by id:\n");
                        System.out.println("enter ID");
                        int id = s.nextInt();
                        System.out.println();
                        ConsoleService.updateById(id);
                        break;
                    case 4:
                        System.out.println("\ndelete console by id :\n");
                        System.out.println("enter ID");
                        int id1 = s.nextInt();
                        System.out.println();
                        ConsoleService.deleteById(id1);
                        break;
                    case 5:
                        System.out.println("\ndelete all consoles:\n");
                        ConsoleService.deleteAll();
                        break;
                    case 6:
                        System.out.println("\nnewer console:\n");
                        ConsoleService.print(ConsoleService.newer());
                        break;
                    case 7:
                        System.out.println("\nolder console:\n");
                        ConsoleService.print(ConsoleService.older());
                        break;
                    case 8:
                        System.out.println("\nbigger cost console:\n");
                        ConsoleService.print(ConsoleService.biggerCost());
                        break;
                    case 9:
                        System.out.println("\nsmaller cost console:\n");
                        ConsoleService.print(ConsoleService.smallerCost());
                        break;
                    case 10:
                        System.out.println("\nnewer added:\n");
                        ConsoleService.print(ConsoleService.newerAdded());
                        break;
                    case 11:
                        System.out.println("\nolder added:\n");
                        ConsoleService.print(ConsoleService.olderAdded());
                        break;
                    case 12:
                        System.out.println("\nascending order by price:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByPrice());
                        break;
                    case 13:
                        System.out.println("\ndescending order by price:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByPrice());
                        break;
                    case 14:
                        System.out.println("\nascending order by year:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByYear());
                        break;
                    case 15:
                        System.out.println("\ndescending order by year:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByYear());
                        break;
                    case 16:
                        System.out.println("\nascending order by adding date:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByAddingDate());
                        break;
                    case 17:
                        System.out.println("\ndescending order by adding date:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByAddingDate());
                        break;
                    case 18:
                        System.out.println("\nprint all tvs:\n");
                        ConsoleService.printAll(null);
                        break;
                    case 19:
                        System.out.println("\nfind console by ID:\n");
                        System.out.println("enter the ID:");
                        int id2 = s.nextInt();
                        System.out.println();
                        Console byId = ConsoleService.findById(id2);
                        if (byId != null) {
                            ConsoleService.print(byId);
                        }
                        break;
                    case 20:
                        System.out.println("\nfind consoles by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByModel(null, model));
                        break;
                    case 21:
                        System.out.println("\nfind consoles by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByYear(null, year));
                        break;
                    case 22:
                        System.out.println("\nfind consoles by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByAddingDate(null, date));
                        break;
                    case 23:
                        System.out.println("\nfind consoles by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 24:
                        System.out.println("\nfind consoles by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String consoleModel = s.nextLine();
                        System.out.println("enter year:");
                        int consoleYear = s.nextInt();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByYear(consoleModel, consoleYear));
                        System.out.println();
                        break;
                    case 25:
                        System.out.println("\nfind consoles by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String consoleModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String consoleAddingDate = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByDate(consoleModel1, consoleAddingDate));
                        System.out.println();
                        break;
                    case 26:
                        System.out.println("\nfind tvs by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String consoleModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByPrice(consoleModel2, from1, to1));
                        System.out.println();
                        break;
                    case 27:
                        isMenuActive = false;
                        System.out.println("Exit console menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        adminConsoleMenu(user);
                }
            }

        }

        private static void userConsoleMenu(UserModel user) throws IOException {
            System.out.println("\nConsole user menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nnewer console:\n");
                        ConsoleService.print(ConsoleService.newer());
                        break;
                    case 2:
                        System.out.println("\nolder console:\n");
                        ConsoleService.print(ConsoleService.older());
                        break;
                    case 3:
                        System.out.println("\nbigger cost console:\n");
                        ConsoleService.print(ConsoleService.biggerCost());
                        break;
                    case 4:
                        System.out.println("\nsmaller cost console:\n");
                        ConsoleService.print(ConsoleService.smallerCost());
                        break;
                    case 5:
                        System.out.println("\nnewer added:\n");
                        ConsoleService.print(ConsoleService.newerAdded());
                        break;
                    case 6:
                        System.out.println("\nolder added:\n");
                        ConsoleService.print(ConsoleService.olderAdded());
                        break;
                    case 7:
                        System.out.println("\nascending order by price:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByPrice());
                        break;
                    case 8:
                        System.out.println("\ndescending order by price:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByPrice());
                        break;
                    case 9:
                        System.out.println("\nascending order by year:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByYear());
                        break;
                    case 10:
                        System.out.println("\ndescending order by year:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByYear());
                        break;
                    case 11:
                        System.out.println("\nascending order by adding date:\n");
                        ConsoleService.printAll(ConsoleService.ascendingOrderByAddingDate());
                        break;
                    case 12:
                        System.out.println("\ndescending order by adding date:\n");
                        ConsoleService.printAll(ConsoleService.descendingOrderByAddingDate());
                        break;
                    case 13:
                        System.out.println("\nprint all consoles:\n");
                        ConsoleService.printAll(null);
                        break;
                    case 14:
                        System.out.println("\nfind console by ID:\n");
                        System.out.println("enter the ID:");
                        int id = s.nextInt();
                        System.out.println();
                        Console byId = ConsoleService.findById(id);
                        if (byId != null) {
                            ConsoleService.print(byId);
                        }
                        break;
                    case 15:
                        System.out.println("\nfind consoles by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByModel(null, model));
                        break;
                    case 16:
                        System.out.println("\nfind consoles by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByYear(null, year));
                        break;
                    case 17:
                        System.out.println("\nfind consoles by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByAddingDate(null, date));
                        break;
                    case 18:
                        System.out.println("\nfind consoles by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 19:
                        System.out.println("\nfind consoles by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String consoleModel = s.nextLine();
                        System.out.println("enter year:");
                        int consoleYear = s.nextInt();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByYear(consoleModel, consoleYear));
                        System.out.println();
                        break;
                    case 20:
                        System.out.println("\nfind consoles by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String consoleModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String consoleAddingDate = s.nextLine();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByDate(consoleModel1, consoleAddingDate));
                        System.out.println();
                        break;
                    case 21:
                        System.out.println("\nfind consoles by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String consolesModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        ConsoleService.printAll(ConsoleService.findModelByPrice(consolesModel2, from1, to1));
                        System.out.println();
                        break;
                    case 22:
                        System.out.println("add to cart by ID:");
                        System.out.println("input ID:");
                        int id1 = s.nextInt();
                        System.out.println("input amount:");
                        int amount = s.nextInt();
                        Console item = ConsoleService.findById(id1);
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
                        System.out.println("Exit console menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        userConsoleMenu(user);
                }
            }
        }
}
