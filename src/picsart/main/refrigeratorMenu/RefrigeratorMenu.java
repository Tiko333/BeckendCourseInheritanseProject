package picsart.main.refrigeratorMenu;

import picsart.main.MainUtils;
import picsart.model.refrigerator.Refrigerator;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.RefrigeratorService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class RefrigeratorMenu {
        public static UserModel refrigeratorMenu(UserModel user) throws IOException {
            if (user.getRole() == Role.ADMIN) {
                adminRefrigeratorMenu(user);
            }
            if (user.getRole() == Role.USER) {
                userRefrigeratorMenu(user);
            }
            return user;
        }

        private static void adminRefrigeratorMenu(UserModel user) throws IOException {
            System.out.println("\nRefrigerator admin menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nadd refrigerator:\n");
                        RefrigeratorService.create();
                        break;
                    case 2:
                        System.out.println("\ncreate refrigerators:\n");
                        System.out.println("how much refrigerators to create:");
                        int size = s.nextInt();
                        System.out.println();
                        RefrigeratorService.multipleCreate(size);
                        break;
                    case 3:
                        System.out.println("\nupdate refrigerator by id:\n");
                        System.out.println("enter ID");
                        int id = s.nextInt();
                        System.out.println();
                        RefrigeratorService.updateById(id);
                        break;
                    case 4:
                        System.out.println("\ndelete refrigerator by id :\n");
                        System.out.println("enter ID");
                        int id1 = s.nextInt();
                        System.out.println();
                        RefrigeratorService.deleteById(id1);
                        break;
                    case 5:
                        System.out.println("\ndelete all refrigerators:\n");
                        RefrigeratorService.deleteAll();
                        break;
                    case 6:
                        System.out.println("\nnewer refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.newer());
                        break;
                    case 7:
                        System.out.println("\nolder refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.older());
                        break;
                    case 8:
                        System.out.println("\nbigger cost refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.biggerCost());
                        break;
                    case 9:
                        System.out.println("\nsmaller cost refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.smallerCost());
                        break;
                    case 10:
                        System.out.println("\nnewer added:\n");
                        RefrigeratorService.print(RefrigeratorService.newerAdded());
                        break;
                    case 11:
                        System.out.println("\nolder added:\n");
                        RefrigeratorService.print(RefrigeratorService.olderAdded());
                        break;
                    case 12:
                        System.out.println("\nascending order by price:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByPrice());
                        break;
                    case 13:
                        System.out.println("\ndescending order by price:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByPrice());
                        break;
                    case 14:
                        System.out.println("\nascending order by year:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByYear());
                        break;
                    case 15:
                        System.out.println("\ndescending order by year:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByYear());
                        break;
                    case 16:
                        System.out.println("\nascending order by adding date:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByAddingDate());
                        break;
                    case 17:
                        System.out.println("\ndescending order by adding date:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByAddingDate());
                        break;
                    case 18:
                        System.out.println("\nprint all refrigerators:\n");
                        RefrigeratorService.printAll(null);
                        break;
                    case 19:
                        System.out.println("\nfind refrigerator by ID:\n");
                        System.out.println("enter the ID:");
                        int id2 = s.nextInt();
                        System.out.println();
                        Refrigerator byId = RefrigeratorService.findById(id2);
                        if (byId != null) {
                            RefrigeratorService.print(byId);
                        }
                        break;
                    case 20:
                        System.out.println("\nfind refrigerators by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByModel(null, model));
                        break;
                    case 21:
                        System.out.println("\nfind refrigerators by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByYear(null, year));
                        break;
                    case 22:
                        System.out.println("\nfind refrigerators by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByAddingDate(null, date));
                        break;
                    case 23:
                        System.out.println("\nfind refrigerators by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 24:
                        System.out.println("\nfind refrigerators by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String refrigeratorModel = s.nextLine();
                        System.out.println("enter year:");
                        int refrigeratorYear = s.nextInt();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByYear(refrigeratorModel, refrigeratorYear));
                        System.out.println();
                        break;
                    case 25:
                        System.out.println("\nfind refrigerators by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String refrigeratorModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String refrigeratorAddingDate = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByDate(refrigeratorModel1, refrigeratorAddingDate));
                        System.out.println();
                        break;
                    case 26:
                        System.out.println("\nfind refrigerators by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String refrigeratorModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByPrice(refrigeratorModel2, from1, to1));
                        System.out.println();
                        break;
                    case 27:
                        isMenuActive = false;
                        System.out.println("Exit refrigerator menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        adminRefrigeratorMenu(user);
                }
            }

        }

        private static void userRefrigeratorMenu(UserModel user) throws IOException {
            System.out.println("\nRefrigerator user menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nnewer refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.newer());
                        break;
                    case 2:
                        System.out.println("\nolder console:\n");
                        RefrigeratorService.print(RefrigeratorService.older());
                        break;
                    case 3:
                        System.out.println("\nbigger cost refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.biggerCost());
                        break;
                    case 4:
                        System.out.println("\nsmaller cost refrigerator:\n");
                        RefrigeratorService.print(RefrigeratorService.smallerCost());
                        break;
                    case 5:
                        System.out.println("\nnewer added:\n");
                        RefrigeratorService.print(RefrigeratorService.newerAdded());
                        break;
                    case 6:
                        System.out.println("\nolder added:\n");
                        RefrigeratorService.print(RefrigeratorService.olderAdded());
                        break;
                    case 7:
                        System.out.println("\nascending order by price:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByPrice());
                        break;
                    case 8:
                        System.out.println("\ndescending order by price:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByPrice());
                        break;
                    case 9:
                        System.out.println("\nascending order by year:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByYear());
                        break;
                    case 10:
                        System.out.println("\ndescending order by year:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByYear());
                        break;
                    case 11:
                        System.out.println("\nascending order by adding date:\n");
                        RefrigeratorService.printAll(RefrigeratorService.ascendingOrderByAddingDate());
                        break;
                    case 12:
                        System.out.println("\ndescending order by adding date:\n");
                        RefrigeratorService.printAll(RefrigeratorService.descendingOrderByAddingDate());
                        break;
                    case 13:
                        System.out.println("\nprint all refrigerators:\n");
                        RefrigeratorService.printAll(null);
                        break;
                    case 14:
                        System.out.println("\nfind refrigerator by ID:\n");
                        System.out.println("enter the ID:");
                        int id = s.nextInt();
                        System.out.println();
                        Refrigerator byId = RefrigeratorService.findById(id);
                        if (byId != null) {
                            RefrigeratorService.print(byId);
                        }
                        break;
                    case 15:
                        System.out.println("\nfind refrigerators by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByModel(null, model));
                        break;
                    case 16:
                        System.out.println("\nfind refrigerators by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByYear(null, year));
                        break;
                    case 17:
                        System.out.println("\nfind refrigerators by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByAddingDate(null, date));
                        break;
                    case 18:
                        System.out.println("\nfind refrigerators by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 19:
                        System.out.println("\nfind refrigerators by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String refrigeratorModel = s.nextLine();
                        System.out.println("enter year:");
                        int refrigeratorYear = s.nextInt();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByYear(refrigeratorModel, refrigeratorYear));
                        System.out.println();
                        break;
                    case 20:
                        System.out.println("\nfind refrigerators by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String refrigeratorModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String refrigeratorAddingDate = s.nextLine();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByDate(refrigeratorModel1, refrigeratorAddingDate));
                        System.out.println();
                        break;
                    case 21:
                        System.out.println("\nfind refrigerators by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String refrigeratorModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        RefrigeratorService.printAll(RefrigeratorService.findModelByPrice(refrigeratorModel2, from1, to1));
                        System.out.println();
                        break;
                    case 22:
                        System.out.println("add to cart by ID:");
                        System.out.println("input ID:");
                        int id1 = s.nextInt();
                        System.out.println("input amount:");
                        int amount = s.nextInt();
                        Refrigerator item = RefrigeratorService.findById(id1);
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
                        System.out.println("Exit refrigerator menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        userRefrigeratorMenu(user);
                }
            }
        }
}
