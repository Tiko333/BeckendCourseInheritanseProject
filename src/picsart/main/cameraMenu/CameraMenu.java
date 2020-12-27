package picsart.main.cameraMenu;

import picsart.main.MainUtils;
import picsart.model.camera.Camera;
import picsart.registration.Role;
import picsart.registration.UserModel;
import picsart.service.CameraService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class CameraMenu {
    public static UserModel cameraMenu(UserModel user) throws IOException {
        if (user.getRole() == Role.ADMIN) {
            adminCameraMenu(user);
        }
        if (user.getRole() == Role.USER) {
            userCameraMenu(user);
        }
        return user;
    }

    private static void adminCameraMenu(UserModel user) throws IOException {
        System.out.println("\nCamera admin menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nadd camera:\n");
                    CameraService.create();
                    break;
                case 2:
                    System.out.println("\ncreate cameras:\n");
                    System.out.println("how much cameras to create:");
                    int size = s.nextInt();
                    System.out.println();
                    CameraService.multipleCreate(size);
                    break;
                case 3:
                    System.out.println("\nupdate camera by id:\n");
                    System.out.println("enter ID");
                    int id = s.nextInt();
                    System.out.println();
                    CameraService.updateById(id);
                    break;
                case 4:
                    System.out.println("\ndelete cameras by id :\n");
                    System.out.println("enter ID");
                    int id1 = s.nextInt();
                    System.out.println();
                    CameraService.deleteById(id1);
                    break;
                case 5:
                    System.out.println("\ndelete all cameras:\n");
                    CameraService.deleteAll();
                    break;
                case 6:
                    System.out.println("\nnewer camera:\n");
                    CameraService.print(CameraService.newer());
                    break;
                case 7:
                    System.out.println("\nolder camera:\n");
                    CameraService.print(CameraService.older());
                    break;
                case 8:
                    System.out.println("\nbigger cost camera:\n");
                    CameraService.print(CameraService.biggerCost());
                    break;
                case 9:
                    System.out.println("\nsmaller cost camera:\n");
                    CameraService.print(CameraService.smallerCost());
                    break;
                case 10:
                    System.out.println("\nnewer added:\n");
                    CameraService.print(CameraService.newerAdded());
                    break;
                case 11:
                    System.out.println("\nolder added:\n");
                    CameraService.print(CameraService.olderAdded());
                    break;
                case 12:
                    System.out.println("\nascending order by price:\n");
                    CameraService.printAll(CameraService.ascendingOrderByPrice());
                    break;
                case 13:
                    System.out.println("\ndescending order by price:\n");
                    CameraService.printAll(CameraService.descendingOrderByPrice());
                    break;
                case 14:
                    System.out.println("\nascending order by year:\n");
                    CameraService.printAll(CameraService.ascendingOrderByYear());
                    break;
                case 15:
                    System.out.println("\ndescending order by year:\n");
                    CameraService.printAll(CameraService.descendingOrderByYear());
                    break;
                case 16:
                    System.out.println("\nascending order by adding date:\n");
                    CameraService.printAll(CameraService.ascendingOrderByAddingDate());
                    break;
                case 17:
                    System.out.println("\ndescending order by adding date:\n");
                    CameraService.printAll(CameraService.descendingOrderByAddingDate());
                    break;
                case 18:
                    System.out.println("\nprint all cameras:\n");
                    CameraService.printAll(null);
                    break;
                case 19:
                    System.out.println("\nfind camera by ID:\n");
                    System.out.println("enter the ID:");
                    int id2 = s.nextInt();
                    System.out.println();
                    Camera byId = CameraService.findById(id2);
                    if (byId != null) {
                        CameraService.print(byId);
                    }
                    break;
                case 20:
                    System.out.println("\nfind cameras by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findByModel(null, model));
                    break;
                case 21:
                    System.out.println("\nfind cameras by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    CameraService.printAll(CameraService.findByYear(null, year));
                    break;
                case 22:
                    System.out.println("\nfind cameras by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findByAddingDate(null, date));
                    break;
                case 23:
                    System.out.println("\nfind cameras by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    CameraService.printAll(CameraService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 24:
                    System.out.println("\nfind cameras by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String cameraModel = s.nextLine();
                    System.out.println("enter year:");
                    int cameraYear = s.nextInt();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByYear(cameraModel, cameraYear));
                    System.out.println();
                    break;
                case 25:
                    System.out.println("\nfind cameras by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String cameraModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String cameraAddingDate = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByDate(cameraModel1, cameraAddingDate));
                    System.out.println();
                    break;
                case 26:
                    System.out.println("\nfind cameras by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String cameraModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByPrice(cameraModel2, from1, to1));
                    System.out.println();
                    break;
                case 27:
                    isMenuActive = false;
                    System.out.println("Exit camera menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    adminCameraMenu(user);
            }
        }

    }

    private static void userCameraMenu(UserModel user) throws IOException {
        System.out.println("\nCamera user menu:          user: " + user.getFullName() + "\n");
        boolean isMenuActive = true;
        while (isMenuActive) {
            Scanner s = new Scanner(System.in);
            MainUtils.printOptions(user);
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\nnewer camera:\n");
                    CameraService.print(CameraService.newer());
                    break;
                case 2:
                    System.out.println("\nolder camera:\n");
                    CameraService.print(CameraService.older());
                    break;
                case 3:
                    System.out.println("\nbigger cost camera:\n");
                    CameraService.print(CameraService.biggerCost());
                    break;
                case 4:
                    System.out.println("\nsmaller cost camera:\n");
                    CameraService.print(CameraService.smallerCost());
                    break;
                case 5:
                    System.out.println("\nnewer added:\n");
                    CameraService.print(CameraService.newerAdded());
                    break;
                case 6:
                    System.out.println("\nolder added:\n");
                    CameraService.print(CameraService.olderAdded());
                    break;
                case 7:
                    System.out.println("\nascending order by price:\n");
                    CameraService.printAll(CameraService.ascendingOrderByPrice());
                    break;
                case 8:
                    System.out.println("\ndescending order by price:\n");
                    CameraService.printAll(CameraService.descendingOrderByPrice());
                    break;
                case 9:
                    System.out.println("\nascending order by year:\n");
                    CameraService.printAll(CameraService.ascendingOrderByYear());
                    break;
                case 10:
                    System.out.println("\ndescending order by year:\n");
                    CameraService.printAll(CameraService.descendingOrderByYear());
                    break;
                case 11:
                    System.out.println("\nascending order by adding date:\n");
                    CameraService.printAll(CameraService.ascendingOrderByAddingDate());
                    break;
                case 12:
                    System.out.println("\ndescending order by adding date:\n");
                    CameraService.printAll(CameraService.descendingOrderByAddingDate());
                    break;
                case 13:
                    System.out.println("\nprint all cameras:\n");
                    CameraService.printAll(null);
                    break;
                case 14:
                    System.out.println("\nfind camera by ID:\n");
                    System.out.println("enter the ID:");
                    int id = s.nextInt();
                    System.out.println();
                    Camera byId = CameraService.findById(id);
                    if (byId != null) {
                        CameraService.print(byId);
                    }
                    break;
                case 15:
                    System.out.println("\nfind cameras by model:\n");
                    System.out.println("enter the model");
                    s.nextLine();
                    String model = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findByModel(null, model));
                    break;
                case 16:
                    System.out.println("\nfind cameras by year:\n");
                    System.out.println("enter the year");
                    int year = s.nextInt();
                    System.out.println();
                    CameraService.printAll(CameraService.findByYear(null, year));
                    break;
                case 17:
                    System.out.println("\nfind cameras by adding date:\n");
                    System.out.println("enter the date dd/MM/yyyy:");
                    s.nextLine();
                    String date = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findByAddingDate(null, date));
                    break;
                case 18:
                    System.out.println("\nfind cameras by price:\n");
                    System.out.println("enter from price:");
                    double from = s.nextDouble();
                    System.out.println("enter to price:");
                    double to = s.nextDouble();
                    System.out.println();
                    CameraService.printAll(CameraService.findByPrice(null, from, to));
                    System.out.println();
                    break;
                case 19:
                    System.out.println("\nfind cameras by model and year:\n");
                    System.out.println("enter model:");
                    s.nextLine();
                    String cameraModel = s.nextLine();
                    System.out.println("enter year:");
                    int cameraYear = s.nextInt();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByYear(cameraModel, cameraYear));
                    System.out.println();
                    break;
                case 20:
                    System.out.println("\nfind cameras by model and adding date:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String cameraModel1 = s.nextLine();
                    System.out.println("Enter adding date:");
                    String cameraAddingDate = s.nextLine();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByDate(cameraModel1, cameraAddingDate));
                    System.out.println();
                    break;
                case 21:
                    System.out.println("\nfind cameras by model and price range:\n");
                    System.out.println("Enter model:");
                    s.nextLine();
                    String cameraModel2 = s.nextLine();
                    System.out.println("Enter from price:");
                    double from1 = s.nextDouble();
                    System.out.println("Enter to price:");
                    double to1 = s.nextDouble();
                    System.out.println();
                    CameraService.printAll(CameraService.findModelByPrice(cameraModel2, from1, to1));
                    System.out.println();
                    break;
                case 22:
                    System.out.println("add to cart by ID:");
                    System.out.println("input ID:");
                    int id1 = s.nextInt();
                    System.out.println("input amount:");
                    int amount = s.nextInt();
                    Camera item = CameraService.findById(id1);
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
                    userCameraMenu(user);
            }
        }
    }
}
