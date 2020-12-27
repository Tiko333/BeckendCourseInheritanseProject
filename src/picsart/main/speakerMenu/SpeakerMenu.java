package picsart.main.speakerMenu;

import picsart.main.MainUtils;
import picsart.model.camera.Camera;
import picsart.model.speaker.Speaker;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CameraService;
import picsart.service.SpeakerService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class SpeakerMenu {
    public static UserModel speakerMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminSpeakerMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userSpeakerMenu(user);
        }
        return user;
    }

    private static void adminSpeakerMenu(UserModel user) throws IOException {
        System.out.println("\nSpeaker admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd speaker:\n");
                    SpeakerService.create();
                    break;
                case 2:
                    System.out.println("\ncreate speakers:\n");
                    System.out.println("how much speakers to create:");
                    int size = s.nextInt();
                    System.out.println();
                    SpeakerService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate speaker by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    SpeakerService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete speaker by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    SpeakerService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all speakers:\n");
                    SpeakerService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer speaker:\n");
                    SpeakerService.print(SpeakerService.newer());
                    break;
                case 7:
                    System.out.println("\nolder speaker:\n");
                    SpeakerService.print(SpeakerService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost speaker:\n");
                    SpeakerService.print(SpeakerService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost speaker:\n");
                    SpeakerService.print(SpeakerService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    SpeakerService.print(SpeakerService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    SpeakerService.print(SpeakerService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all speakers:\n");
                    SpeakerService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind speaker by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    Speaker byId = SpeakerService.findById(id2);
                    if (byId != null) {
                        SpeakerService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind speakers by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind speakers by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind speakers by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind speakers by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind speakers by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String speakerModel = s.nextLine();
                    System.out.println("enter year:");
                    int speakerYear = s.nextInt();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByYear(speakerModel, speakerYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind speakers by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String speakerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String speakerAddingDate = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByDate(speakerModel1, speakerAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind speakers by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String speakerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByPrice(speakerModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit speaker menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminSpeakerMenu(user);
            }
        }

    }

    private static void userSpeakerMenu(UserModel user) throws IOException {
        System.out.println("\nSpeaker user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer speaker:\n");
                    SpeakerService.print(SpeakerService.newer());
                    break;
                case 2:
                    System.out.println("\nolder speaker:\n");
                    SpeakerService.print(SpeakerService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost speaker:\n");
                    SpeakerService.print(SpeakerService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost speaker:\n");
                    SpeakerService.print(SpeakerService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    SpeakerService.print(SpeakerService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    SpeakerService.print(SpeakerService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    SpeakerService.printAll(SpeakerService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    SpeakerService.printAll(SpeakerService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all speakers:\n");
                    SpeakerService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind speaker by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    Speaker byId = SpeakerService.findById(id);
                    if (byId != null) {
                        SpeakerService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind speakers by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind speakers by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind speakers by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind speakers by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind speakers by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String speakerModel = s.nextLine();
                    System.out.println("enter year:");
                    int speakerYear = s.nextInt();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByYear(speakerModel, speakerYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind speakers by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String speakerModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String speakerAddingDate = s.nextLine();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByDate(speakerModel1, speakerAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind speakers by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String speakerModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    SpeakerService.printAll(SpeakerService.findModelByPrice(speakerModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    Speaker item = SpeakerService.findById(id1);
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
                    System.out.println("Exit speaker menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    userSpeakerMenu(user);
            }
        }
    }
}
