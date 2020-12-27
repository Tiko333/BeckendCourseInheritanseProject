package picsart.service;

import picsart.comparators.userModelComparators.DateComparator;
import picsart.paths.FilePaths;
import picsart.registration.Role;
import picsart.registration.UserModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class RegistrationService {
    private static String path = FilePaths.REGISTRATION.getValue();
    private static Set<UserModel> userSet;

    static {
        try {
            userSet = new HashSet<>(ConverterService.readRegistrationFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static UserModel register() throws IOException {
        System.out.println("Registration");
        String fullName = getFullName();
        String userName = getUserName();
        String email = getEmail();
        String password = MD5Service.md5(getPassword());
        while (checkUser(userName)) {
            System.out.println("User by that user name already exist");
            userName = getUserName();
        }
        UserModel newUser = new UserModel();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Full-name: " + fullName)
                .append("\nUser-name: " + userName)
                .append("\nEmail: " + email)
                .append("\nPassword: " + password)
                .append("\nRole: " + Role.USER)
                .append("\nDate: " + newUser.getLastLogin())
                .append("\nCart: \n\n");

        File file = new File(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        newUser.setFullName(fullName);
        newUser.setUserName(userName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setRole(Role.USER);

        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
        userSet.add(newUser);
        return newUser;
    }

    public static UserModel login() {
        List<UserModel> userModels = new ArrayList<>(userSet);
        if (userModels.size() >= 5) {
            System.out.println("\nLast 5 logins:");
        }
        if (userModels.size() < 5 && userModels.size() > 1){
            System.out.println(new StringBuilder("\nLast ").append(userModels.size()).append(" logins:").toString());
        }
        if (userModels.size() == 1) {
            System.out.println("\nLast 1 login:");
        }
        if (!userModels.isEmpty()) {
            userModels.sort(new DateComparator());
            for (int i = 0; i < userModels.size(); i++) {
                UserModel user = userModels.get(i);
                System.out.println(user.getUserName());
                if (i == 4) {
                    break;
                }
            }
        }

        System.out.println("\nLogin");
        String userName = getUserName();
        String password = MD5Service.md5(getPassword());
        for (UserModel user : userSet) {
            String setUserName = user.getUserName();
            String setPassword = user.getPassword();
            if (setUserName.equals(userName) && setPassword.equals(password)){
                return user;
            }
        }
        return null;
    }

    public static boolean checkUser(String userName) {
        for (UserModel user : userSet) {
            if (user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public static boolean isFullName(String fullName) {
        String expression = "^([A-z\\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$";
        return fullName.matches(expression);
    }

    public static boolean isUserName(String userName) {
//        "username(length > 10 && not duplicate)"
//        String expression = "^[A-Za-z]\\w{9,}$";
        String expression = "^\\w{9,}$";
        return userName.matches(expression);
    }

    public static boolean isEmail(String email) {
        String expression = "^(.+)@(.+)$";
        return email.matches(expression);
    }

    public static boolean isPassword(String password) {
        String expression = "^(?=.*[0-9]{3})"
                + "(?=.*[a-z])(?=.*[A-Z]{2})"
                + "(?=\\S+$).{8,}$";
        return password.matches(expression);
    }

    public static String getFullName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full name format: Name Surname");
        String fullName = scanner.nextLine();
        while (!isFullName(fullName)) {
            System.out.println("format: Name Surname");
            fullName = scanner.nextLine();
        }

        return fullName;
    }

    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: more than 10 characters");
        String userName = scanner.nextLine();
        while (!isUserName(userName)) {
            System.out.println("Username: must be more than 10 characters");
            userName = scanner.nextLine();
        }

        return userName;
    }

    public static String getEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter email");
        String email = scanner.nextLine();
        while (!isEmail(email)) {
            System.out.println("Enter valid email");
            email = scanner.nextLine();
        }

        return email;
    }

    public static String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password: length must be bigger than 8, must have 2 uppercase letters and 3 numbers");
        String password = scanner.nextLine();
        while (!isPassword(password)) {
            System.out.println("Password length must be bigger than 8, must have 2 uppercase letters and 3 numbers)");
            password = scanner.nextLine();
        }

        return password;
    }

    public static Set<UserModel> getUserSet() {
        return userSet;
    }
}
