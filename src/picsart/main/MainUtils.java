package picsart.main;

import picsart.registration.Role;
import picsart.registration.UserModel;

public class MainUtils {
    public static void printOptions(UserModel user) {
        StringBuilder sb = new StringBuilder();
        if (user.getRole() == Role.ADMIN) {
            sb.append("1. add\n")
                    .append("2. multiple add\n")
                    .append("3. update by id\n")
                    .append("4. delete by id\n")
                    .append("5. delete all\n")
                    .append("6. newer\n")
                    .append("7. older\n")
                    .append("8. bigger cost\n")
                    .append("9. smaller cost\n")
                    .append("10. newer added\n")
                    .append("11. older added\n")
                    .append("12. ascending order by price\n")
                    .append("13. descending order by price\n")
                    .append("14. ascending order by year\n")
                    .append("15. descending order by year\n")
                    .append("16. ascending order by adding date\n")
                    .append("17. descending order by adding date\n")
                    .append("18. print all\n")
                    .append("19. find by ID\n")
                    .append("20. find by model\n")
                    .append("21. find by Year\n")
                    .append("22. find by adding date\n")
                    .append("23. find by price range\n")
                    .append("24. find model by year\n")
                    .append("25. find model by adding date\n")
                    .append("26. find model by price range\n")
                    .append("27. back\n");
        }
        if (user.getRole() == Role.USER) {
            sb.append("1. newer\n")
                    .append("2. older\n")
                    .append("3. bigger cost\n")
                    .append("4. smaller cost\n")
                    .append("5. newer added\n")
                    .append("6. older added\n")
                    .append("7. ascending order by price\n")
                    .append("8. descending order by price\n")
                    .append("9. ascending order by year\n")
                    .append("10. descending order by year\n")
                    .append("11. ascending order by adding date\n")
                    .append("12. descending order by adding date\n")
                    .append("13. print all\n")
                    .append("14. find by ID\n")
                    .append("15. find by model\n")
                    .append("16. find by Year\n")
                    .append("17. find by adding date\n")
                    .append("18. find by price range\n")
                    .append("19. find model by year\n")
                    .append("20. find model by adding date\n")
                    .append("21. find model by price range\n")
                    .append("22. add to cart by ID\n")
                    .append("23. show cart items\n")
                    .append("24. buy cart items\n")
                    .append("25. back\n");
        }

        System.out.println(sb);
    }
}
