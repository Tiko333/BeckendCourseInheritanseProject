package picsart.main.computersMenu;

import picsart.main.computersMenu.computerMenu.ComputerMenu;
import picsart.main.computersMenu.laptopMenu.LaptopMenu;
import picsart.registration.UserModel;

import java.io.IOException;
import java.util.Scanner;

public class ComputersMenu {
    public static UserModel computersMenu(UserModel user) throws IOException {
        boolean isMenuActive = true;
        UserModel returnUserModel = user;
        while (isMenuActive) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n\nComputers menu:        user: ").append(user.getFullName()).append("\n\n")
                    .append("1. computers\n")
                    .append("2. laptops\n")
                    .append("3. back\n");
            System.out.println(sb);
            Scanner s = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter command number:");
            int i = s.nextInt();
            switch (i) {
                case 1:
                    System.out.println("\ncomputers:\n");
                    returnUserModel = ComputerMenu.computerMenu(user);
                    break;
                case 2:
                    System.out.println("\nlaptops:\n");
                    returnUserModel = LaptopMenu.laptopMenu(user);
                    break;
                case 3:
                    isMenuActive = false;
                    System.out.println("Exit computers menu:\n");
                    break;
                default:
                    System.out.println("\nChoose form available options");
                    computersMenu(user);
            }

        }
        return returnUserModel;
    }
}
