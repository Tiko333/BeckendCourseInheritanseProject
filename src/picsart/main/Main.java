package picsart.main;

import picsart.main.cameraMenu.CameraMenu;
import picsart.main.coffeeMakerMenu.CoffeeMakerMenu;
import picsart.main.computersMenu.ComputersMenu;
import picsart.main.conditionerMenu.ConditionerMenu;
import picsart.main.consoleMenu.ConsoleMenu;
import picsart.main.microwaveMenu.MicrowaveMenu;
import picsart.main.phoneMenu.PhoneMenu;
import picsart.main.refrigeratorMenu.RefrigeratorMenu;
import picsart.main.speakerMenu.SpeakerMenu;
import picsart.main.tvMenu.TVMenu;
import picsart.main.vacuumCleanerMenu.VacuumCleanerMenu;
import picsart.main.washingMachineMenu.WashingMachineMenu;
import picsart.registration.UserModel;
import picsart.service.RegistrationService;
import picsart.service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String ENTER_COMMAND_NUMBER = "Enter command number:";

    public static void main(String[] args) throws IOException {
        registration();
    }

    private static void registration() throws IOException {
        boolean isMenuActive = true;
        while (isMenuActive) {
            StringBuilder sb = new StringBuilder();
            sb.append("Electronics shop registration/login\n\n")
                    .append("1. Register\n")
                    .append("2. Login\n")
                    .append("3. Exit\n");
            System.out.println(sb);
            Scanner s = new Scanner(System.in);
            System.out.println(ENTER_COMMAND_NUMBER);
            int commandNumber = s.nextInt();
            switch (commandNumber) {
                case 1:
                    UserModel register = RegistrationService.register();
                    if (register != null) {
                        start(register);
                    } else {
                        System.out.println("\nRegistration fail:\n");
                        registration();
                    }
                    isMenuActive = false;
                    break;
                case 2:
                    UserModel login = RegistrationService.login();
                    if (login != null) {
                        UserService.updateLoginDate(login);
                        start(login);
                    } else {
                        System.out.println("\nLogin fail:\n");
                        registration();
                    }
                    isMenuActive = false;
                    break;
                case 3:
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("\nChoose form available options\n");
                    registration();
            }
        }
    }

    private static void start(UserModel user) throws IOException {
        UserService.updateCartMap();
        boolean isMenuActive = true;
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(System.in);
        sb.append("\nElectronics shop menu        user: ").append(user.getFullName()).append("\n\n")
                .append("1. Cameras\n")
                .append("2. Cellphones\n")
                .append("3. Computers\n")
                .append("4. TVs\n")
                .append("5. Game Consoles\n")
                .append("6. Refrigerators\n")
                .append("7. Conditioners\n")
                .append("8. Washing Machines\n")
                .append("9. Coffee Makers\n")
                .append("10. Vacuum Cleaners\n")
                .append("11. Microwaves\n")
                .append("12. Speakers\n\n")
                .append("13. Cart\n")
                .append("14. Buy cart items\n")
                .append("15. Exit\n");
        while (isMenuActive) {
            System.out.println(sb);
            System.out.println(ENTER_COMMAND_NUMBER);
            int commandNumber = s.nextInt();
            switch (commandNumber) {
                case 1:
                    user = CameraMenu.cameraMenu(user);
                    break;
                case 2:
                    user = PhoneMenu.cellphoneMenu(user);
                    break;
                case 3:
                    user = ComputersMenu.computersMenu(user);
                    break;
                case 4:
                    user = TVMenu.tvMenu(user);
                    break;
                case 5:
                    user = ConsoleMenu.consoleMenu(user);
                    break;
                case 6:
                    user = RefrigeratorMenu.refrigeratorMenu(user);
                    break;
                case 7:
                    user = ConditionerMenu.conditionerMenu(user);
                    break;
                case 8:
                    user = WashingMachineMenu.washingMachineMenu(user);
                    break;
                case 9:
                    user = CoffeeMakerMenu.coffeeMakerMenu(user);
                    break;
                case 10:
                    user = VacuumCleanerMenu.vacuumCleanerMenu(user);
                    break;
                case 11:
                    user = MicrowaveMenu.microwaveMenu(user);
                    break;
                case 12:
                    user = SpeakerMenu.speakerMenu(user);
                    break;
                case 13:
                    System.out.println("cart items:\n");
                    UserService.printCart(user);
                    break;
                case 14:
                    System.out.println("Buy cart items:");
                    double sum = UserService.buyItems(user);
                    System.out.println("Sum is: " + sum);
                    System.out.println();
                    break;
                case 15:
                    UserService.writeCartToFile(user);
                    isMenuActive = false;
                    break;
                default:
                    System.out.println("\nChoose form available options\n");
                    start(user);
                    break;
            }
        }
    }
}
