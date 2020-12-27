package picsart.main.computersMenu.computerMenu;

import picsart.main.MainUtils;
import picsart.model.computer.Computer;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.ComputerService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class ComputerMenu {
        public static UserModel computerMenu(UserModel user) throws IOException {
            if (user.getRole() == Role.ADMIN) {
                adminComputerMenu(user);
            }
            if (user.getRole() == Role.USER) {
                userComputerMenu(user);
            }
            return user;
        }

        private static void adminComputerMenu(UserModel user) throws IOException {
            System.out.println("\nComputer admin menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nadd computer:\n");
                        ComputerService.create();
                        break;
                    case 2:
                        System.out.println("\ncreate computers:\n");
                        System.out.println("how much computers to create:");
                        int size = s.nextInt();
                        System.out.println();
                        ComputerService.multipleCreate(size);
                        break;
                    case 3:
                        System.out.println("\nupdate computer by id:\n");
                        System.out.println("enter ID");
                        int id = s.nextInt();
                        System.out.println();
                        ComputerService.updateById(id);
                        break;
                    case 4:
                        System.out.println("\ndelete computers by id :\n");
                        System.out.println("enter ID");
                        int id1 = s.nextInt();
                        System.out.println();
                        ComputerService.deleteById(id1);
                        break;
                    case 5:
                        System.out.println("\ndelete all computers:\n");
                        ComputerService.deleteAll();
                        break;
                    case 6:
                        System.out.println("\nnewer computer:\n");
                        ComputerService.print(ComputerService.newer());
                        break;
                    case 7:
                        System.out.println("\nolder computer:\n");
                        ComputerService.print(ComputerService.older());
                        break;
                    case 8:
                        System.out.println("\nbigger cost computer:\n");
                        ComputerService.print(ComputerService.biggerCost());
                        break;
                    case 9:
                        System.out.println("\nsmaller cost computer:\n");
                        ComputerService.print(ComputerService.smallerCost());
                        break;
                    case 10:
                        System.out.println("\nnewer added:\n");
                        ComputerService.print(ComputerService.newerAdded());
                        break;
                    case 11:
                        System.out.println("\nolder added:\n");
                        ComputerService.print(ComputerService.olderAdded());
                        break;
                    case 12:
                        System.out.println("\nascending order by price:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByPrice());
                        break;
                    case 13:
                        System.out.println("\ndescending order by price:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByPrice());
                        break;
                    case 14:
                        System.out.println("\nascending order by year:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByYear());
                        break;
                    case 15:
                        System.out.println("\ndescending order by year:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByYear());
                        break;
                    case 16:
                        System.out.println("\nascending order by adding date:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByAddingDate());
                        break;
                    case 17:
                        System.out.println("\ndescending order by adding date:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByAddingDate());
                        break;
                    case 18:
                        System.out.println("\nprint all computers:\n");
                        ComputerService.printAll(null);
                        break;
                    case 19:
                        System.out.println("\nfind computer by ID:\n");
                        System.out.println("enter the ID:");
                        int id2 = s.nextInt();
                        System.out.println();
                        Computer byId = ComputerService.findById(id2);
                        if (byId != null) {
                            ComputerService.print(byId);
                        }
                        break;
                    case 20:
                        System.out.println("\nfind computers by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByModel(null, model));
                        break;
                    case 21:
                        System.out.println("\nfind computers by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByYear(null, year));
                        break;
                    case 22:
                        System.out.println("\nfind computers by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByAddingDate(null, date));
                        break;
                    case 23:
                        System.out.println("\nfind computers by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 24:
                        System.out.println("\nfind computers by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String computerModel = s.nextLine();
                        System.out.println("enter year:");
                        int computerYear = s.nextInt();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByYear(computerModel, computerYear));
                        System.out.println();
                        break;
                    case 25:
                        System.out.println("\nfind computers by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String computerModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String computerAddingDate = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByDate(computerModel1, computerAddingDate));
                        System.out.println();
                        break;
                    case 26:
                        System.out.println("\nfind computers by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String computerModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByPrice(computerModel2, from1, to1));
                        System.out.println();
                        break;
                    case 27:
                        isMenuActive = false;
                        System.out.println("Exit computer menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        adminComputerMenu(user);
                }
            }

        }

        private static void userComputerMenu(UserModel user) throws IOException {
            System.out.println("\nComputer user menu:          user: " + user.getFullName() + "\n");
            boolean isMenuActive = true;
            while (isMenuActive) {
                Scanner s = new Scanner(System.in);
                MainUtils.printOptions(user);
                System.out.println("Enter command number:");
                int i = s.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("\nnewer computer:\n");
                        ComputerService.print(ComputerService.newer());
                        break;
                    case 2:
                        System.out.println("\nolder computer:\n");
                        ComputerService.print(ComputerService.older());
                        break;
                    case 3:
                        System.out.println("\nbigger cost computer:\n");
                        ComputerService.print(ComputerService.biggerCost());
                        break;
                    case 4:
                        System.out.println("\nsmaller cost computer:\n");
                        ComputerService.print(ComputerService.smallerCost());
                        break;
                    case 5:
                        System.out.println("\nnewer added:\n");
                        ComputerService.print(ComputerService.newerAdded());
                        break;
                    case 6:
                        System.out.println("\nolder added:\n");
                        ComputerService.print(ComputerService.olderAdded());
                        break;
                    case 7:
                        System.out.println("\nascending order by price:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByPrice());
                        break;
                    case 8:
                        System.out.println("\ndescending order by price:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByPrice());
                        break;
                    case 9:
                        System.out.println("\nascending order by year:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByYear());
                        break;
                    case 10:
                        System.out.println("\ndescending order by year:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByYear());
                        break;
                    case 11:
                        System.out.println("\nascending order by adding date:\n");
                        ComputerService.printAll(ComputerService.ascendingOrderByAddingDate());
                        break;
                    case 12:
                        System.out.println("\ndescending order by adding date:\n");
                        ComputerService.printAll(ComputerService.descendingOrderByAddingDate());
                        break;
                    case 13:
                        System.out.println("\nprint all computers:\n");
                        ComputerService.printAll(null);
                        break;
                    case 14:
                        System.out.println("\nfind computer by ID:\n");
                        System.out.println("enter the ID:");
                        int id = s.nextInt();
                        System.out.println();
                        Computer byId = ComputerService.findById(id);
                        if (byId != null) {
                            ComputerService.print(byId);
                        }
                        break;
                    case 15:
                        System.out.println("\nfind computers by model:\n");
                        System.out.println("enter the model");
                        s.nextLine();
                        String model = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByModel(null, model));
                        break;
                    case 16:
                        System.out.println("\nfind computers by year:\n");
                        System.out.println("enter the year");
                        int year = s.nextInt();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByYear(null, year));
                        break;
                    case 17:
                        System.out.println("\nfind computers by adding date:\n");
                        System.out.println("enter the date dd/MM/yyyy:");
                        s.nextLine();
                        String date = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByAddingDate(null, date));
                        break;
                    case 18:
                        System.out.println("\nfind computers by price:\n");
                        System.out.println("enter from price:");
                        double from = s.nextDouble();
                        System.out.println("enter to price:");
                        double to = s.nextDouble();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findByPrice(null, from, to));
                        System.out.println();
                        break;
                    case 19:
                        System.out.println("\nfind computers by model and year:\n");
                        System.out.println("enter model:");
                        s.nextLine();
                        String computerModel = s.nextLine();
                        System.out.println("enter year:");
                        int computerYear = s.nextInt();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByYear(computerModel, computerYear));
                        System.out.println();
                        break;
                    case 20:
                        System.out.println("\nfind computers by model and adding date:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String computerModel1 = s.nextLine();
                        System.out.println("Enter adding date:");
                        String computerAddingDate = s.nextLine();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByDate(computerModel1, computerAddingDate));
                        System.out.println();
                        break;
                    case 21:
                        System.out.println("\nfind computers by model and price range:\n");
                        System.out.println("Enter model:");
                        s.nextLine();
                        String computerModel2 = s.nextLine();
                        System.out.println("Enter from price:");
                        double from1 = s.nextDouble();
                        System.out.println("Enter to price:");
                        double to1 = s.nextDouble();
                        System.out.println();
                        ComputerService.printAll(ComputerService.findModelByPrice(computerModel2, from1, to1));
                        System.out.println();
                        break;
                    case 22:
                        System.out.println("add to cart by ID:");
                        System.out.println("input ID:");
                        int id1 = s.nextInt();
                        System.out.println("input amount:");
                        int amount = s.nextInt();
                        Computer item = ComputerService.findById(id1);
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
                        System.out.println("Exit computer menu:\n");
                        break;
                    default:
                        System.out.println("\nChoose form available options");
                        userComputerMenu(user);
                }
            }
        }
}
