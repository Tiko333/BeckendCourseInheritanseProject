package picsart.registration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class UserModel {
    private String fullName;
    private String userName;
    private String email;
    private String password;
    private Role role;
    private String cart;
    private String lastLogin;

    public UserModel() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        lastLogin = format.format(new Date());
    }

    public String updateDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(new Date());
        lastLogin = format1;
        return format1;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Full-name: ").append(fullName).append("\n")
                .append("User-name: ").append(userName).append("\n")
                .append("Email: ").append(email).append("\n")
                .append("Password: ").append(password).append("\n")
                .append("Cart: ").append(cart).append("\n").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(fullName, userModel.fullName) &&
                Objects.equals(userName, userModel.userName) &&
                Objects.equals(email, userModel.email) &&
                Objects.equals(password, userModel.password) &&
                role == userModel.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, userName, email, password, role);
    }
}
