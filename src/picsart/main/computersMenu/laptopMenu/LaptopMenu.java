package picsart.main.computersMenu.laptopMenu;

import picsart.main.MainUtils;
import picsart.model.computer.Laptop;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.LaptopService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class LaptopMenu {
        public static UserModel laptopMenu(UserModel user) throws IOException {
            if (user.getRole() == Role.ADMIN) {
                adminLaptopMenu(user);
            }
            if (user.getRole() == Role.USER) {
                userLaptopMenu(user);
            }
            return user;
        }

        private static void adminLaptopMenu(UserModel user) throws IOException {
            System.out.println("\nLaptop admin menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nadd laptop:\n");
                        LaptopService.create();
                        break;
                    case 2:
                        System.out.println("\ncreate laptops:\n");
                        System.out.println("how much laptops to create:");
                        int size = s.nextInt();
                        System.out.println();
                        LaptopService.multipleCreate(size);
                        break;
                    case 3:
                        System.out.println("\nupdate laptop by id:\n");
                        System.out.println("enter ID");
                        int id = s.nextInt();
                        System.out.println();
                        LaptopService.updateById(id);
                        break;
                    case 4:
                        System.out.println("\ndelete laptops by id :\n");
                        System.out.println("enter ID");
                        int id1 = s.nextInt();
                        System.out.println();
                        LaptopService.deleteById(id1);
                        break;
                    case 5:
                        System.out.println("\ndelete all laptops:\n");
                        LaptopService.deleteAll();
                        break;
                    case 6:
                        System.out.println("\nnewer laptop:\n");
                        LaptopService.print(LaptopService.newer());
                        break;
                    case 7:
                        System.out.println("\nolder laptop:\n");
                        LaptopService.print(LaptopService.older());
                        break;
                    case 8:
                        System.out.println("\nbigger cost laptop:\n");
                        LaptopService.print(LaptopService.biggerCost());
                        break;
                    case 9:
                        System.out.println("\nsmaller cost laptop:\n");
                        LaptopService.print(LaptopService.smallerCost());
                        break;
                    case 10:
                        System.out.println("\nnewer added:\n");
                        LaptopService.print(LaptopService.newerAdded());
                        break;
                    case 11:
                        System.out.println("\nolder added:\n");
                        LaptopService.print(LaptopService.olderAdded());
                        break;
                    case 12:
                        System.out.println("\nascending order by price:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByPrice());
                        break;
                    case 13:
                        System.out.println("\ndescending order by price:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByPrice());
                        break;
                    case 14:
                        System.out.println("\nascending order by year:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByYear());
                        break;
                    case 15:
                        System.out.println("\ndescending order by year:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByYear());
                        break;
                    case 16:
                        System.out.println("\nascending order by adding date:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByAddingDate());
                        break;
                    case 17:
                        System.out.println("\ndescending order by adding date:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByAddingDate());
                        break;
                    case 18:
                        System.out.println("\nprint all laptops:\n");
                        LaptopService.printAll(null);
                        break;
                    case 19:
                        System.out.println("\nfind laptop by ID:\n");
                        System.out.println("enter the ID:");
                        int id2 = s.nextInt();
                        System.out.println();
                        Laptop byId = LaptopService.findById(id2);
                        if (byId != null) {
                            LaptopService.print(byId);
                        }
                        break;
                    case 20:
                        System.out.println("\nfind laptops by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByModel(null, model));
                        break;
                    case 21:
                        System.out.println("\nfind laptops by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByYear(null, year));
                        break;
                    case 22:
                        System.out.println("\nfind laptops by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByAddingDate(null, date));
                        break;
                    case 23:
                        System.out.println("\nfind laptops by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 24:
                        System.out.println("\nfind laptops by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String laptopModel = s.nextLine();
                        System.out.println("enter year:");
                        int laptopYear = s.nextInt();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByYear(laptopModel, laptopYear));
                        System.out.println();
                        break;
                    case 25:
                        System.out.println("\nfind laptops by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String laptopModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String laptopAddingDate = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByDate(laptopModel1, laptopAddingDate));
                        System.out.println();
                        break;
                    case 26:
                        System.out.println("\nfind laptops by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String laptopModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByPrice(laptopModel2, from1, to1));
                        System.out.println();
                        break;
                    case 27:
                        isMenuActive = false;
                        System.out.println("Exit laptop menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        adminLaptopMenu(user);
                }
            }

        }

        private static void userLaptopMenu(UserModel user) throws IOException {
            System.out.println("\nLaptop user menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nnewer laptop:\n");
                        LaptopService.print(LaptopService.newer());
                        break;
                    case 2:
                        System.out.println("\nolder laptop:\n");
                        LaptopService.print(LaptopService.older());
                        break;
                    case 3:
                        System.out.println("\nbigger cost laptop:\n");
                        LaptopService.print(LaptopService.biggerCost());
                        break;
                    case 4:
                        System.out.println("\nsmaller cost laptop:\n");
                        LaptopService.print(LaptopService.smallerCost());
                        break;
                    case 5:
                        System.out.println("\nnewer added:\n");
                        LaptopService.print(LaptopService.newerAdded());
                        break;
                    case 6:
                        System.out.println("\nolder added:\n");
                        LaptopService.print(LaptopService.olderAdded());
                        break;
                    case 7:
                        System.out.println("\nascending order by price:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByPrice());
                        break;
                    case 8:
                        System.out.println("\ndescending order by price:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByPrice());
                        break;
                    case 9:
                        System.out.println("\nascending order by year:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByYear());
                        break;
                    case 10:
                        System.out.println("\ndescending order by year:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByYear());
                        break;
                    case 11:
                        System.out.println("\nascending order by adding date:\n");
                        LaptopService.printAll(LaptopService.ascendingOrderByAddingDate());
                        break;
                    case 12:
                        System.out.println("\ndescending order by adding date:\n");
                        LaptopService.printAll(LaptopService.descendingOrderByAddingDate());
                        break;
                    case 13:
                        System.out.println("\nprint all laptops:\n");
                        LaptopService.printAll(null);
                        break;
                    case 14:
                        System.out.println("\nfind laptops by ID:\n");
                        System.out.println("enter the ID:");
                        int id = s.nextInt();
                        System.out.println();
                        Laptop byId = LaptopService.findById(id);
                        if (byId != null) {
                            LaptopService.print(byId);
                        }
                        break;
                    case 15:
                        System.out.println("\nfind laptops by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByModel(null, model));
                        break;
                    case 16:
                        System.out.println("\nfind laptops by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByYear(null, year));
                        break;
                    case 17:
                        System.out.println("\nfind laptops by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByAddingDate(null, date));
                        break;
                    case 18:
                        System.out.println("\nfind laptops by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 19:
                        System.out.println("\nfind laptops by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String laptopModel = s.nextLine();
                        System.out.println("enter year:");
                        int laptopYear = s.nextInt();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByYear(laptopModel, laptopYear));
                        System.out.println();
                        break;
                    case 20:
                        System.out.println("\nfind laptops by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String laptopModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String laptopAddingDate = s.nextLine();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByDate(laptopModel1, laptopAddingDate));
                        System.out.println();
                        break;
                    case 21:
                        System.out.println("\nfind laptops by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String laptopModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        LaptopService.printAll(LaptopService.findModelByPrice(laptopModel2, from1, to1));
                        System.out.println();
                        break;
                    case 22:
                        System.out.println("add to cart by ID:");
                        System.out.println("input ID:");
                        int id1 = s.nextInt();
                        System.out.println("input amount:");
                        int amount = s.nextInt();
                        Laptop item = LaptopService.findById(id1);
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
                        System.out.println("Exit laptop menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        userLaptopMenu(user);
                }
            }
        }
}
