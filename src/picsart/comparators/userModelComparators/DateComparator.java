package picsart.comparators.userModelComparators;

import picsart.registration.UserModel;

import java.time.LocalDateTime;
import java.util.Comparator;

public class DateComparator implements Comparator<UserModel> {
    @Override
    public int compare(UserModel o1, UserModel o2) {
        String lastLogin = o1.getLastLogin();
        String[] s = lastLogin.split(" ");
        String date = s[0] + "T" + s[1];
        LocalDateTime dateTime = LocalDateTime.parse(date);

        String lastLogin1 = o2.getLastLogin();
        String[] s1 = lastLogin1.split(" ");
        String date1 = s1[0] + "T" + s1[1];
        LocalDateTime dateTime1 = LocalDateTime.parse(date1);
        return dateTime1.compareTo(dateTime);
    }
}
