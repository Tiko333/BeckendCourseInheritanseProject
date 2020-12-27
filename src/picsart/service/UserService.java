package picsart.service;

import picsart.model.electronics.Electronics;
import picsart.paths.FilePaths;
import picsart.registration.UserModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class UserService {

    private static String path = FilePaths.REGISTRATION.getValue();
    private static Map<UserModel, String> cartMap = new LinkedHashMap<>();
    private static Set<UserModel> userSet;

    private UserService() {
    }

    static {
        try {
            userSet = new HashSet<>(ConverterService.readRegistrationFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printCart(UserModel user) {
        if (cartMap.isEmpty()) {
            System.out.println("Empty:");
            return;
        }
        for (Map.Entry<UserModel, String> entry : cartMap.entrySet()) {
            UserModel key = entry.getKey();
            if (key.getUserName().equals(user.getUserName())) {
                String cart = entry.getValue();
                if (cart.isEmpty()) {
                    System.out.println("Empty:");
                    return;
                } else {
                    String[] split = cart.split(",");
                    for (String item : split) {
                        System.out.println(item.trim());
                    }
                    return;
                }
            }
        }
    }

    public static void updateCartMap() {
        for (UserModel userModel : userSet) {
            cartMap.put(userModel, userModel.getCart());
        }
    }

    public static void writeCartToFile(UserModel user) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String cart = "";
        for (Map.Entry<UserModel, String> entry : cartMap.entrySet()) {
            if (entry.getKey().getUserName().equals(user.getUserName())) {
                cart = entry.getValue();
            }
        }

        for (UserModel curUser : userSet) {
            if (curUser.getUserName().equals(user.getUserName())) {
                stringBuilder
                        .append("Full-name: ").append(curUser.getFullName())
                        .append("\nUser-name: ").append(curUser.getUserName())
                        .append("\nEmail: ").append(curUser.getEmail())
                        .append("\nPassword: ").append(curUser.getPassword())
                        .append("\nRole: ").append(curUser.getRole())
                        .append("\nDate: ").append(curUser.getLastLogin())
                        .append("\nCart: ").append(cart).append("\n\n");
                continue;
            }
            stringBuilder
                    .append("Full-name: ").append(curUser.getFullName())
                    .append("\nUser-name: ").append(curUser.getUserName())
                    .append("\nEmail: ").append(curUser.getEmail())
                    .append("\nPassword: ").append(curUser.getPassword())
                    .append("\nRole: ").append(curUser.getRole())
                    .append("\nDate: ").append(curUser.getLastLogin())
                    .append("\nCart: ").append(curUser.getCart()).append("\n\n");
        }

        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
    }

    public static void updateCartByUserName(UserModel user, Electronics item, int amount) {
        StringJoiner sj = new StringJoiner(", ");
        StringBuilder stringBuilder = new StringBuilder();
        String name = item.getClass().getName();
        String category = name.substring(name.lastIndexOf(".") + 1);
        String cart = stringBuilder
                .append("Category: ").append(category)
                .append(" ID: ").append(item.getId())
                .append(" Model: ").append(item.getModel())
                .append(" Amount: ").append(amount)
                .append(" Price: ").append(item.getPrice()).toString();


        if (cartMap.get(user) != null) {
            String s = cartMap.get(user);
            if (s.isEmpty()) {
                cartMap.put(user, cart);
                return;
            }
            String value = sj.add(s).add(cart).toString();
            cartMap.put(user, value);
            return;
        }

        cartMap.put(user, cart);
    }

    public static double buyItems(UserModel user) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<UserModel> userModels = new ArrayList<>(RegistrationService.getUserSet());
        double result = 0D;
        for (UserModel curUser : userModels) {
            if (curUser.getUserName().equals(user.getUserName())) {
                if (!curUser.getCart().isEmpty()) {
                    result = sumPrice(curUser.getCart(), 0D);
                    cartMap.clear();
                }
                stringBuilder
                        .append("Full-name: " + curUser.getFullName())
                        .append("\nUser-name: " + curUser.getUserName())
                        .append("\nEmail: " + curUser.getEmail())
                        .append("\nPassword: " + curUser.getPassword())
                        .append("\nRole: " + curUser.getRole())
                        .append("\nDate: " + curUser.getLastLogin())
                        .append("\nCart: \n\n");
                continue;
            }
            stringBuilder
                    .append("Full-name: " + curUser.getFullName())
                    .append("\nUser-name: " + curUser.getUserName())
                    .append("\nEmail: " + curUser.getEmail())
                    .append("\nPassword: " + MD5Service.md5(curUser.getPassword()))
                    .append("\nRole: " + curUser.getRole())
                    .append("\nDate: " + curUser.getLastLogin())
                    .append("\nCart: " + curUser.getCart() + "\n\n");
        }


        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
        System.out.println();
        if (!cartMap.isEmpty()) {
            result = sumPrice(cartMap.get(user), 0D);
        }

        cartMap = new LinkedHashMap<>();
        return result;
    }

    public static void updateLoginDate(UserModel user) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<UserModel> iterator1 = userSet.iterator();
        while (iterator1.hasNext()) {
            UserModel next = iterator1.next();
            if (next.getUserName().equals(user.getUserName())) {
                iterator1.remove();
            }
        }

        userSet.add(user);
        for (UserModel curUser : userSet) {
            if (curUser.getUserName().equals(user.getUserName())) {
                stringBuilder
                        .append("Full-name: " + curUser.getFullName())
                        .append("\nUser-name: " + curUser.getUserName())
                        .append("\nEmail: " + curUser.getEmail())
                        .append("\nPassword: " + curUser.getPassword())
                        .append("\nRole: " + curUser.getRole())
                        .append("\nDate: " + user.updateDate())
                        .append("\nCart: \n\n");
                continue;
            }
            stringBuilder
                    .append("Full-name: " + curUser.getFullName())
                    .append("\nUser-name: " + curUser.getUserName())
                    .append("\nEmail: " + curUser.getEmail())
                    .append("\nPassword: " + curUser.getPassword())
                    .append("\nRole: " + curUser.getRole())
                    .append("\nDate: " + curUser.getLastLogin())
                    .append("\nCart: " + curUser.getCart() + "\n\n");
        }

        Path pathObj = Paths.get(path);
        Files.newBufferedWriter(pathObj, StandardOpenOption.TRUNCATE_EXISTING);
        Files.write(Paths.get(path), stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);
        System.out.println();
    }

    public static double sumPrice(String cart, double sum) {
        int priceIndexEnd = 0;
        double cost = 0D;
        int amountIndexStart = cart.indexOf("Amount: ") + 8;
        int amountIndexEnd = cart.indexOf("Price: ") - 1;
        double amount = Double.parseDouble(cart.substring(amountIndexStart, amountIndexEnd));
        int priceIndexStart = cart.indexOf("Price: ") + 7;
        String substring = cart.substring(priceIndexStart);
        if (substring.indexOf(",") != -1) {
            priceIndexEnd = substring.indexOf(",");
        }
        if (substring.indexOf(",") == -1) {
            priceIndexEnd = cart.length() - priceIndexStart;
            cost = Double.parseDouble(substring.substring(0, priceIndexEnd));
            sum += cost * amount;
            return sum;
        }
        cost = Double.parseDouble(substring.substring(0, priceIndexEnd));
        sum += cost * amount;
        String nextCart = substring.substring(priceIndexEnd + 2);
        return sumPrice(nextCart, sum);
    }
}
