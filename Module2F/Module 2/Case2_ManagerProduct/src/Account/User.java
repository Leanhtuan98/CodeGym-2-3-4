package Account;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String userName;
    private String passWord;
    private String role;
    private Role role1;
    private ArrayList<User> cart;

    public User(String userName, String passWord, ArrayList<User> cart) {
        this.userName = userName;
        this.passWord = passWord;
        this.cart = cart;
    }

    public ArrayList<User> getCart() {
        return cart;
    }

    public void setCart(ArrayList<User> cart) {
        this.cart = cart;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role getRole1() {
        return role1;
    }

    public void setRole1(Role role1) {
        this.role1 = role1;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public void showAccount() {
        if (userName == null && passWord == null) {
            System.err.println("No account!");
        } else {
            System.out.printf("Account has: ",userName,passWord);
        }
    }
}
