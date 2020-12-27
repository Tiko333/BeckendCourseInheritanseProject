package picsart.main.tvMenu;

import picsart.main.MainUtils;
import picsart.model.tv.Tv;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.TVService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class TVMenu {
        public static UserModel tvMenu(UserModel user) throws IOException {
            if (user.getRole() == Role.ADMIN) {
                adminTvMenu(user);
            }
            if (user.getRole() == Role.USER) {
                userTvMenu(user);
            }
            return user;
        }

        private static void adminTvMenu(UserModel user) throws IOException {
            System.out.println("\nTv admin menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nadd tv:\n");
                        TVService.create();
                        break;
                    case 2:
                        System.out.println("\ncreate tvs:\n");
                        System.out.println("how much tvs to create:");
                        int size = s.nextInt();
                        System.out.println();
                        TVService.multipleCreate(size);
                        break;
                    case 3:
                        System.out.println("\nupdate tv by id:\n");
                        System.out.println("enter ID");
                        int id = s.nextInt();
                        System.out.println();
                        TVService.updateById(id);
                        break;
                    case 4:
                        System.out.println("\ndelete tvs by id :\n");
                        System.out.println("enter ID");
                        int id1 = s.nextInt();
                        System.out.println();
                        TVService.deleteById(id1);
                        break;
                    case 5:
                        System.out.println("\ndelete all tvs:\n");
                        TVService.deleteAll();
                        break;
                    case 6:
                        System.out.println("\nnewer tv:\n");
                        TVService.print(TVService.newer());
                        break;
                    case 7:
                        System.out.println("\nolder tv:\n");
                        TVService.print(TVService.older());
                        break;
                    case 8:
                        System.out.println("\nbigger cost tv:\n");
                        TVService.print(TVService.biggerCost());
                        break;
                    case 9:
                        System.out.println("\nsmaller cost tv:\n");
                        TVService.print(TVService.smallerCost());
                        break;
                    case 10:
                        System.out.println("\nnewer added:\n");
                        TVService.print(TVService.newerAdded());
                        break;
                    case 11:
                        System.out.println("\nolder added:\n");
                        TVService.print(TVService.olderAdded());
                        break;
                    case 12:
                        System.out.println("\nascending order by price:\n");
                        TVService.printAll(TVService.ascendingOrderByPrice());
                        break;
                    case 13:
                        System.out.println("\ndescending order by price:\n");
                        TVService.printAll(TVService.descendingOrderByPrice());
                        break;
                    case 14:
                        System.out.println("\nascending order by year:\n");
                        TVService.printAll(TVService.ascendingOrderByYear());
                        break;
                    case 15:
                        System.out.println("\ndescending order by year:\n");
                        TVService.printAll(TVService.descendingOrderByYear());
                        break;
                    case 16:
                        System.out.println("\nascending order by adding date:\n");
                        TVService.printAll(TVService.ascendingOrderByAddingDate());
                        break;
                    case 17:
                        System.out.println("\ndescending order by adding date:\n");
                        TVService.printAll(TVService.descendingOrderByAddingDate());
                        break;
                    case 18:
                        System.out.println("\nprint all tvs:\n");
                        TVService.printAll(null);
                        break;
                    case 19:
                        System.out.println("\nfind tv by ID:\n");
                        System.out.println("enter the ID:");
                        int id2 = s.nextInt();
                        System.out.println();
                        Tv byId = TVService.findById(id2);
                        if (byId != null) {
                            TVService.print(byId);
                        }
                        break;
                    case 20:
                        System.out.println("\nfind tvs by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findByModel(null, model));
                        break;
                    case 21:
                        System.out.println("\nfind tvs by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        TVService.printAll(TVService.findByYear(null, year));
                        break;
                    case 22:
                        System.out.println("\nfind tvs by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findByAddingDate(null, date));
                        break;
                    case 23:
                        System.out.println("\nfind tvs by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        TVService.printAll(TVService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 24:
                        System.out.println("\nfind tvs by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String tvModel = s.nextLine();
                        System.out.println("enter year:");
                        int tvYear = s.nextInt();
                        System.out.println();
                        TVService.printAll(TVService.findModelByYear(tvModel, tvYear));
                        System.out.println();
                        break;
                    case 25:
                        System.out.println("\nfind tvs by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String tvModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String tvAddingDate = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findModelByDate(tvModel1, tvAddingDate));
                        System.out.println();
                        break;
                    case 26:
                        System.out.println("\nfind tvs by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String tvModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        TVService.printAll(TVService.findModelByPrice(tvModel2, from1, to1));
                        System.out.println();
                        break;
                    case 27:
                        isMenuActive = false;
                        System.out.println("Exit tv menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        adminTvMenu(user);
                }
            }

        }

        private static void userTvMenu(UserModel user) throws IOException {
            System.out.println("\nTv user menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nnewer tv:\n");
                        TVService.print(TVService.newer());
                        break;
                    case 2:
                        System.out.println("\nolder tv:\n");
                        TVService.print(TVService.older());
                        break;
                    case 3:
                        System.out.println("\nbigger cost tv:\n");
                        TVService.print(TVService.biggerCost());
                        break;
                    case 4:
                        System.out.println("\nsmaller cost tv:\n");
                        TVService.print(TVService.smallerCost());
                        break;
                    case 5:
                        System.out.println("\nnewer added:\n");
                        TVService.print(TVService.newerAdded());
                        break;
                    case 6:
                        System.out.println("\nolder added:\n");
                        TVService.print(TVService.olderAdded());
                        break;
                    case 7:
                        System.out.println("\nascending order by price:\n");
                        TVService.printAll(TVService.ascendingOrderByPrice());
                        break;
                    case 8:
                        System.out.println("\ndescending order by price:\n");
                        TVService.printAll(TVService.descendingOrderByPrice());
                        break;
                    case 9:
                        System.out.println("\nascending order by year:\n");
                        TVService.printAll(TVService.ascendingOrderByYear());
                        break;
                    case 10:
                        System.out.println("\ndescending order by year:\n");
                        TVService.printAll(TVService.descendingOrderByYear());
                        break;
                    case 11:
                        System.out.println("\nascending order by adding date:\n");
                        TVService.printAll(TVService.ascendingOrderByAddingDate());
                        break;
                    case 12:
                        System.out.println("\ndescending order by adding date:\n");
                        TVService.printAll(TVService.descendingOrderByAddingDate());
                        break;
                    case 13:
                        System.out.println("\nprint all tvs:\n");
                        TVService.printAll(null);
                        break;
                    case 14:
                        System.out.println("\nfind tv by ID:\n");
                        System.out.println("enter the ID:");
                        int id = s.nextInt();
                        System.out.println();
                        Tv byId = TVService.findById(id);
                        if (byId != null) {
                            TVService.print(byId);
                        }
                        break;
                    case 15:
                        System.out.println("\nfind tvs by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findByModel(null, model));
                        break;
                    case 16:
                        System.out.println("\nfind tvs by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        TVService.printAll(TVService.findByYear(null, year));
                        break;
                    case 17:
                        System.out.println("\nfind tvs by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findByAddingDate(null, date));
                        break;
                    case 18:
                        System.out.println("\nfind tvs by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        TVService.printAll(TVService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 19:
                        System.out.println("\nfind tvs by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String tvModel = s.nextLine();
                        System.out.println("enter year:");
                        int tvYear = s.nextInt();
                        System.out.println();
                        TVService.printAll(TVService.findModelByYear(tvModel, tvYear));
                        System.out.println();
                        break;
                    case 20:
                        System.out.println("\nfind tvs by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String tvModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String tvAddingDate = s.nextLine();
                        System.out.println();
                        TVService.printAll(TVService.findModelByDate(tvModel1, tvAddingDate));
                        System.out.println();
                        break;
                    case 21:
                        System.out.println("\nfind tvs by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String tvModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        TVService.printAll(TVService.findModelByPrice(tvModel2, from1, to1));
                        System.out.println();
                        break;
                    case 22:
                        System.out.println("add to cart by ID:");
                        System.out.println("input ID:");
                        int id1 = s.nextInt();
                        System.out.println("input amount:");
                        int amount = s.nextInt();
                        Tv item = TVService.findById(id1);
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
                        System.out.println("Exit tv menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        userTvMenu(user);
                }
            }
        }

}
